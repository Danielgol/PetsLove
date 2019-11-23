package PetsLove.sistema.negocios.beans;

public abstract class Animal {

	private int id;
	private int idade;
	private EnumSexo sexo;
	private String nome;
	private Usuario dono;
	private String descricao;

	public Animal(int id, int idade, EnumSexo sexo, String nome, Usuario dono, String descricao) {
		this.id = id;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		this.dono = dono;
		this.descricao = descricao;
	}
	

	@Override
	public boolean equals(Object animal) {
		Animal outro = (Animal) animal;
		if(this.getDono().equals(outro.getDono()))
		{
			if (this.id == outro.id) {
				return true;
			}
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

	public EnumSexo getSexo() {
		return this.sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
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
