package PetsLove.sistema.negocios.beans;

public class Usuario {
	
	private int id;
	private String nome;
	private String numero;
	private String email;
	private String senha;
	
	public Usuario(int id, String nome, String numero, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.email = email;
		this.senha = senha;
	}
	
	public boolean equals(Usuario outro) {
		if(this.id == outro.id && this.email.equals(outro.email)) {
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
