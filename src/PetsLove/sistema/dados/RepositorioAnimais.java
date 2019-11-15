package PetsLove.sistema.dados;

import java.util.ArrayList;
import PetsLove.sistema.negocios.beans.Animal;

public class RepositorioAnimais implements IRepositorioAnimais{
	
	private static RepositorioAnimais instance;

	private ArrayList<Animal> animais;
	
	private RepositorioAnimais() {
		this.animais = new ArrayList<Animal>();
	}

	public static RepositorioAnimais getInstance() {
		if (instance == null) {
			// TODO: Decidir como os animais serão guardados (Bloco de notas, ...)
			instance = new RepositorioAnimais();
		}
		return instance;
	}
	
	public void cadastrar(Animal animal) {
		this.animais.add(animal);
	}

	public void remover(Animal animal) {
		this.animais.remove(animal);
	}

	public void atualizar(Animal animal) {
		int indexUsuario = this.animais.indexOf(animal);
		this.animais.set(indexUsuario, animal);
	}

	public ArrayList<Animal> listar() {
		return this.animais;
	}

	public Animal procurar(int id) {
		for(Animal animal : this.animais) {
			if(animal.getId() == id) {
				return animal;
			}
		}
		return null;
	}

}
