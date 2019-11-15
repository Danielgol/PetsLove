package PetsLove.sistema.negocios.beans;

public enum EnumPelagem {
	
	FELPUDO("Felpudo"), MEDIO("MEDIO"), RASO("Raso");
	
	public String pelagem;
	
	private EnumPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

}
