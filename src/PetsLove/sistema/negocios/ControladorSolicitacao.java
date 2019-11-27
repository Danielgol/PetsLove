package PetsLove.sistema.negocios;

import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioSolicitacoes;
import PetsLove.sistema.exceptions.SolicitacaoJaExisteException;
import PetsLove.sistema.exceptions.SolicitacaoNaoExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;

public class ControladorSolicitacao {

	private IRepositorioSolicitacoes repositorioSolicitacoes;

	public ControladorSolicitacao(IRepositorioSolicitacoes instanciaRepositorio) {
		this.repositorioSolicitacoes = instanciaRepositorio;
	}

	public ArrayList<Solicitacao> listarSolicitacoesEnviadas(Usuario usuario) {
		ArrayList<Solicitacao> repo = this.repositorioSolicitacoes.listar();
		ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		for(Solicitacao solicitacao : repo) {
			if(solicitacao.getEmailDonoRemetente().equals(usuario.getEmail())) {
				solicitacoes.add(solicitacao);
			}
		}
		return solicitacoes;
	}

	public ArrayList<Solicitacao> listarSolicitacoesRecebidas(Usuario usuario) {
		ArrayList<Solicitacao> repo = this.repositorioSolicitacoes.listar();
		ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		for(Solicitacao solicitacao : repo) {
			if(solicitacao.getEmailDonoDestinatario().equals(usuario.getEmail()) && !solicitacao.getStatus().equals(Solicitacao.RECUSADO)) {
				solicitacoes.add(solicitacao);
			}
		}
		return solicitacoes;
	}

	public void removerSolicitacoesComAnimal(Animal animal) {
		ArrayList<Solicitacao> remover = new ArrayList<Solicitacao>();
		for(Solicitacao solicitacao : this.repositorioSolicitacoes.listar()) {
			if(solicitacao.getIdRemetente().equals(animal.getId()) || solicitacao.getIdDestinatario().equals(animal.getId())) {
				remover.add(solicitacao);
			}
		}
		for(Solicitacao solicitacao : remover) {
			this.repositorioSolicitacoes.removerSolicitacao(solicitacao);
		}
	}

	public void criarSolicitacao(Solicitacao solicitacao) throws SolicitacaoJaExisteException {
		if (solicitacao == null) {
			throw new IllegalArgumentException("Parâmetro inválido");
		} else if (!this.existe(solicitacao)) {
			repositorioSolicitacoes.criarSolicitacao(solicitacao);
		} else {
			throw new SolicitacaoJaExisteException(solicitacao.getIdRemetente(), solicitacao.getIdDestinatario());
		}
	}

	public void removerSolicitacao(Solicitacao solicitacao) throws SolicitacaoNaoExisteException {
		Solicitacao s1 = solicitacao;
		if(s1 != null) {
			this.repositorioSolicitacoes.removerSolicitacao(solicitacao);
		}else {
			throw new SolicitacaoNaoExisteException(solicitacao.getIdRemetente(), solicitacao.getIdDestinatario());
		}
	}

	public void aceitarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		Solicitacao s1 = s;
		if (s1 != null) {
			repositorioSolicitacoes.aceitarSolicitacao(s);
		} else {
			throw new SolicitacaoNaoExisteException(s.getIdRemetente(), s.getIdDestinatario());
		}
	}

	public void recusarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		Solicitacao s1 = s;
		if(s1 != null) {
			repositorioSolicitacoes.recusarSolicitacao(s);
		}else {
			throw new SolicitacaoNaoExisteException(s.getIdRemetente(), s.getIdDestinatario());
		}
	}

	public boolean existe(Solicitacao s) {
		return this.repositorioSolicitacoes.existe(s);
	}

}
