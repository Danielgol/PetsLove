package petslove.sistema.dados;

import java.util.ArrayList;

import petslove.sistema.exceptions.SolicitacaoNaoExisteException;
import petslove.sistema.negocios.beans.Solicitacao;

public interface IRepositorioSolicitacoes {

	public void criarSolicitacao(Solicitacao s);
	public void removerSolicitacao(Solicitacao s);
	public boolean existe(Solicitacao s);
	public void aceitarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException;
	public void recusarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException;
	public ArrayList<Solicitacao> listar();

}
