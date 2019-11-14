package PetsLove.sistema.exceptions;

public class RacaNaoExisteException extends Exception{
	
	private String raca;
	
	public RacaNaoExisteException(String raca) {
		super("A ra�a "+raca+" n�o foi encontrada");
		this.raca = raca;
	}
	
	public String getRaca() {
		return raca;
	}
	
}
