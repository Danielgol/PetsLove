package PetsLove.sistema.exceptions;

import PetsLove.sistema.negocios.beans.Animal;

public class SolicitacaoNaoExisteException extends Exception {

	private Animal remetente, destinatario;

	public SolicitacaoNaoExisteException(Animal remetente, Animal destinatario) {
		super("A solicitação de : " + remetente + " para " + destinatario + " não existe");
		this.remetente = remetente;
		this.destinatario = destinatario;
	}

	public Animal getRemetente() {
		return remetente;
	}

	public Animal getDestinatario() {
		return destinatario;
	}
}
