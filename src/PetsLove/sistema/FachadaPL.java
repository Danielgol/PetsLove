package PetsLove.sistema;

import PetsLove.sistema.dados.RepositorioUsuarios;
import PetsLove.sistema.negocios.ControladorUsuario;
import PetsLove.sistema.negocios.beans.Usuario;

public class FachadaPL {

	private static FachadaPL instance;
	
	private ControladorUsuario controladorUsuario;
	
	private FachadaPL () {
		this.controladorUsuario = new ControladorUsuario(RepositorioUsuarios.getInstance());
	}
	
	public static FachadaPL getInstance() {
        if (instance == null) {
            instance = new FachadaPL();
        }
        return instance;
    }
	
	public void cadastrarUsuario(Usuario usuario) {
		this.controladorUsuario.cadastrar(usuario);
	}
	
	public void removerUsuario(Usuario usuario) {
		this.controladorUsuario.remover(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario) {
		this.controladorUsuario.atualizar(usuario);
	}
	
}
