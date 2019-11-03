package PetsLove.sistema.negocios;

import java.util.ArrayList;

import PetsLove.sistema.dados.IRepositorioUsuarios;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
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
	
	public ArrayList<Usuario> listar(){
		return this.repositorioUsuarios.listar();
	}

	public ArrayList<Animal> listarAnimais() {
		ArrayList<Usuario> usuarios = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for(Usuario user : usuarios) {
			for(Animal animal : user.getAnimais()) {
				animais.add(animal);
			}
		}
		return animais;
	}
	
	public ArrayList<Animal> listarAnimaisPorTipo(Class<?> tipo) {
		ArrayList<Usuario> usuarios = this.listar();
		ArrayList<Animal> animais = new ArrayList<Animal>();
		for(Usuario user : usuarios) {
			for(Animal animal : user.getAnimais()) {
				if(animal.getClass() == tipo) {
					animais.add(animal);
				}
			}
		}
		return animais;
	}
	
	public ArrayList<Animal> listarCachorrosPorRaca(String raca) {
		ArrayList<Animal> cachorros = this.listarAnimaisPorTipo(Cachorro.class);
		for(Animal cachorro : cachorros) {
			if(((Cachorro) cachorro).getRaca().equals(raca)) {
				cachorros.add(cachorro);
			}
		}
		return cachorros;
	}
	
	public ArrayList<Animal> listarCachorrosPorTamanho(String tamanho) {
		ArrayList<Animal> cachorros = this.listarAnimaisPorTipo(Cachorro.class);
		for(Animal cachorro : cachorros) {
			if(((Cachorro) cachorro).getTamanho().equals(tamanho)) {
				cachorros.add(cachorro);
			}
		}
		return cachorros;
	}
	
	public ArrayList<Animal> listarCachorrosPorRacaETamanho(String raca, String tamanho) {
		ArrayList<Animal> cachorros = this.listarCachorrosPorRaca(raca);
		for(Animal cachorro : cachorros) {
			if(!((Cachorro) cachorro).getTamanho().equals(tamanho)) {
				cachorros.remove(cachorro);
			}
		}
		return cachorros;
	}
	
	public ArrayList<Animal> listarGatosPorPelagem(String pelagem) {
		ArrayList<Animal> gatos = this.listarAnimaisPorTipo(Gato.class);
		for(Animal gato : gatos) {
			if(((Gato) gato).getPelagem().equals(pelagem)) {
				gatos.add(gato);
			}
		}
		return gatos;
	}

}
