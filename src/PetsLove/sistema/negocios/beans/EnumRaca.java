package PetsLove.sistema.negocios.beans;

public enum EnumRaca {
	
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
	INDEFINIDO("Indefinido");
	
	public String valor;
	
	private EnumRaca(String valor) {
		this.valor = valor;
	}

}
