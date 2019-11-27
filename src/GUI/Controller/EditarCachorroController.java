package GUI.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import GUI.System.CadastrarCachorroApp;
import GUI.System.EditarCachorroApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Animal;
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

public class EditarCachorroController implements Initializable {

	public static Cachorro selecionado;

	@FXML
	private TextArea taDescricao;
	@FXML
	private TextField tfNome;
	@FXML
	private DatePicker dpDataDeNascimento;
	@FXML
	private ComboBox<String> cbSexo;
	@FXML
	private ComboBox<String> cbPorte;
	@FXML
	private ComboBox<String> cbRaca;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> porte = FXCollections.observableArrayList(EnumPorte.GRANDE.valor, EnumPorte.PEQUENO.valor,
			EnumPorte.MEDIO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());

	// TODO: Quando carregar a tela, colocar automaticamente os dados atuais do
	// animal nos campos

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
				|| !tfNome.getText().matches("^[A-Za-z���������������������������������� ]+$")) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Nome inv�lido");
			alerta.show();
		} else if (dpDataDeNascimento.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Data de nascimento inv�lida");
			alerta.show();
		} else if (cbSexo.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Sexo inv�lido");
			alerta.show();
		} else if (cbRaca.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Ra�a inv�lida");
			alerta.show();
		} else if (cbPorte.getValue() == null) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao cadastrar");
			alerta.setTitle("Erro");
			alerta.setContentText("Porte inv�lido");
			alerta.show();
		} else {
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
	}

}
