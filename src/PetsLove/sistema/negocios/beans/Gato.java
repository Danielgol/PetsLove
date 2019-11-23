package PetsLove.sistema.negocios.beans;

public class Gato extends Animal{
	
	public static final String FELPUDO = "Felpudo";
	public static final String RASO = "Raso";
	
	private EnumPelagem pelagem;
	private EnumRacaGato raca;
	
	public Gato(int id, int idade, EnumSexo sexo, String nome, Usuario dono, EnumPelagem pelagem, EnumRacaGato raca, String descricao) {
		super(id, idade, sexo, nome, dono, descricao);
		this.pelagem = pelagem;
	}
	
	public EnumPelagem getPelagem() {
		return this.pelagem;
	}
	
	public void setPelagem(EnumPelagem pelagem) {
		this.pelagem = pelagem;
	}
	
	public EnumRacaGato getRaca() {
		return this.raca;
	}
	
	public void setRaca(EnumRacaGato raca) {
		this.raca = raca;
	}
	
}
