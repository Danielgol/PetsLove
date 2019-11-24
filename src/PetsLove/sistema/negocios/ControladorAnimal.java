package PetsLove.sistema.negocios;

import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioAnimais;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.EnumPelagem;
import PetsLove.sistema.negocios.beans.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.EnumSexo;
import PetsLove.sistema.negocios.beans.EnumTamanho;
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
	
	public void remover(Animal animal) {
		this.repositorioAnimais.remover(animal);
	}

	public ArrayList<Animal> listar() {
		return this.repositorioAnimais.listar();
	}
	
	public ArrayList<Animal> listarPorDono(Usuario usuario) {
		ArrayList<Animal> repo = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for (Animal animal : repo) {
			if (animal.getDono().equals(usuario)) {
				animais.add(animal);
			}
		}
		return animais;
	}

	public ArrayList<Animal> listarPorTipo(Class<?> tipo) {
		ArrayList<Animal> repo = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for (Animal animal : repo) {
			if (animal.getClass() == tipo) {
				animais.add(animal);
			}
		}
		return animais;
	}
	
	public ArrayList<Animal> listarCachorrosPorRaca(EnumRacaCachorro raca) throws RacaNaoExisteException {
		ArrayList<Animal> repoCachorros = this.listarPorTipo(Cachorro.class);
		ArrayList<Animal> cachorros = new ArrayList<Animal>();
		if (raca != null) {
			boolean achou = false;
			for (Animal cachorro : repoCachorros) {
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

	public ArrayList<Animal> listarCachorrosPorTamanho(EnumTamanho tamanho) {
		ArrayList<Animal> repoCachorros = this.listarPorTipo(Cachorro.class);
		ArrayList<Animal> cachorros = new ArrayList<Animal>();
		for (Animal cachorro : repoCachorros) {
			if (((Cachorro) cachorro).getTamanho().equals(tamanho)) {
				cachorros.add(cachorro);
			}
		}
		return cachorros;
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(EnumRacaCachorro raca, EnumTamanho tamanho) throws RacaNaoExisteException {
		ArrayList<Animal> repoCachorro = this.listarCachorrosPorRaca(raca);
		ArrayList<Animal> cachorros = new ArrayList<Animal>();
		for (Animal cachorro : repoCachorro) {
			if (((Cachorro) cachorro).getTamanho().equals(tamanho)) {
				cachorros.add(cachorro);
			}
		}
		return cachorros;
	}

	public ArrayList<Animal> listarGatosPorPelagem(EnumPelagem pelagem) {
		ArrayList<Animal> repoGatos = this.listarPorTipo(Gato.class);
		ArrayList<Animal> gatos = new ArrayList<Animal>();
		for (Animal gato : repoGatos) {
			if (((Gato) gato).getPelagem().equals(pelagem)) {
				gatos.add(gato);
			}
		}
		return gatos;
	}

	public ArrayList<Animal> listarAnimaisPorSexo(ArrayList<Animal> animais, EnumSexo sexo) {
		ArrayList<Animal> lista = new ArrayList<Animal>();
		for(Animal animal : animais) {
			if(animal.getSexo().sexo.equals(sexo.sexo)) {
				lista.add(animal);
			}
		}
		return lista;
	}

	public ArrayList<Animal> listarAnimaisCompativeis(Animal animal) {
		ArrayList<Animal> compativeis = null;
		if(animal instanceof Cachorro) {
			compativeis = listarPorTipo(Cachorro.class);
			if(animal.getSexo().equals(EnumSexo.MACHO)) {
				compativeis = this.listarAnimaisPorSexo(compativeis, EnumSexo.FEMEA);
			}else {
				compativeis = this.listarAnimaisPorSexo(compativeis, EnumSexo.MACHO);
			}
		}else{
			compativeis = listarPorTipo(Gato.class);
			if(animal.getSexo().equals(EnumSexo.MACHO)) {
				compativeis = this.listarAnimaisPorSexo(compativeis, EnumSexo.FEMEA);
			}else {
				compativeis = this.listarAnimaisPorSexo(compativeis, EnumSexo.MACHO);
			}
		}
		return compativeis;
	}

}
