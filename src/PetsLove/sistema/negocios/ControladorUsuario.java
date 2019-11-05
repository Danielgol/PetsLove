package PetsLove.sistema.negocios;

import java.util.ArrayList;

import PetsLove.sistema.dados.IRepositorioUsuarios;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Usuario;

public class ControladorUsuario {

	private IRepositorioUsuarios repositorioUsuarios;

	public ControladorUsuario(IRepositorioUsuarios instanciaRepositorio) {
		this.repositorioUsuarios = instanciaRepositorio;
	}

	// TODO: Colocar as regras de negócio em cada um dos métodos abaixo.

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

	public ArrayList<Usuario> listar() {
		return this.repositorioUsuarios.listar();
	}

	public ArrayList<Animal> listarAnimais() {
		ArrayList<Usuario> usuarios = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for (Usuario user : usuarios) {
			for (Animal animal : user.getAnimais()) {
				animais.add(animal);
			}
		}
		return animais;
	}

	public ArrayList<Animal> listarAnimaisPorTipo(Class<?> tipo) {
		ArrayList<Usuario> usuarios = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for (Usuario user : usuarios) {
			for (Animal animal : user.getAnimais()) {
				if (animal.getClass() == tipo) {
					animais.add(animal);
				}
			}
		}
		return animais;
	}

	public ArrayList<Animal> listarCachorrosPorRaca(String raca) throws RacaNaoExisteException {
		ArrayList<Animal> cachorros = this.listarAnimaisPorTipo(Cachorro.class);
		if (raca != null) {
			boolean achou = false;
			for (Animal cachorro : cachorros) {
				if (((Cachorro) cachorro).getRaca().equals(raca)) {
					cachorros.add(cachorro);
					achou = true;
				}
			}
			if (!achou) {
				throw new RacaNaoExisteException(raca);
			}
			return cachorros;
		} else {
			throw new IllegalArgumentException("Parâmetro inválido");
		}
	}

	public ArrayList<Animal> listarCachorrosPorTamanho(String tamanho) {
		ArrayList<Animal> cachorros = this.listarAnimaisPorTipo(Cachorro.class);
		for (Animal cachorro : cachorros) {
			if (((Cachorro) cachorro).getTamanho().equals(tamanho)) {
				cachorros.add(cachorro);
			}
		}
		return cachorros;
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(String raca, String tamanho) throws RacaNaoExisteException {
		ArrayList<Animal> cachorros = this.listarCachorrosPorRaca(raca);
		for (Animal cachorro : cachorros) {
			if (!((Cachorro) cachorro).getTamanho().equals(tamanho)) {
				cachorros.remove(cachorro);
			}
		}
		return cachorros;
	}

	public ArrayList<Animal> listarGatosPorPelagem(String pelagem) {
		ArrayList<Animal> gatos = this.listarAnimaisPorTipo(Gato.class);
		for (Animal gato : gatos) {
			if (((Gato) gato).getPelagem().equals(pelagem)) {
				gatos.add(gato);
			}
		}
		return gatos;
	}

	public boolean existe(String email) {
		return this.repositorioUsuarios.existe(email);
	}

	public Usuario procurar(String email) {
		return this.repositorioUsuarios.procurar(email);
	}
}
