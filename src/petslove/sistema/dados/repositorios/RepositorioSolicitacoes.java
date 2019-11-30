package petslove.sistema.dados.repositorios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import petslove.sistema.dados.IRepositorioSolicitacoes;
import petslove.sistema.negocios.beans.Solicitacao;

public class RepositorioSolicitacoes implements IRepositorioSolicitacoes {

	private static RepositorioSolicitacoes instance;

	private ArrayList<Solicitacao> solicitacoes;

	private RepositorioSolicitacoes(String arquivo) {
		lerArquivo(arquivo);
	}

	public static IRepositorioSolicitacoes getInstance() {
		if (instance == null) {
			instance = new RepositorioSolicitacoes("Arquivos/solicitacoes.csv");
		}
		return instance;
	}

	public void criarSolicitacao(Solicitacao solicitacao) {
		this.solicitacoes.add(solicitacao);
		atualizarBanco();
	}

	public void removerSolicitacao(Solicitacao solicitacao) {
		this.solicitacoes.remove(solicitacao);
		atualizarBanco();
	}

	public void aceitarSolicitacao(Solicitacao solicitacao) {
		solicitacao.setStatus(Solicitacao.ACEITO);
		atualizarBanco();
	}

	public void recusarSolicitacao(Solicitacao solicitacao) {
		solicitacao.setStatus(Solicitacao.RECUSADO);
		atualizarBanco();
	}

	public boolean existe(Solicitacao s) {
		if (solicitacoes.contains(s)) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Solicitacao> listar(){
		return this.solicitacoes;
	}

	public void atualizarBanco() {
		try {
			FileWriter csvWriter = new FileWriter("Arquivos/solicitacoes.csv");
			for(Solicitacao s : this.solicitacoes) {
				csvWriter.append(s.getIdRemetente());
				csvWriter.append(",");
				csvWriter.append(s.getIdDestinatario());
				csvWriter.append(",");
				csvWriter.append(s.getEmailDonoRemetente());
				csvWriter.append(",");
				csvWriter.append(s.getEmailDonoDestinatario());
				csvWriter.append(",");
				csvWriter.append(s.getStatus());
				csvWriter.append("\n");
			}
			csvWriter.close();
		}catch(IOException e) {}
	}

	public void lerArquivo(String arquivo) {
		this.solicitacoes = new ArrayList<Solicitacao>();
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(arquivo));
			String row = "";
			try {
				while((row = csvReader.readLine()) != null && !row.equals("")){
					String[] dados = row.split(",");
					Solicitacao solicitacao = new Solicitacao(dados[0], dados[1], dados[2], dados[3], dados[4]);
					solicitacoes.add(solicitacao);
				}
				csvReader.close();
			}catch (IOException e) {}
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}
	}

}
