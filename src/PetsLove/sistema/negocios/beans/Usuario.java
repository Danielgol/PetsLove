package PetsLove.sistema.negocios.beans;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String numero;
	private String email;
	private String senha;
	private ArrayList<Animal> animais;

	//Gets and Sets----------------------------------------
	//Nome--------------------------------
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!=null && nome!= "") {
			this.nome = nome;
		}
	}
	//Numero--------------------------------
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		if(numero!=null && numero!= "") {
			this.numero = numero;
		}
	}
	//Email--------------------------------
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email!=null && email!= "") {
			this.email = email;
		}
	}
	//Senha--------------------------------
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha!=null && senha!= "") {
			this.senha = senha;
		}
	}
	//Animais--------------------------------
	public ArrayList<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	
	//Metodos--------------------------------------------
	
	public Usuario(String nome, String numero, String email, String senha, ArrayList<Animal> animais) {
		this.setNome(nome);
		this.setNumero(numero);
		this.setEmail(email);
		this.setSenha(senha);
		this.animais=animais;
	}
	
	public boolean equals(Usuario u) {
		boolean r=false;
		
		if(this.email!=null&&u.email!=null) {
			r = (this.email.equals(u.email));
		}
		return r;
	}
	
	public String toString() {
		String s="\nNome: "+getNome()+"\nNumero: "+getNumero()+"\nEmail: "+getEmail()+"\nSenha: "+getSenha();
		return s;
	}
	
}
