package PetsLove.sistema.exceptions;

import PetsLove.sistema.negocios.beans.Animal;

public class SolicitacaoJaExisteException extends Exception {

	private Animal remetente, destinatario;

	public SolicitacaoJaExisteException(Animal remetente, Animal destinatario) {
		super("A solicita��o de : " + remetente + " para " + destinatario + " j� existe");
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
