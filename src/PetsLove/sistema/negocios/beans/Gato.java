package PetsLove.sistema.negocios.beans;

public class Gato extends Animal{
	
	private EnumPelagem pelagem;
	private EnumRacaGato raca;
	
	public Gato(int id, int idade, EnumSexo sexo, String nome, String email, EnumRacaGato raca, EnumPelagem pelagem, String descricao) {
		super(id, idade, sexo, nome, email, descricao);
		this.raca = raca;
		this.pelagem = pelagem;
	}
	
	public EnumRacaGato getRaca() {
		return raca;
	}
	
	public void setRaca(EnumRacaGato raca) {
		this.raca = raca;
	}
	
	public EnumPelagem getPelagem() {
		return this.pelagem;
	}
	
	public void setPelagem(EnumPelagem pelagem) {
		this.pelagem = pelagem;
	}
	
}
