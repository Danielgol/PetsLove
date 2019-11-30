package petslove.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import petslove.gui.system.AlterarSenhaApp;
import petslove.gui.system.EditarUsuarioApp;
import petslove.gui.system.PerfilUsuarioApp;
import petslove.gui.system.TelaPrincipalApp;
import petslove.sistema.FachadaPL;

public class PerfilUsuarioController implements Initializable{

	@FXML private Label labelNome;
	@FXML private Label labelEmail;
	@FXML private Label labelTelefone;

	@FXML
	private void handleAlterarSenha() {
		AlterarSenhaApp alterarSenha = new AlterarSenhaApp();
		PerfilUsuarioApp.getStage().close();

		try {
			alterarSenha.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleEditarDados() {
		EditarUsuarioApp editarDados = new EditarUsuarioApp();
		PerfilUsuarioApp.getStage().close();

		try {
			editarDados.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleVoltar() {
		TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
		PerfilUsuarioApp.getStage().close();

		try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelNome.setText(FachadaPL.getUsuarioLogado().getNome());
		labelEmail.setText(FachadaPL.getUsuarioLogado().getEmail());
		labelTelefone.setText(FachadaPL.getUsuarioLogado().getNumero());
	}
	
}
