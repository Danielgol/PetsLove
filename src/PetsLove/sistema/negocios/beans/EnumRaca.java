package PetsLove.sistema.negocios.beans;

public enum EnumRaca {
	
	//Cachorro
	PITBULL("Pitbull"),
	PASTORALEMAO("Pastor Alemao"),
	BEAGLE("Beagle"),
	BULLDOG("Bulldog"),
	DALMATA("Dalmata"),
	SAOBERNARDO("Sao Bernardo"),
	HUSKY("Husky"),
	PINSCHER("Pinscher"),
	LABRADOR("Labrador"),
	BOXER("Boxer"),
	YORKSHIRE("Yorkshire"),
	POODLE("Poodle"),
	CHIHUAHUA("Chihuahua"),
	COLLIE("Collie"),
	AKITA("Akita"),
	DOBERMANN("Dobermann"),
	ROTTWEILER("Rottweiler"),
	PUG("Pug"),
	LHASAAPSO("Lhasa Apso"),
	MALTES("Maltes"),
	GOLDEN("Golden"),
	SHIHTZU("Shih-tzu"),
	BORDERCOLLIE("Border Collie"),
	
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
	
	private EnumRaca(String valor) {
		this.valor = valor;
	}

}
