package PetsLove.sistema.negocios.beans.enums;

public enum EnumPorte {
	
	GRANDE("Grande"), MEDIO("Medio"), PEQUENO("Pequeno");
	
	public String valor;
	
	private EnumPorte(String valor) {
		this.valor = valor;
	}
	
	public static EnumPorte getPorte(String valor) {
		for(EnumPorte e : EnumPorte.values()) {
			if(e.valor.equals(valor)) {
				return e;
			}
		}
		return null;
	}

}
