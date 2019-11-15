package PetsLove.sistema.negocios;

import java.util.ArrayList;

import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;

public class Teste {
	
	public static void main(String[] args) throws UsuarioJaExisteException {
		
		FachadaPL fachada = FachadaPL.getInstance();
		
		Usuario u1 = new Usuario(123, "Ben10", "99954-4213", "rogerinho..@hotmail.com", "321anhes");
		Usuario u2 = new Usuario(133, "Barbie", "99857-1682", "Barbiegirl@hotmail.com", "ken123");
		
		Cachorro c1 = new Cachorro(321, 4, Animal.MACHO, "Bob", u1, "Pitbull", Cachorro.ALTO);
		Cachorro c2 = new Cachorro(331, 3, Animal.FEMEA, "Mary", u2, "Pitbull", Cachorro.ALTO);
		Gato g1 = new Gato(213, 2, Animal.FEMEA, "Meow", u1, Gato.FELPUDO);
		
		fachada.cadastrarUsuario(u1);
		fachada.cadastrarUsuario(u2);
		
		fachada.cadastrarAnimal(c1);
		fachada.cadastrarAnimal(c2);
		fachada.cadastrarAnimal(g1);
		
		Usuario user = fachada.login("rogerinho..@hotmail.com", "321anhes");
		System.out.println(user.getNome());
		
		ArrayList<Animal> animais = fachada.listarAnimais();
		for(Animal animal : animais) {
			System.out.println(animal.getNome());
		}
		
		Solicitacao s1 = new Solicitacao(c1, c2);
		System.out.println(s1);
		
	}
	
}
