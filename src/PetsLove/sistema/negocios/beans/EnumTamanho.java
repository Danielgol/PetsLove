package PetsLove.sistema.negocios.beans;

public enum EnumTamanho {
	
	ALTO("Alto"), MEDIO("Medio"), BAIXO("Baixo");
	
	public String valor;
	
	private EnumTamanho(String valor) {
		this.valor = valor;
	}
	
	public static EnumTamanho getTamanho(String valor) {
		for(EnumTamanho e : EnumTamanho.values()) {
			if(e.valor.equals(valor)) {
				return e;
			}
		}
		return null;
	}

}
