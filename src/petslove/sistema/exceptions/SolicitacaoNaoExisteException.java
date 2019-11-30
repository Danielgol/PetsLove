package petslove.sistema.exceptions;

public class SolicitacaoNaoExisteException extends Exception {

	private String remetente, destinatario;

	public SolicitacaoNaoExisteException(String remetente, String destinatario) {
		super("A solicita��o de : " + remetente + " para " + destinatario + " n�o existe");
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
