package PetsLove.sistema;

import java.util.ArrayList;
import PetsLove.sistema.dados.Repositorios.RepositorioAnimais;
import PetsLove.sistema.dados.Repositorios.RepositorioSolicitacoes;
import PetsLove.sistema.dados.Repositorios.RepositorioUsuarios;
import PetsLove.sistema.exceptions.RacaNaoExisteException;
import PetsLove.sistema.exceptions.SolicitacaoJaExisteException;
import PetsLove.sistema.exceptions.SolicitacaoNaoExisteException;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import PetsLove.sistema.negocios.ControladorAnimal;
import PetsLove.sistema.negocios.ControladorSolicitacao;
import PetsLove.sistema.negocios.ControladorUsuario;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;
import PetsLove.sistema.negocios.beans.enums.EnumPelagem;
import PetsLove.sistema.negocios.beans.enums.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.enums.EnumPorte;

public class FachadaPL {

	private static FachadaPL instance;
	private static Usuario usuarioLogado;

	private ControladorAnimal controladorAnimal;
	private ControladorUsuario controladorUsuario;
	private ControladorSolicitacao controladorSolicitacao;

	private FachadaPL() {
		this.controladorUsuario = new ControladorUsuario(RepositorioUsuarios.getInstance());
		this.controladorAnimal = new ControladorAnimal(RepositorioAnimais.getInstance());
		this.controladorSolicitacao = new ControladorSolicitacao(RepositorioSolicitacoes.getInstance());
	}

	public static FachadaPL getInstance() {
		if (instance == null) {
			instance = new FachadaPL();
		}
		return instance;
	}

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void login(String email, String senha) {
		if(instance != null && usuarioLogado == null) {
			usuarioLogado = instance.controladorUsuario.login(email, senha);
		}
	}

	public static void logout() {
		if(instance != null && usuarioLogado != null) {
			usuarioLogado = null;
		}
	}

	
	//USUARIO
	public void cadastrarUsuario(Usuario usuario) throws UsuarioJaExisteException {
		this.controladorUsuario.cadastrar(usuario);
	}

	public void atualizarUsuario(Usuario usuario) throws UsuarioNaoExisteException {
		this.controladorUsuario.atualizar(usuario);
	}

	public boolean usuarioExiste(String email){
		return this.controladorUsuario.existe(email);
	}
	
	public Usuario procurarUsuario(String email) {
		return this.controladorUsuario.procurar(email);
	}
	
	
	//ANIMAL
	public void cadastrarAnimal(Animal animal) {
		this.controladorAnimal.cadastrar(animal);
	}

	public void atualizarAnimal(Animal animal) {
		this.controladorAnimal.atualizar(animal);
	}
	
	public void removerAnimal(Animal animal) {
		this.controladorAnimal.remover(animal);
		this.controladorSolicitacao.removerSolicitacoesComAnimal(animal);
	}
	
	public Animal procurarAnimal(String id) {
		return this.controladorAnimal.procurar(id);
	}

	public ArrayList<Animal> listarAnimais() {
		return this.controladorAnimal.listar();
	}

	public ArrayList<Animal> listarAnimaisPorDono(Usuario usuario) {
		return this.controladorAnimal.listarPorDono(usuario);
	}

	public ArrayList<Animal> listarAnimaisPorTipo(Class<?> tipo) {
		return this.controladorAnimal.listarPorTipo(tipo);
	}

	public ArrayList<Animal> listarCachorrosPorRaca(EnumRacaCachorro raca) throws RacaNaoExisteException {
		return this.controladorAnimal.listarCachorrosPorRaca(raca);
	}

	public ArrayList<Animal> listarCachorrosPorTamanho(EnumPorte tamanho) {
		return this.controladorAnimal.listarCachorrosPorTamanho(tamanho);
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(EnumRacaCachorro raca, EnumPorte porte) throws RacaNaoExisteException {
		return this.controladorAnimal.listarCachorrosPorRacaETamanho(raca, porte);
	}

	public ArrayList<Animal> listarGatosPorPelagem(EnumPelagem pelagem) {
		return this.controladorAnimal.listarGatosPorPelagem(pelagem);
	}
	
	public ArrayList<Animal> listarAnimaisCompativeisPorDono(Animal animal, Usuario usuario) {
		return this.controladorAnimal.listarAnimaisCompativeisPorDono(animal, usuario);
	}


	//SOLICITACAO
	public ArrayList<Solicitacao> listarSolicitacoesEnviadas(Usuario usuario){
		return this.controladorSolicitacao.listarSolicitacoesEnviadas(usuario);
	}

	public ArrayList<Solicitacao> listarSolicitacoesRecebidas(Usuario usuario){
		return this.controladorSolicitacao.listarSolicitacoesRecebidas(usuario);
	}

	public void criarSolicitacao(Solicitacao solicitacao) throws SolicitacaoJaExisteException {
		this.controladorSolicitacao.criarSolicitacao(solicitacao);
	}

	public void removerSolicitacao(Solicitacao solicitacao) throws SolicitacaoNaoExisteException {
		this.controladorSolicitacao.removerSolicitacao(solicitacao);
	}

	public void aceitarSolicitacao(Solicitacao solicitacao) throws SolicitacaoNaoExisteException {
		this.controladorSolicitacao.aceitarSolicitacao(solicitacao);
	}

	public void recusarSolicitacao(Solicitacao solicitacao) throws SolicitacaoNaoExisteException {
		this.controladorSolicitacao.recusarSolicitacao(solicitacao);
	}
	
}
