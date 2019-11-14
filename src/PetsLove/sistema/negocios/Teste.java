package PetsLove.sistema.negocios;

import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;

public class Teste {
	
	public static void main(String[] args) {
		
		Usuario u1 = new Usuario(123, "Ben10", "99954-4213", "rogerinho..@hotmail.com", "321anhes");
		Usuario u2 = new Usuario(133, "Barbie", "99857-1682", "Barbiegirl@hotmail.com", "ken123");
		Cachorro c1 = new Cachorro(321, 4, Animal.MACHO, "Bob", u1, "Pitbull", Cachorro.ALTO);
		Cachorro c2 = new Cachorro(331, 3, Animal.FEMEA, "Mary", u2, "Pitbull", Cachorro.ALTO);
		Gato g1 = new Gato(213, 2, Animal.FEMEA, "Meow", u1, Gato.FELPUDO);
		
		u2.setAnimais(c2);
		u1.setAnimais(c1);
		u1.setAnimais(g1);
		
		for(Animal a1: u1.getAnimais()) {
			System.out.println(a1.getNome());
		}
		
		Solicitacao s1 = new Solicitacao(c1, c2);
		System.out.println(s1);
		
	}
	
}
