package petslove.sistema.dados;

import petslove.sistema.exceptions.UsuarioNaoExisteException;
import petslove.sistema.negocios.beans.Usuario;

public interface IRepositorioUsuarios {
	
	public void cadastrar(Usuario usuario);
	public void remover(Usuario usuario) throws UsuarioNaoExisteException;
	public void atualizar(Usuario usuario) throws UsuarioNaoExisteException;
	public boolean existe(String email);
	public Usuario procurar(String email);

}
