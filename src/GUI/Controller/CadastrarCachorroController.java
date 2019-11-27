package GUI.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import GUI.System.CadastrarCachorroApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.enums.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.enums.EnumSexo;
import PetsLove.sistema.negocios.beans.enums.EnumPorte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarCachorroController implements Initializable{

	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbRaca;
	@FXML private TextArea taDescricao;
	@FXML private TextField tfNome;
	@FXML private DatePicker dpDataDeNascimento;
	@FXML private ComboBox<String> cbPorte;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> porte = FXCollections.observableArrayList(EnumPorte.GRANDE.valor, EnumPorte.PEQUENO.valor, EnumPorte.MEDIO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());

	@FXML
	void handleCadastrar() {

		int idade = Period.between(dpDataDeNascimento.getValue(), LocalDate.now()).getYears();

		EnumSexo sexo = null;
		if(cbSexo.getValue().equals(EnumSexo.MACHO.valor)){
			sexo = EnumSexo.MACHO;
		}else if(cbSexo.getValue().equals(EnumSexo.FEMEA.valor)){
			sexo = EnumSexo.FEMEA;
		}

		EnumPorte porte = null;
		for(EnumPorte e: EnumPorte.values()){
			if(e.valor.equals(cbPorte.getValue())){
				porte = e;
				break;
			}
		}

		EnumRacaCachorro raca = null;
		for(EnumRacaCachorro e: EnumRacaCachorro.values()){
			if(e.valor.equals(cbRaca.getValue())){
				raca = e;
				break;
			}
		}
		
		//TODO: Colocar Regras de Cadastro (Todos os campos devem ser preenchidos)

		Cachorro cachorro = new Cachorro
		(idade, sexo, tfNome.getText(), FachadaPL.getUsuarioLogado().getEmail(), raca, porte, taDescricao.getText());
		FachadaPL.getInstance().cadastrarAnimal(cachorro);

		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		CadastrarCachorroApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleCancelar() {
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		CadastrarCachorroApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSexo.setItems(sexo);
		cbPorte.setItems(porte);
		cbRaca.setItems(raca);
	}

}
