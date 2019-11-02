package PetsLove.sistema.negocios.beans;

public class Gato extends Animal{
	
	public static final String FELPUDO = "FELPUDO";
	public static final String RASO = "RASO";
	
	private String pelagem;
	
	public Gato(int id, int idade, String sexo, String nome, Usuario dono, String pelagem) {
		super(id, idade, sexo, nome, dono);
		this.pelagem = pelagem;
	}
	
	public String getPelagem() {
		return this.pelagem;
	}
	
	public void setPelagem(String pelagem) {
		if(pelagem.equals(FELPUDO) || pelagem.equals(RASO)) {
			this.pelagem = pelagem;
		}
	}
	
}
