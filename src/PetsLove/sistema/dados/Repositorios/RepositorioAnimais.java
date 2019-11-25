package PetsLove.sistema.dados.Repositorios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import PetsLove.sistema.dados.IRepositorioAnimais;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.EnumPelagem;
import PetsLove.sistema.negocios.beans.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.EnumRacaGato;
import PetsLove.sistema.negocios.beans.EnumSexo;
import PetsLove.sistema.negocios.beans.EnumTamanho;
import PetsLove.sistema.negocios.beans.Gato;

public class RepositorioAnimais implements IRepositorioAnimais{

	private static RepositorioAnimais instance;

	private ArrayList<Animal> animais;

	private RepositorioAnimais(String arquivo) {
		lerArquivo(arquivo);
	}

	public static RepositorioAnimais getInstance() {
		if (instance == null) {
			instance = new RepositorioAnimais("animais.csv");
		}
		return instance;
	}
	
	//TODO: Atualizar Banco de Animais quando as restricoes forem completas

	public void cadastrar(Animal animal) {
		this.animais.add(animal);
		//atualizarBanco();
	}

	public void remover(Animal animal) {
		this.animais.remove(animal);
		//atualizarBanco();
	}

	public void atualizar(Animal animal) {
		int indexUsuario = this.animais.indexOf(animal);
		this.animais.set(indexUsuario, animal);
		//atualizarBanco();
	}

	public ArrayList<Animal> listar() {
		return this.animais;
	}

	public Animal procurar(int id) {
		for(Animal animal : this.animais) {
			if(animal.getId() == id) {
				return animal;
			}
		}
		return null;
	}

	public void atualizarBanco() {
		try {
			FileWriter csvWriter = new FileWriter("animais.csv");
			for(Animal a : this.animais) {
				csvWriter.append(a.getId()+"");
				csvWriter.append(",");
				csvWriter.append(a.getIdade()+"");
				csvWriter.append(",");
				csvWriter.append(a.getSexo().valor);
				csvWriter.append(",");
				csvWriter.append(a.getNome());
				csvWriter.append(",");
				csvWriter.append(a.getEmailDono());
				csvWriter.append(",");
				if(a instanceof Cachorro) {
					csvWriter.append(((Cachorro) a).getRaca().valor);
					csvWriter.append(",");
					csvWriter.append(((Cachorro) a).getTamanho().valor);
				}else {
					csvWriter.append(((Gato) a).getRaca().valor);
					csvWriter.append(",");
					csvWriter.append(((Gato) a).getPelagem().valor);
				}
				csvWriter.append(",");
				csvWriter.append(a.getDescricao());
				csvWriter.append("\n");
			}
			csvWriter.close();
		}catch(IOException e) {}
	}

	public void lerArquivo(String arquivo) {
		this.animais = new ArrayList<Animal>();
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(arquivo));
			String row = "";
			try {
				
				while((row = csvReader.readLine()) != null){
					String[] dados = row.split(",");
					int id = Integer.parseInt(dados[0]);
					int idade = Integer.parseInt(dados[1]);
					String sexoDados = dados[2];
					String nome = dados[3];
					String email = dados[4];
					String racaDados = dados[5];
					String atributo = dados[6];
					String descricao = dados[7];

					EnumSexo sexo = EnumSexo.MACHO;
					if(sexoDados.equals(EnumSexo.FEMEA.valor)) {
						sexo = EnumSexo.FEMEA;
					}

					if(EnumRacaCachorro.getValues().contains(racaDados)) {
						EnumRacaCachorro raca = EnumRacaCachorro.getRaca(racaDados);
						EnumTamanho tamanho = EnumTamanho.getTamanho(atributo);
						Cachorro cachorro = new Cachorro(id, idade, sexo, nome, email, raca, tamanho, descricao);
						animais.add(cachorro);
					}else {
						EnumRacaGato raca = EnumRacaGato.getRaca(racaDados);
						EnumPelagem pelagem = EnumPelagem.getPelagem(atributo);
						Gato gato = new Gato(id, idade, sexo, nome, email, raca, pelagem, descricao);
						animais.add(gato);
					}
				}
				csvReader.close();
			}catch (IOException e) {}
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}
	}

}
