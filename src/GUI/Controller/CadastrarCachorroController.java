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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadastrarCachorroController implements Initializable {

	@FXML private TextField tfNome;
	@FXML private TextArea taDescricao;
	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbRaca;
	@FXML private ComboBox<String> cbPorte;
	@FXML private DatePicker dpDataDeNascimento;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> porte = FXCollections.observableArrayList(EnumPorte.GRANDE.valor, EnumPorte.PEQUENO.valor, EnumPorte.MEDIO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());

	@FXML
	void handleCadastrar() {

		if (tfNome.getText().equals("")
				|| !tfNome.getText().matches("^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˚˙ÁÒ¡¿¬√… »Õœ”‘’÷⁄€«— ]+$")) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Nome inv·lido");
			alerta.show();
		} else if (dpDataDeNascimento.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Data de nascimento inv·lida");
			alerta.show();
		} else if (cbSexo.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Sexo inv·lido");
			alerta.show();
		} else if (cbRaca.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("RaÁa inv·lida");
			alerta.show();
		} else if (cbPorte.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Porte inv·lido");
			alerta.show();
		}else if(taDescricao.getText().equals("")) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Cachorro sem descriÁ„o");
			alerta.show();
		}else {

			int idade = Period.between(dpDataDeNascimento.getValue(), LocalDate.now()).getYears();

			EnumSexo sexo = EnumSexo.MACHO;
			if (cbSexo.getValue().equals(EnumSexo.FEMEA.valor)) {
				sexo = EnumSexo.FEMEA;
			}
			
			EnumPorte porte = EnumPorte.getPorte(cbPorte.getValue());
			EnumRacaCachorro raca = EnumRacaCachorro.getRaca(cbRaca.getValue());

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
