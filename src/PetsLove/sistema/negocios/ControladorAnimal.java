package PetsLove.sistema.negocios;

import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioAnimais;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Usuario;

public class ControladorAnimal {

	private IRepositorioAnimais repositorioAnimais;

	public ControladorAnimal(IRepositorioAnimais instanciaRepositorio) {
		this.repositorioAnimais = instanciaRepositorio;
	}
	
	// TODO: Colocar as regras de negócio em cada um dos métodos abaixo.
	
	public void cadastrar(Animal animal) {
		this.repositorioAnimais.cadastrar(animal);
	}
	
	public void atualizar(Animal animal) {
		this.repositorioAnimais.atualizar(animal);
	}

	public ArrayList<Animal> listar() {
		return this.repositorioAnimais.listar();
	}
	
	public ArrayList<Animal> listarPorDono(Usuario usuario) {
		ArrayList<Animal> animais = this.listar();
		for (Animal animal : animais) {
			if (!animal.getDono().equals(usuario)) {
				animais.remove(animal);
			}
		}
		return animais;
	}

	public ArrayList<Animal> listarPorTipo(Class<?> tipo) {
		ArrayList<Animal> animais = this.listar();
		for (Animal animal : animais) {
			if (animal.getClass() != tipo) {
				animais.remove(animal);
			}
		}
		return animais;
	}
	
	public ArrayList<Animal> listarCachorrosPorRaca(String raca) throws RacaNaoExisteException {
		ArrayList<Animal> cachorros = this.listarPorTipo(Cachorro.class);
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
		ArrayList<Animal> cachorros = this.listarPorTipo(Cachorro.class);
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
		ArrayList<Animal> gatos = this.listarPorTipo(Gato.class);
		for (Animal gato : gatos) {
			if (((Gato) gato).getPelagem().equals(pelagem)) {
				gatos.add(gato);
			}
		}
		return gatos;
	}

}
