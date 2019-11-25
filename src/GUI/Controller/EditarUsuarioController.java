package GUI.Controller;

import GUI.System.EditarUsuarioApp;
import GUI.System.PerfilUsuarioApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarUsuarioController {

	@FXML private TextField tfNome;
	@FXML private TextField tfTelefone;

	@FXML
	void handleCancelar() {
		PerfilUsuarioApp perfilUsuario = new PerfilUsuarioApp();
		EditarUsuarioApp.getStage().close();

		try {
			perfilUsuario.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleSalvar() throws UsuarioNaoExisteException {
		FachadaPL.getUsuarioLogado().setNome(tfNome.getText());
		FachadaPL.getUsuarioLogado().setNumero(tfTelefone.getText());
		FachadaPL.getInstance().atualizarUsuario(FachadaPL.getUsuarioLogado());

		PerfilUsuarioApp perfilUsuario = new PerfilUsuarioApp();
		EditarUsuarioApp.getStage().close();

		try {
			perfilUsuario.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
