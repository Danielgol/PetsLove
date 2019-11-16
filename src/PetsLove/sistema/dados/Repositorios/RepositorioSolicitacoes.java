package PetsLove.sistema.dados.Repositorios;

import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioSolicitacoes;
import PetsLove.sistema.negocios.beans.Solicitacao;

public class RepositorioSolicitacoes implements IRepositorioSolicitacoes {

	private static RepositorioSolicitacoes instance;

	private ArrayList<Solicitacao> solicitacoes;
	
	private RepositorioSolicitacoes() {
		this.solicitacoes = new ArrayList<Solicitacao>();
	}

	public static IRepositorioSolicitacoes getInstance() {
		if (instance == null) {
			// TODO: Decidir como as solicitações serão guardadas.
			instance = new RepositorioSolicitacoes();
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
	
}
