package PetsLove.sistema.negocios;

import PetsLove.sistema.dados.IRepositorioSolicitacoes;
import PetsLove.sistema.exceptions.SolicitacaoJaExisteException;
import PetsLove.sistema.exceptions.SolicitacaoNaoExisteException;
import PetsLove.sistema.negocios.beans.Solicitacao;

public class ControladorSolicitacao {

	private IRepositorioSolicitacoes repositorioSolicitacoes;

	public ControladorSolicitacao(IRepositorioSolicitacoes instanciaRepositorio) {
		this.repositorioSolicitacoes = instanciaRepositorio;
	}

	public void CriarSolicitacao(Solicitacao s) throws SolicitacaoJaExisteException {
		if (s == null) {
			throw new IllegalArgumentException("Parâmetro inválido");
		} else if (!this.existe(s)) {
			repositorioSolicitacoes.CriarSolicitacao(s);
		} else {
			throw new SolicitacaoJaExisteException(s.getRemetente(), s.getDestinatario());
		}
	}

	public void RemoverSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		Solicitacao s1 = s;
		if (s1 != null) {
			repositorioSolicitacoes.RemoverSolicitacao(s);
		} else {
			throw new SolicitacaoNaoExisteException(s.getRemetente(), s.getDestinatario());
		}
	}

	public void AceitarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		Solicitacao s1 = s;
		if (s1 != null) {
			repositorioSolicitacoes.AceitarSolicitacao(s);
		} else {
			throw new SolicitacaoNaoExisteException(s.getRemetente(), s.getDestinatario());
		}

	}

	public void RecusarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		Solicitacao s1 = s;
		if (s1 != null) {
			repositorioSolicitacoes.RecusarSolicitacao(s);
		} else {
			throw new SolicitacaoNaoExisteException(s.getRemetente(), s.getDestinatario());
		}

	}

	public void atualizar(Solicitacao s) throws SolicitacaoNaoExisteException {
		this.repositorioSolicitacoes.atualizar(s);
	}

	public boolean existe(Solicitacao s) {
		return this.repositorioSolicitacoes.existe(s);
	}

}
