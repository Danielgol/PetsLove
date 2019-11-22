package PetsLove.sistema.negocios.beans;

public enum EnumRacaGato {
	
	//Gato
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
	
	private EnumRacaGato(String valor) {
		this.valor = valor;
	}

}
