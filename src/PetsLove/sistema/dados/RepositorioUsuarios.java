package PetsLove.sistema.dados;

import java.util.ArrayList;
import PetsLove.sistema.negocios.beans.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuarios {

	private static RepositorioUsuarios instance;
	
	private ArrayList<Usuario> usuarios;

	public static IRepositorioUsuarios getInstance() {
		if (instance == null) {
			//TODO: Decidir como os usuarios serão guardados (Bloco de notas, ...)
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

	public ArrayList<Usuario> listar() {
		return this.usuarios;
	}

}
