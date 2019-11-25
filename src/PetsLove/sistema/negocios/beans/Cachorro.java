package PetsLove.sistema.negocios.beans;

public class Cachorro extends Animal {

	private EnumRacaCachorro raca;
	private EnumTamanho tamanho;

	public Cachorro(int id, int idade, EnumSexo sexo, String nome, String email, EnumRacaCachorro raca, EnumTamanho tamanho, String descricao) {
		super(id, idade, sexo, nome, email, descricao);
		this.raca = raca;
		this.tamanho = tamanho;
	}

	public EnumRacaCachorro getRaca() {
		return raca;
	}

	public void setRaca(EnumRacaCachorro raca) {
		this.raca = raca;
	}

	public EnumTamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(EnumTamanho tamanho) {
		this.tamanho = tamanho;
	}

}
