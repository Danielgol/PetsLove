package PetsLove.sistema.dados.Repositorios;

import java.util.ArrayList;

import PetsLove.sistema.dados.IRepositorioUsuarios;
import PetsLove.sistema.negocios.beans.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuarios {

	private static RepositorioUsuarios instance;

	private ArrayList<Usuario> usuarios;
	
	private RepositorioUsuarios() {
        this.usuarios = new ArrayList<Usuario>();
    }

	public static IRepositorioUsuarios getInstance() {
		if (instance == null) {
			// TODO: Decidir como os usuarios serão guardados (Bloco de notas, ...)
			instance = new RepositorioUsuarios();
		}
		return instance;
	}

	public void cadastrar(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void remover(Usuario usuario) {
		this.usuarios.remove(usuario);
	}

	public void atualizar(Usuario usuario) {
		int indexUsuario = this.usuarios.indexOf(usuario);
		this.usuarios.set(indexUsuario, usuario);
	}
	
	public Usuario procurar(String email) {
		for(Usuario user : this.usuarios) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	public boolean existe(String email) {
		return this.procurar(email) != null;
	}

}
