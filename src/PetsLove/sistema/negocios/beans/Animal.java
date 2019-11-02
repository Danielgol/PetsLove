package PetsLove.sistema.negocios.beans;

public abstract class Animal {
	private	int idade;
	private String sexo;
	
	public static final String MACHO = "Macho";
	public static final String FEMEA= "Femea";
	
	//Gets and Sets--------------------------------------
	//Idade--------------------------------
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	//Sexo--------------------------------
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		if(MACHO.equals(sexo) || FEMEA.equals(sexo)) {
			this.sexo=sexo;
		}
	}
	
	//Metodos--------------------------------------------
	
	public Animal(int idade, String sexo){
		this.idade=idade;
		this.setSexo(sexo);
	}
	
	public String toString() {
		String s="\nIdade: "+getIdade()+"\nSexo: "+getSexo();
		return s;
	}
}
