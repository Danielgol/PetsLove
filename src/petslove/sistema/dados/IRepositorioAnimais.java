package petslove.sistema.dados;

import java.util.ArrayList;

import petslove.sistema.negocios.beans.Animal;

public interface IRepositorioAnimais {
	
	public void cadastrar(Animal animal);
	public void remover(Animal animal);
	public void atualizar(Animal animal);
	public Animal procurar(String id);
	public ArrayList<Animal> listar();

}
