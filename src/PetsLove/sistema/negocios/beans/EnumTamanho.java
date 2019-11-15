package PetsLove.sistema.negocios.beans;

public enum EnumTamanho {
	
	ALTO("Alto"), MEDIO("Medio"), BAIXO("Baixo");
	
	public String tamanho;
	
	private EnumTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

}
