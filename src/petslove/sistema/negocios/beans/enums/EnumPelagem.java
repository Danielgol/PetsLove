package petslove.sistema.negocios.beans.enums;

public enum EnumPelagem {
	
	FELPUDO("Felpudo"), MEDIO("Medio"), RASO("Raso");
	
	public String valor;
	
	private EnumPelagem(String valor) {
		this.valor = valor;
	}
	
	public static EnumPelagem getPelagem(String valor) {
		for(EnumPelagem e : EnumPelagem.values()) {
			if(e.valor.equals(valor)) {
				return e;
			}
		}
		return null;
	}

}
