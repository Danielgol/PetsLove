package PetsLove.sistema.negocios.beans;

import java.util.ArrayList;

public enum EnumRacaGato {

	ABISSINIO("Abissinio"),
	ANGORA("Angora"),
	BALINES("Balines"),
	BENGAL("Bengal"),
	BOMBAY("Bombay"),
	BURMES("Burmes"),
	CHARTREUX("Chartreux"),
	HIMALAIA("Himalaia"),
	JAGUATIRICA("Jaguatirica"),
	LAPERM("LaPerm"),
	MAINECOON("Maine Coon"),
	CYMRIC("Cymric"),
	PERSA("Persa"),
	RAGDOLL("Ragdoll"),
	OCICAT("Ocicat"),
	SAGRADODABIRMANIA("Sagrado da Birmania"),
	SAVANNAH("Savannah"),
	SIAMES("Siames"),
	SPHYNX("Sphynx"),
	THAI("Thai"),
	SIBERIANO("Siberiano"),
	BRITISHSHORTHAIR("British Shorthair"),
	INDEFINIDO("Indefinido");

	public String valor;

	public static ArrayList<String> getValues(){
		ArrayList<String> valores = new ArrayList<String>();
		for(EnumRacaGato e : values()) {
			valores.add(e.valor);
		}
		return valores;
	}
	
	public static EnumRacaGato getRaca(String raca) {
		for(EnumRacaGato r : EnumRacaGato.values()) {
			if(r.valor.equals(raca)) {
				return r;
			}
		}
		return null;
	}

	private EnumRacaGato(String valor) {
		this.valor = valor;
	}

}
