package PetsLove.sistema.negocios.beans;

import PetsLove.sistema.negocios.beans.enums.EnumSexo;

public abstract class Animal {

	private int id;
	private int idade;
	private EnumSexo sexo;
	private String nome;
	private String emailDono;
	private String descricao;

	public Animal(int id, int idade, EnumSexo sexo, String nome, String emailDono, String descricao) {
		this.id = id;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		this.emailDono = emailDono;
		this.descricao = descricao;
	}
	
	@Override
	public boolean equals(Object animal) {
		Animal outro = (Animal) animal;
		if(outro != null && this.getEmailDono().equals(outro.getEmailDono())){
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

	public String getEmailDono() {
		return emailDono;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
