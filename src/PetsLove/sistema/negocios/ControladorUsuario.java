package PetsLove.sistema.negocios;

import PetsLove.sistema.dados.IRepositorioUsuarios;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import PetsLove.sistema.negocios.beans.Usuario;

public class ControladorUsuario {

	private IRepositorioUsuarios repositorioUsuarios;

	public ControladorUsuario(IRepositorioUsuarios instanciaRepositorio) {
		this.repositorioUsuarios = instanciaRepositorio;
	}
	
	public Usuario login(String email, String senha) {
		Usuario usuario = this.procurar(email);
		if(usuario.getSenha().equals(senha)) {
			return usuario;
		}
		return null;
	}

	public void cadastrar(Usuario usuario) throws UsuarioJaExisteException {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro inválido");
		} else if (!this.existe(usuario.getEmail())) {
			this.repositorioUsuarios.cadastrar(usuario);
		} else {
			throw new UsuarioJaExisteException(usuario.getEmail());
		}
	}

	public void remover(Usuario usuario) throws UsuarioNaoExisteException {
		Usuario u1 = this.repositorioUsuarios.procurar(usuario.getEmail());
		if (u1 != null) {
			this.repositorioUsuarios.remover(usuario);
		} else {
			throw new UsuarioNaoExisteException(usuario.getEmail());
		}
	}

	public void atualizar(Usuario usuario) throws UsuarioNaoExisteException {
		this.repositorioUsuarios.atualizar(usuario);
	}

	public boolean existe(String email) {
		return this.repositorioUsuarios.existe(email);
	}

	public Usuario procurar(String email) {
		return this.repositorioUsuarios.procurar(email);
	}
	
}
