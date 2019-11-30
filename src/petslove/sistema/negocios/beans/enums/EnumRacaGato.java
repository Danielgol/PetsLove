package petslove.sistema.negocios.beans.enums;

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
	AZULRUSSO("Azul Russo"),
	MUNCHKIN("Munchkin"),
	SCOTTISHFOLD("Scottish Fold"),
	NORUEGUESDAFLORESTA("Noruegues da Floresta"),
	EXOTICO("Exotico"),
	TOYGER("Toyger"),
	SINGAPURA("Singapura"),
	RAGAMUFFIN("Ragamuffin"),
	SELKIRKREX("Selkirk Rex"),
	PETERBALD("Peterbald"),
	AMERICANWIREHAIR("American Wirehair"),
	SOMALI("Somali"),
	NEBELUNG("Nebelung"),
	CURLAMERICANO("Curl Americano"),
	DEVONREX("Devon rex"),
	VANTURCO("Van Turco"),
	BURMILLA("Burmilla"),
	TONQUINES("Tonquines"),
	KORAT("Korat"),
	LYKOI("Lykoi"),
	BOBTAILJAPONES("Bobtail Japones"),
	ORIENTALLONGHAIR("Oriental Longhair"),
	PIXIEBOB("Pixie Bob"),
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
