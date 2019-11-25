package PetsLove.sistema.dados.Repositorios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioSolicitacoes;
import PetsLove.sistema.negocios.beans.Solicitacao;

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

	public void criarSolicitacao(Solicitacao s) {
		this.solicitacoes.add(s);
	}

	public void removerSolicitacao(Solicitacao s) {
		this.solicitacoes.remove(s);
	}

	public void aceitarSolicitacao(Solicitacao s) {
		s.setStatus(Solicitacao.ACEITO);
	}

	public void recusarSolicitacao(Solicitacao s) {
		s.setStatus(Solicitacao.RECUSADO);
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

	//TODO: Fazer Leitura e Escrita das solicitacoes (Reformular atributos solicitacoes)
	
	public void atualizarBanco() {
		try {
			FileWriter csvWriter = new FileWriter("Arquivos/usuarios.csv");
			for(Solicitacao s : this.solicitacoes) {
				/*
				csvWriter.append(s.getRemetente());
				csvWriter.append(",");
				csvWriter.append(s.getDestinatario());
				csvWriter.append(",");
				csvWriter.append(s.getIdRemetente());
				csvWriter.append(",");
				csvWriter.append(s.getIdDestinatario());
				csvWriter.append("\n");
				*/
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
				while((row = csvReader.readLine()) != null){
					String[] dados = row.split(",");
					//Solicitacao solicitacao = new Solicitacao(dados[0], dados[1], dados[2], dados[3]);
					//solicitacoes.add(solicitacao);
				}
				csvReader.close();
			}catch (IOException e) {}
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}
	}

}
