package PetsLove.sistema.negocios.beans;

public class Cachorro extends Animal{
	private String nome;
	private String raca;
	private String dono;
	
	//Gets and Sets--------------------------------------------
	//Nome--------------------------------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null && nome!= "") {
			this.nome = nome;
		}
	}
	//Raca--------------------------------
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		if(raca!=null && raca!= "") {
			this.raca = raca;
		}
	}
	//Dono--------------------------------
	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		if(dono!=null && dono!= "") {
			this.dono = dono;
		}
	}
	
	//Metodos---------------------------------------------
	
	public Cachorro(int idade, String sexo, String nome, String dono, String raca) {
		super(idade, sexo);
		this.setDono(dono);
		this.setNome(nome);
		this.setRaca(raca);
	}
	
	public boolean equals(Cachorro c1) {
		boolean r=false;
		if(this.dono!=null && this.raca!=null && this.nome!=null &&
				c1.dono!=null && c1.raca!=null && c1.nome!=null) {
			r = (this.dono.equals(c1.dono)&&
				this.raca.equals(c1.raca)&&
				this.nome.equals(c1.nome));
		}
		return r;
	}
	
	public String toString() {
		String s="\nIdade: "+getIdade()+"\nSexo: "+getSexo()+"\nNome: "+getNome()+"\nDono: "+getDono()+"\nRaca: "+getRaca();
		return s;
	}
}
