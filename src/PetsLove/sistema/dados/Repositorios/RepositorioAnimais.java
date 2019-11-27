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
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.enums.EnumPelagem;
import PetsLove.sistema.negocios.beans.enums.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.enums.EnumRacaGato;
import PetsLove.sistema.negocios.beans.enums.EnumSexo;
import PetsLove.sistema.negocios.beans.enums.EnumPorte;

public class RepositorioAnimais implements IRepositorioAnimais{

	private static RepositorioAnimais instance;

	private ArrayList<Animal> animais;

	private RepositorioAnimais(String arquivo) {
		lerArquivo(arquivo);
	}

	public static RepositorioAnimais getInstance() {
		if (instance == null) {
			instance = new RepositorioAnimais("Arquivos/animais.csv");
		}
		return instance;
	}

	public void cadastrar(Animal animal) {
		this.animais.add(animal);
		atualizarBanco();
	}

	public void remover(Animal animal) {
		this.animais.remove(animal);
		atualizarBanco();
	}

	public void atualizar(Animal animal) {
		int indexUsuario = this.animais.indexOf(animal);
		this.animais.set(indexUsuario, animal);
		atualizarBanco();
	}

	public ArrayList<Animal> listar() {
		return this.animais;
	}

	public boolean existe(String id) {
		return procurar(id) != null;
	}

	public Animal procurar(String id) {
		for(Animal animal : this.animais) {
			if(animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;
	}

	public void atualizarBanco() {
		try {
			FileWriter csvWriter = new FileWriter("Arquivos/animais.csv");
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
					csvWriter.append(((Cachorro) a).getPorte().valor);
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

				while((row = csvReader.readLine()) != null && !row.equals("")){

					String[] dados = row.split(",");
					String id = dados[0];
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
						EnumPorte porte = EnumPorte.getPorte(atributo);
						Cachorro cachorro = new Cachorro(id, idade, sexo, nome, email, raca, porte, descricao);
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
