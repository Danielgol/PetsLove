package PetsLove.sistema.dados;

import PetsLove.sistema.exceptions.SolicitacaoNaoExisteException;
import PetsLove.sistema.negocios.beans.Solicitacao;

public interface IRepositorioSolicitacoes {

	public void CriarSolicitacao(Solicitacao s);
	public void RemoverSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException;
	public boolean existe(Solicitacao s);
	public void atualizar(Solicitacao s) throws SolicitacaoNaoExisteException;
	public void AceitarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException;
	public void RecusarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException;

}
