package petslove.sistema.exceptions;

public class SolicitacaoJaExisteException extends Exception {

	private String remetente, destinatario;

	public SolicitacaoJaExisteException(String remetente, String destinatario) {
		super("A solicitação de : " + remetente + " para " + destinatario + " já existe");
		this.remetente = remetente;
		this.destinatario = destinatario;
	}

	public String getRemetente() {
		return remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}
}
