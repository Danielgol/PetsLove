package PetsLove.sistema.dados.Repositorios;

import java.util.ArrayList;

import PetsLove.sistema.dados.IRepositorioSolicitacoes;
import PetsLove.sistema.negocios.beans.Solicitacao;

public class RepositorioSolicitacoes implements IRepositorioSolicitacoes {

	private static RepositorioSolicitacoes instance;

	private ArrayList<Solicitacao> solicitacoes;

	public static IRepositorioSolicitacoes getInstance() {
		if (instance == null) {
			// TODO: Decidir como as solicitações serão guardadas.
			instance = new RepositorioSolicitacoes();
		}
		return instance;
	}

	public void CriarSolicitacao(Solicitacao s) {
		this.solicitacoes.add(s);
	}

	public void RemoverSolicitacao(Solicitacao s) {
		this.solicitacoes.remove(s);
	}
	
	public void AceitarSolicitacao(Solicitacao s) {
		s.setStatus("Aceitado");
	}
	
	public void RecusarSolicitacao(Solicitacao s) {
		s.setStatus("Recusado");
	}
	
	public void atualizar(Solicitacao s) {
		int indexUsuario = this.solicitacoes.indexOf(s);
		this.solicitacoes.set(indexUsuario, s);
	}
	
	public boolean existe(Solicitacao s) {
		if (solicitacoes.contains(s)) {
			return true;
		} else {
			return false;
		}
	}
	
}
