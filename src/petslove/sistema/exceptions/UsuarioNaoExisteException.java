package petslove.sistema.exceptions;

public class UsuarioNaoExisteException extends Exception {

	private String email;

	public UsuarioNaoExisteException(String email) {
		super("O email " + email + " n�o existe");
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
