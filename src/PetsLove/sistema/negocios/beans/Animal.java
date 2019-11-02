package PetsLove.sistema.negocios.beans;

public abstract class Animal {
	
	public static final String MACHO = "Macho";
	public static final String FEMEA= "Femea";
	
	private int id;
	private	int idade;
	private String sexo;
	private String nome;
	private Usuario dono;
	
	public Animal(int id, int idade, String sexo, String nome, Usuario dono){
		this.id = id;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		this.dono = dono;
	}
	
	public boolean equals(Animal outro) {
		if(this.id == outro.id) {
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public void setSexo(String sexo) {
		if(MACHO.equals(sexo) || FEMEA.equals(sexo)) {
			this.sexo = sexo;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
}
