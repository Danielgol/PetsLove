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
import PetsLove.sistema.negocios.beans.EnumPelagem;
import PetsLove.sistema.negocios.beans.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.EnumTamanho;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;

public class FachadaPL {

	private static FachadaPL instance;
	private static Usuario usuarioLogado;

	private ControladorAnimal controladorAnimal;
	private ControladorUsuario controladorUsuario;
	private ControladorSolicitacao controladorSolicitacao;

	private FachadaPL() {
		this.controladorAnimal = new ControladorAnimal(RepositorioAnimais.getInstance());
		this.controladorUsuario = new ControladorUsuario(RepositorioUsuarios.getInstance());
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
	
	
	//ANIMAL
	public void cadastrarAnimal(Animal animal) {
		this.controladorAnimal.cadastrar(animal);
	}

	public void atualizarAnimal(Animal animal) {
		this.controladorAnimal.atualizar(animal);
	}
	
	public void removerAnimal(Animal animal) {
		this.controladorAnimal.remover(animal);
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

	public ArrayList<Animal> listarCachorrosPorTamanho(EnumTamanho tamanho) {
		return this.controladorAnimal.listarCachorrosPorTamanho(tamanho);
	}

	public ArrayList<Animal> listarCachorrosPorRacaETamanho(EnumRacaCachorro raca, EnumTamanho tamanho) throws RacaNaoExisteException {
		return this.controladorAnimal.listarCachorrosPorRacaETamanho(raca, tamanho);
	}

	public ArrayList<Animal> listarGatosPorPelagem(EnumPelagem pelagem) {
		return this.controladorAnimal.listarGatosPorPelagem(pelagem);
	}


	//SOLICITACAO
	public ArrayList<Solicitacao> listarSolicitacoesEnviadas(Usuario usuario){
		return this.controladorSolicitacao.listarSolicitacoesEnviadas(usuario);
	}

	public ArrayList<Solicitacao> listarSolicitacoesRecebidas(Usuario usuario){
		return this.controladorSolicitacao.listarSolicitacoesRecebidas(usuario);
	}

	public void criarSolicitacao(Solicitacao s) throws SolicitacaoJaExisteException {
		this.controladorSolicitacao.criarSolicitacao(s);
	}

	public void removerSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		this.controladorSolicitacao.removerSolicitacao(s);
	}

	public void aceitarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		this.controladorSolicitacao.aceitarSolicitacao(s);
	}

	public void recusarSolicitacao(Solicitacao s) throws SolicitacaoNaoExisteException {
		this.controladorSolicitacao.recusarSolicitacao(s);
	}
	
	
}
