package PetsLove.sistema.negocios.beans;

public class Cachorro extends Animal {

	public static final String ALTO = "Alto";
	public static final String MEDIO = "Medio";
	public static final String BAIXO = "Baixo";

	private String raca;
	private String tamanho;

	public Cachorro(int id, int idade, String sexo, String nome, Usuario dono, String raca, String tamanho) {
		super(id, idade, sexo, nome, dono);
		this.raca = raca;
		this.tamanho = tamanho;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		if (tamanho.equals(ALTO) || tamanho.equals(MEDIO) || tamanho.equals(BAIXO)) {
			this.tamanho = tamanho;
		}
	}

}
