package PetsLove.sistema.negocios.beans;

public class Gato extends Animal{
	
	public static final String FELPUDO = "Felpudo";
	public static final String RASO = "Raso";
	
	private EnumPelagem pelagem;
	
	public Gato(int id, int idade, EnumSexo sexo, String nome, Usuario dono, EnumPelagem pelagem) {
		super(id, idade, sexo, nome, dono);
		this.pelagem = pelagem;
	}
	
	public EnumPelagem getPelagem() {
		return this.pelagem;
	}
	
	public void setPelagem(EnumPelagem pelagem) {
		this.pelagem = pelagem;
	}
	
}
