package petslove.gui.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

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
import petslove.gui.system.EditarCachorroApp;
import petslove.gui.system.SeusAnimaisApp;
import petslove.sistema.FachadaPL;
import petslove.sistema.negocios.beans.Animal;
import petslove.sistema.negocios.beans.Cachorro;
import petslove.sistema.negocios.beans.enums.EnumPorte;
import petslove.sistema.negocios.beans.enums.EnumRacaCachorro;
import petslove.sistema.negocios.beans.enums.EnumSexo;

public class EditarCachorroController implements Initializable {

	public static Cachorro selecionado;

	@FXML private TextArea taDescricao;
	@FXML private TextField tfNome;
	@FXML private DatePicker dpDataDeNascimento;
	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbPorte;
	@FXML private ComboBox<String> cbRaca;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> porte = FXCollections.observableArrayList(EnumPorte.GRANDE.valor, EnumPorte.PEQUENO.valor, EnumPorte.MEDIO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());

	@FXML
	void handleCancelar() {
		selecionado = null;
		SeusAnimaisApp seusAnimaisTela = new SeusAnimaisApp();
		EditarCachorroApp.getStage().close();
		
		try {
			seusAnimaisTela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleSalvar() {

		if (tfNome.getText().equals("")
				|| !tfNome.getText().matches("^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˚˙ÁÒ¡¿¬√… »Õœ”‘’÷⁄€«— ]+$")) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("Nome inv·lido");
			alerta.show();
		} else if (dpDataDeNascimento.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("Data de nascimento inv·lida");
			alerta.show();
		} else if (cbSexo.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("Sexo inv·lido");
			alerta.show();
		} else if (cbRaca.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("RaÁa inv·lida");
			alerta.show();
		} else if (cbPorte.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("Porte inv·lido");
			alerta.show();
		}else if(taDescricao.getText().equals("")) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
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

			selecionado.setNome(tfNome.getText());
			selecionado.setIdade(idade);
			selecionado.setDescricao(taDescricao.getText());
			selecionado.setRaca(raca);
			selecionado.setPorte(porte);
			selecionado.setSexo(sexo);

			FachadaPL.getInstance().atualizarAnimal(selecionado);
			
			SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
			EditarCachorroApp.getStage().close();

			try {
				seusAnimais.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void setSelecionado(Animal animal) {
		if (FachadaPL.getUsuarioLogado().equals(FachadaPL.getInstance().procurarUsuario(animal.getEmailDono()))) {
			selecionado = (Cachorro) animal;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSexo.setItems(sexo);
		cbPorte.setItems(porte);
		cbRaca.setItems(raca);
		tfNome.setText(selecionado.getNome());
		taDescricao.setText(selecionado.getDescricao());
		cbSexo.getSelectionModel().select(selecionado.getSexo().valor);
		cbPorte.getSelectionModel().select(selecionado.getPorte().valor);
		cbRaca.getSelectionModel().select(selecionado.getRaca().valor);
	}

}
