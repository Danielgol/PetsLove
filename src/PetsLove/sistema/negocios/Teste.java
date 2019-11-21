package PetsLove.sistema.negocios;

import java.util.ArrayList;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.SolicitacaoJaExisteException;
import PetsLove.sistema.exceptions.SolicitacaoNaoExisteException;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.EnumPelagem;
import PetsLove.sistema.negocios.beans.EnumRaca;
import PetsLove.sistema.negocios.beans.EnumSexo;
import PetsLove.sistema.negocios.beans.EnumTamanho;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;

public class Teste {
	
	public static void main(String[] args) throws UsuarioJaExisteException, SolicitacaoJaExisteException, SolicitacaoNaoExisteException {
		
		FachadaPL fachada = FachadaPL.getInstance();
		
		Usuario u1 = new Usuario("Ben10", "99954-4213", "rogerinho..@hotmail.com", "321anhes");
		Usuario u2 = new Usuario("Barbie", "99857-1682", "Barbiegirl@hotmail.com", "ken123");
		fachada.cadastrarUsuario(u1);
		fachada.cadastrarUsuario(u2);
		
		Cachorro c1 = new Cachorro(321, 4, EnumSexo.MACHO, "Bob", u1, EnumRaca.PITBULL, EnumTamanho.ALTO);
		Cachorro c2 = new Cachorro(331, 3, EnumSexo.FEMEA, "Mary", u2, EnumRaca.PITBULL, EnumTamanho.ALTO);
		Gato g1 = new Gato(213, 2, EnumSexo.FEMEA, "Meow", u1, EnumPelagem.FELPUDO);
		fachada.cadastrarAnimal(c1);
		fachada.cadastrarAnimal(c2);
		fachada.cadastrarAnimal(g1);
		
		
		
		FachadaPL.login("rogerinho..@hotmail.com", "321anhes");
		System.out.println(FachadaPL.getUsuarioLogado().getNome());
		
		FachadaPL.logout();
		
		FachadaPL.login("Barbiegirl@hotmail.com", "ken123");
		System.out.println(FachadaPL.getUsuarioLogado().getNome());
		
		FachadaPL.login("rogerinho..@hotmail.com", "321anhes");
		System.out.println(FachadaPL.getUsuarioLogado().getNome());
		System.out.println();
		
		
		ArrayList<Animal> animais = fachada.listarAnimais();
		for(Animal animal : animais) {
			System.out.println(animal.getNome());
		}
		System.out.println();
		
		
		
		Solicitacao s1 = new Solicitacao(c1, c2);
		Solicitacao s2 = new Solicitacao(c2, c1);
		fachada.criarSolicitacao(s1);
		fachada.criarSolicitacao(s2);
		
		fachada.aceitarSolicitacao(s1);
		fachada.recusarSolicitacao(s2);
		fachada.removerSolicitacao(s2);
		
		ArrayList<Solicitacao> solicitacoes = fachada.listarSolicitacoesRecebidas(FachadaPL.getUsuarioLogado());
		for(Solicitacao solicitacao : solicitacoes) {
			System.out.println(solicitacao);
		}
		
		solicitacoes = fachada.listarSolicitacoesEnviadas(FachadaPL.getUsuarioLogado());
		for(Solicitacao solicitacao : solicitacoes) {
			System.out.println(solicitacao);
		}
		
	}
	
}
