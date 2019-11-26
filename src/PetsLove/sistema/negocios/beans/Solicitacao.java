package PetsLove.sistema.negocios.beans;

public class Solicitacao {
	
	public static final String RECUSADO = "Recusado";
	public static final String ACEITO = "Aceito";
	public static final String ANALISANDO = "Analisando";
	
	private String idRemetente;
	private String idDestinatario;
	private String emailDonoRemetente;
	private String emailDonoDestinatario;
	private String status;

	public Solicitacao(String remetente, String destinatario, String emailDonoRemetente, String emailDonoDestinatario) {
		this.idRemetente = remetente;
		this.idDestinatario = destinatario;
		this.emailDonoRemetente = emailDonoRemetente;
		this.emailDonoDestinatario = emailDonoDestinatario;
		this.status = ANALISANDO;
	}
	
	public Solicitacao(String remetente, String destinatario, String emailDonoRemetente, String emailDonoDestinatario, String status) {
		this.idRemetente = remetente;
		this.idDestinatario = destinatario;
		this.emailDonoRemetente = emailDonoRemetente;
		this.emailDonoDestinatario = emailDonoDestinatario;
		this.status = status;
	}

	@Override
	public boolean equals(Object outra) {
		Solicitacao s = (Solicitacao) outra;
		if (s != null && this.idRemetente.equals(s.idRemetente) && this.idDestinatario.equals(s.idDestinatario)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String s="Status da solicitação: "+getStatus();
		return s;
	}

	public String getIdRemetente() {
		return idRemetente;
	}

	public String getIdDestinatario() {
		return idDestinatario;
	}

	public String getEmailDonoRemetente() {
		return emailDonoRemetente;
	}

	public String getEmailDonoDestinatario() {
		return emailDonoDestinatario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (RECUSADO.equals(status) || ACEITO.equals(status) || ANALISANDO.equals(status)) {
			this.status = status;
		}
	}

}
