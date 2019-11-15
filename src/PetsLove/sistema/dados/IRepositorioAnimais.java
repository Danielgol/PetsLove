package PetsLove.sistema.dados;

import java.util.ArrayList;
import PetsLove.sistema.negocios.beans.Animal;

public interface IRepositorioAnimais {
	
	public void cadastrar(Animal animal);
	public void remover(Animal animal);
	public void atualizar(Animal animal);
	public Animal procurar(int id);
	public ArrayList<Animal> listar();

}
