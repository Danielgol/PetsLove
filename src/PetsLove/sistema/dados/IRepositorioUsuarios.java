package PetsLove.sistema.dados;

import java.util.ArrayList;
import PetsLove.sistema.negocios.beans.Usuario;

public interface IRepositorioUsuarios {
	
	public void cadastrar(Usuario usuario);
	public void remover(Usuario usuario);
	public void atualizar(Usuario usuario);
	public ArrayList<Usuario> listar();

}
