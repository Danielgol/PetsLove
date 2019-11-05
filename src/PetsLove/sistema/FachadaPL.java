package PetsLove.sistema;

import java.util.ArrayList;

import PetsLove.sistema.dados.RepositorioUsuarios;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import PetsLove.sistema.negocios.ControladorUsuario;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Usuario;

public class FachadaPL {

	private static FachadaPL instance;

	private ControladorUsuario controladorUsuario;

	private FachadaPL() {
		this.controladorUsuario = new ControladorUsuario(RepositorioUsuarios.getInstance());
	}

	public static FachadaPL getInstance() {
		if (instance == null) {
			instance = new FachadaPL();
		}
		return instance;
	}

	public void cadastrarUsuario(Usuario usuario) throws UsuarioJaExisteException {
		this.controladorUsuario.cadastrar(usuario);
	}

	public void removerUsuario(Usuario usuario) throws UsuarioNaoExisteException {
		this.controladorUsuario.remover(usuario);
	}

	public void atualizarUsuario(Usuario usuario) throws UsuarioNaoExisteException {
		this.controladorUsuario.atualizar(usuario);
	}

	public ArrayList<Usuario> listarUsuarios() {
		return this.controladorUsuario.listar();
	}

	public ArrayList<Animal> listarAnimais() {
		return this.controladorUsuario.listarAnimais();
	}

	public ArrayList<Animal> listarAnimaisPorTipo(Class<?> tipo) {
		return this.controladorUsuario.listarAnimaisPorTipo(tipo);
	}

	public ArrayList<Animal> listarCachorrosPorRaca(String raca) throws RacaNaoExisteException {
		return this.controladorUsuario.listarCachorrosPorRaca(raca);
	}

	public ArrayList<Animal> listarCachorrosPorTamanho(String tamanho) {
		return this.controladorUsuario.listarCachorrosPorTamanho(tamanho);
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(String raca, String tamanho) throws RacaNaoExisteException {
		return this.controladorUsuario.listarCachorrosPorRacaETamanho(raca, tamanho);
	}

	public ArrayList<Animal> listarGatosPorPelagem(String pelagem) {
		return this.controladorUsuario.listarGatosPorPelagem(pelagem);
	}

}
