package GUI.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;

import GUI.System.CadastrarGatoApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.EnumPelagem;
import PetsLove.sistema.negocios.beans.EnumRacaGato;
import PetsLove.sistema.negocios.beans.EnumSexo;
import PetsLove.sistema.negocios.beans.Gato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarGatoController implements Initializable{

	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbPelagem;
	@FXML private TextArea taDescricao;
	@FXML private TextField tfNome;
	@FXML private ComboBox<String> cbRaca;
	@FXML private DatePicker dpDataDeNascimento;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.sexo, EnumSexo.FEMEA.sexo);
	ObservableList<String> pelagem = FXCollections.observableArrayList(EnumPelagem.FELPUDO.pelagem, EnumPelagem.MEDIO.pelagem, EnumPelagem.RASO.pelagem);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaGato.getValues());

	@FXML
	public void handleCadastrar( ) {
		
		//TODO: Colocar Regras de Cadastro (Todos os campos devem ser preenchidos)

		int idade = Period.between(dpDataDeNascimento.getValue(), LocalDate.now()).getYears();
		
		EnumSexo sexo = null;
		if(cbSexo.getValue().equals(EnumSexo.MACHO.sexo)){
			sexo = EnumSexo.MACHO;
		}
		else if(cbSexo.getValue().equals(EnumSexo.FEMEA.sexo)){
			sexo = EnumSexo.FEMEA;
		}

		EnumPelagem pelagem = null;
		for(EnumPelagem e: EnumPelagem.values()){
			if(e.pelagem.equals(cbPelagem.getValue())){
				pelagem = e;
			}
		}

		EnumRacaGato raca = null;
		for(EnumRacaGato e: EnumRacaGato.values()){
			if(e.valor.equals(cbRaca.getValue())){
				raca = e;
			}
		}

		Gato gato = new Gato(FachadaPL.getInstance().listarAnimaisPorDono(FachadaPL.getUsuarioLogado()).size()+1, 
				idade,  sexo, tfNome.getText(), FachadaPL.getUsuarioLogado(), 
				pelagem, raca, taDescricao.getText());
		FachadaPL.getInstance().cadastrarAnimal(gato);
	
		
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		CadastrarGatoApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void handleCancelar( ) {
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		CadastrarGatoApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSexo.setItems(sexo);
		cbPelagem.setItems(pelagem);
		cbRaca.setItems(raca);
	}

}
