package PetsLove.sistema.dados;

import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import PetsLove.sistema.negocios.beans.Usuario;

public interface IRepositorioUsuarios {
	
	public void cadastrar(Usuario usuario);
	public void remover(Usuario usuario) throws UsuarioNaoExisteException;
	public void atualizar(Usuario usuario) throws UsuarioNaoExisteException;
	public boolean existe(String email);
	public Usuario procurar(String email);

}
