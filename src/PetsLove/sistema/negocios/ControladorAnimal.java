package PetsLove.sistema.negocios;

import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioAnimais;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Usuario;
import PetsLove.sistema.negocios.beans.enums.EnumPelagem;
import PetsLove.sistema.negocios.beans.enums.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.enums.EnumSexo;
import PetsLove.sistema.negocios.beans.enums.EnumPorte;

public class ControladorAnimal {

	private IRepositorioAnimais repositorioAnimais;

	public ControladorAnimal(IRepositorioAnimais instanciaRepositorio) {
		this.repositorioAnimais = instanciaRepositorio;
	}
	
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
	
	public Animal procurar(String id) {
		ArrayList<Animal> repo = this.listar();
		for(Animal animal : repo) {
			if(animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;
	}
	
	public ArrayList<Animal> listarPorDono(Usuario usuario) {
		ArrayList<Animal> repo = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for (Animal animal : repo) {
			if (animal.getEmailDono().equals(usuario.getEmail())) {
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
			for(Animal cachorro : repoCachorros) {
				if(((Cachorro) cachorro).getRaca().equals(raca)) {
					cachorros.add(cachorro);
					achou = true;
				}
			}
			if(!achou) {
				throw new RacaNaoExisteException(raca);
			}
			return cachorros;
		}else {
			throw new IllegalArgumentException("Parâmetro inválido");
		}
	}

	public ArrayList<Animal> listarCachorrosPorTamanho(EnumPorte porte) {
		ArrayList<Animal> repoCachorros = this.listarPorTipo(Cachorro.class);
		ArrayList<Animal> cachorros = new ArrayList<Animal>();
		for (Animal cachorro : repoCachorros) {
			if (((Cachorro) cachorro).getPorte().equals(porte)) {
				cachorros.add(cachorro);
			}
		}
		return cachorros;
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(EnumRacaCachorro raca, EnumPorte porte) throws RacaNaoExisteException {
		ArrayList<Animal> repoCachorro = this.listarCachorrosPorRaca(raca);
		ArrayList<Animal> cachorros = new ArrayList<Animal>();
		for (Animal cachorro : repoCachorro) {
			if (((Cachorro) cachorro).getPorte().equals(porte)) {
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
			if(animal.getSexo().valor.equals(sexo.valor)) {
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
	
	public ArrayList<Animal> listarAnimaisCompativeisPorDono(Animal animal, Usuario logado) {
		ArrayList<Animal> compativeis = listarAnimaisCompativeis(animal);
		ArrayList<Animal> lista = new ArrayList<Animal>();
		for(Animal a : compativeis) {
			if(a.getEmailDono().equals(logado.getEmail())) {
				lista.add(a);
			}
		}
		return lista;
	}

}
