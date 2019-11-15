package PetsLove.sistema.negocios.beans;

public class Cachorro extends Animal {

	private EnumRaca raca;
	private EnumTamanho tamanho;

	public Cachorro(int id, int idade, EnumSexo sexo, String nome, Usuario dono, EnumRaca raca, EnumTamanho tamanho) {
		super(id, idade, sexo, nome, dono);
		this.raca = raca;
		this.tamanho = tamanho;
	}

	public EnumRaca getRaca() {
		return raca;
	}

	public void setRaca(EnumRaca raca) {
		this.raca = raca;
	}

	public EnumTamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(EnumTamanho tamanho) {
		this.tamanho = tamanho;
	}

}
