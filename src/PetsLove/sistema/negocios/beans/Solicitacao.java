package PetsLove.sistema.negocios.beans;

public class Solicitacao {
	private Animal remetente;
	private Animal destinatario;
	private String status;

	public static final String RECUSADO = "Recusado";
	public static final String ACEITADO = "Aceitado";
	public static final String ANALISANDO = "Analisando";

	public Solicitacao(Animal remetente, Animal destinatario, String status) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.status = status;
	}

	public boolean equals(Solicitacao s1) {
		if (this.remetente.equals(s1.remetente) && this.destinatario.equals(s1.destinatario)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String s="Status da solicitação: "+getStatus();
		return s;
	}

	public Animal getRemetente() {
		return remetente;
	}

	public void setRemetente(Animal remetente) {
		this.remetente = remetente;
	}

	public Animal getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Animal destinatario) {
		this.destinatario = destinatario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (RECUSADO.equals(status) || ACEITADO.equals(status) || ANALISANDO.equals(status)) {
			this.status = status;
		}
	}

}
