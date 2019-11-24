package PetsLove.sistema.negocios.beans;

public class Solicitacao {
	
	public static final String RECUSADO = "Recusado";
	public static final String ACEITO = "Aceito";
	public static final String ANALISANDO = "Analisando";
	
	private Animal remetente;
	private Animal destinatario;
	private String status;

	public Solicitacao(Animal remetente, Animal destinatario) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.status = ANALISANDO;
	}

	public Solicitacao() {
		
	}

	@Override
	public boolean equals(Object outra) {
		Solicitacao s = (Solicitacao) outra;
		if (this.remetente.equals(s.remetente) && this.destinatario.equals(s.destinatario)) {
			return true;
		}
		return false;
	}
	
	@Override
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
		if (RECUSADO.equals(status) || ACEITO.equals(status) || ANALISANDO.equals(status)) {
			this.status = status;
		}
	}

}
