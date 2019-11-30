package petslove.sistema.exceptions;

public class UsuarioJaExisteException extends Exception {

	private String email;

	public UsuarioJaExisteException(String email) {
		super("O email " + email + " já está em uso");
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
