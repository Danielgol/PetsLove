package PetsLove.sistema.negocios.beans.enums;

import java.util.ArrayList;

public enum EnumRacaCachorro {
	
	//Cachorro
	DACHSHUND("Dachshund"),
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
	
	public static ArrayList<String> getValues(){
		ArrayList<String> valores = new ArrayList<String>();
		for(EnumRacaCachorro e : values()) {
			valores.add(e.valor);
		}
		return valores;
	}
	
	public static EnumRacaCachorro getRaca(String raca) {
		for(EnumRacaCachorro r : EnumRacaCachorro.values()) {
			if(r.valor.equals(raca)) {
				return r;
			}
		}
		return null;
	}
	
	private EnumRacaCachorro(String valor) {
		this.valor = valor;
	}

}
