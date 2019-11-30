package petslove.sistema.negocios.beans;

import java.util.UUID;

import petslove.sistema.negocios.beans.enums.EnumPorte;
import petslove.sistema.negocios.beans.enums.EnumRacaCachorro;
import petslove.sistema.negocios.beans.enums.EnumSexo;

public class Cachorro extends Animal {

	private EnumRacaCachorro raca;
	private EnumPorte porte;
	
	public Cachorro(int idade, EnumSexo sexo, String nome, String email, EnumRacaCachorro raca, EnumPorte porte, String descricao) {
		super(UUID.randomUUID().toString(), idade, sexo, nome, email, descricao);
		this.raca = raca;
		this.porte = porte;
	}

	public Cachorro(String id, int idade, EnumSexo sexo, String nome, String email, EnumRacaCachorro raca, EnumPorte porte, String descricao) {
		super(id, idade, sexo, nome, email, descricao);
		this.raca = raca;
		this.porte = porte;
	}

	public EnumRacaCachorro getRaca() {
		return raca;
	}

	public void setRaca(EnumRacaCachorro raca) {
		this.raca = raca;
	}

	public EnumPorte getPorte() {
		return porte;
	}

	public void setPorte(EnumPorte porte) {
		this.porte = porte;
	}

}
