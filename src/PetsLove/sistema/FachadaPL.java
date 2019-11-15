package PetsLove.sistema;

import java.util.ArrayList;
import PetsLove.sistema.dados.RepositorioAnimais;
import PetsLove.sistema.dados.RepositorioUsuarios;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import PetsLove.sistema.negocios.ControladorAnimal;
import PetsLove.sistema.negocios.ControladorUsuario;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Usuario;

public class FachadaPL {

	private static FachadaPL instance;
	private static Usuario usuarioLogado;

	private ControladorAnimal controladorAnimal;
	private ControladorUsuario controladorUsuario;

	private FachadaPL() {
		this.controladorAnimal = new ControladorAnimal(RepositorioAnimais.getInstance());
		this.controladorUsuario = new ControladorUsuario(RepositorioUsuarios.getInstance());
	}

	public static FachadaPL getInstance() {
		if (instance == null) {
			instance = new FachadaPL();
		}
		return instance;
	}
	
	
	
	
	public Usuario login(String email, String senha) {
		if(usuarioLogado == null) {
			usuarioLogado = this.controladorUsuario.login(email, senha);
		}
		return usuarioLogado;
	}
	
	public void logout() {
		if(usuarioLogado != null) {
			usuarioLogado = null;
		}
	}

	public void cadastrarUsuario(Usuario usuario) throws UsuarioJaExisteException {
		this.controladorUsuario.cadastrar(usuario);
	}

	public void atualizarUsuario(Usuario usuario) throws UsuarioNaoExisteException {
		this.controladorUsuario.atualizar(usuario);
	}


	
	
	public void cadastrarAnimal(Animal animal) {
		this.controladorAnimal.cadastrar(animal);
	}

	public void atualizarAnimal(Animal animal) {
		this.controladorAnimal.atualizar(animal);
	}
	
	public ArrayList<Animal> listarAnimais() {
		return this.controladorAnimal.listar();
	}
	
	public ArrayList<Animal> listarAnimaisPorDono(Usuario usuario) {
		return this.controladorAnimal.listarPorDono(usuario);
	}

	public ArrayList<Animal> listarAnimaisPorTipo(Class<?> tipo) {
		return this.controladorAnimal.listarPorTipo(tipo);
	}

	public ArrayList<Animal> listarCachorrosPorRaca(String raca) throws RacaNaoExisteException {
		return this.controladorAnimal.listarCachorrosPorRaca(raca);
	}

	public ArrayList<Animal> listarCachorrosPorTamanho(String tamanho) {
		return this.controladorAnimal.listarCachorrosPorTamanho(tamanho);
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(String raca, String tamanho) throws RacaNaoExisteException {
		return this.controladorAnimal.listarCachorrosPorRacaETamanho(raca, tamanho);
	}

	public ArrayList<Animal> listarGatosPorPelagem(String pelagem) {
		return this.controladorAnimal.listarGatosPorPelagem(pelagem);
	}

}
