package PetsLove.sistema.exceptions;

import PetsLove.sistema.negocios.beans.EnumRaca;

public class RacaNaoExisteException extends Exception{
	
	private String raca;
	
	public RacaNaoExisteException(EnumRaca raca) {
		super("A raça "+raca+" não foi encontrada");
		this.raca = raca.toString();
	}
	
	public String getRaca() {
		return raca;
	}
	
}
