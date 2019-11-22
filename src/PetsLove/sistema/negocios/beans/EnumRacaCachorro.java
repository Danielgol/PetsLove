package PetsLove.sistema.negocios.beans;

public enum EnumRacaCachorro {
	
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
	INDEFINIDO("Indefinido");
	
	public String valor;
	
	private EnumRacaCachorro(String valor) {
		this.valor = valor;
	}

}
