package PetsLove.sistema.dados.Repositorios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import PetsLove.sistema.dados.IRepositorioUsuarios;
import PetsLove.sistema.negocios.beans.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuarios {

	private static RepositorioUsuarios instance;

	private ArrayList<Usuario> usuarios;
	
	private RepositorioUsuarios(String arquivo) {
		lerArquivo(arquivo);
    }

	public static IRepositorioUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuarios("Arquivos/usuarios.csv");
		}
		return instance;
	}

	public void cadastrar(Usuario usuario) {
		this.usuarios.add(usuario);
		atualizarBanco();
	}

	public void remover(Usuario usuario) {
		this.usuarios.remove(usuario);
		atualizarBanco();
	}

	public void atualizar(Usuario usuario) {
		int indexUsuario = this.usuarios.indexOf(usuario);
		this.usuarios.set(indexUsuario, usuario);
		atualizarBanco();
	}
	
	public Usuario procurar(String email) {
		for(Usuario user : this.usuarios) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	public boolean existe(String email) {
		return this.procurar(email) != null;
	}
	
	public void atualizarBanco() {
		try {
			FileWriter csvWriter = new FileWriter("Arquivos/usuarios.csv");
			for(Usuario u : this.usuarios) {
				csvWriter.append(u.getNome());
				csvWriter.append(",");
				csvWriter.append(u.getNumero());
				csvWriter.append(",");
				csvWriter.append(u.getEmail());
				csvWriter.append(",");
				csvWriter.append(u.getSenha());
				csvWriter.append("\n");
			}
			csvWriter.close();
		}catch(IOException e) {}
	}
	
	public void lerArquivo(String arquivo) {
		this.usuarios = new ArrayList<Usuario>();
        try {
        	BufferedReader csvReader = new BufferedReader(new FileReader(arquivo));
        	String row = "";
        	try {
        		while((row = csvReader.readLine()) != null && !row.equals("")){
        			String[] dados = row.split(",");
        			Usuario usuario = new Usuario(dados[0], dados[1], dados[2], dados[3]);
        			usuarios.add(usuario);
        		}
        		csvReader.close();
        	}catch (IOException e) {}
        }catch (FileNotFoundException e) {
        	System.out.println("Arquivo não encontrado!");
        }
	}

}
