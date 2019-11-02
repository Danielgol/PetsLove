package PetsLove.sistema.negocios;

import PetsLove.sistema.dados.IRepositorioUsuarios;
import PetsLove.sistema.negocios.beans.Usuario;

public class ControladorUsuario {
	
	private IRepositorioUsuarios repositorioUsuarios;
	
	public ControladorUsuario(IRepositorioUsuarios instanciaRepositorio) {
        this.repositorioUsuarios = instanciaRepositorio; 
    }
	
	//TODO: Colocar as regras de negócio em cada um dos métodos abaixo.
	public void cadastrar(Usuario usuario) {
		this.repositorioUsuarios.cadastrar(usuario);
	}
	
	public void remover(Usuario usuario) {
		this.repositorioUsuarios.remover(usuario);
	}
	
	public void atualizar(Usuario usuario) {
		this.repositorioUsuarios.atualizar(usuario);
	}

}
