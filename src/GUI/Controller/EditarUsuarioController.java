package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.System.EditarUsuarioApp;
import GUI.System.PerfilUsuarioApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarUsuarioController implements Initializable{

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
		
		if(tfNome.getText().equals("")
				|| !tfNome.getText().matches("^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˚˙ÁÒ¡¿¬√… »Õœ”‘’÷⁄€«— ]+$")) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("Nome inv·lido");
			alerta.show();
		}else if(tfTelefone.getText().length() != 9 || !tfTelefone.getText().matches("[0-9]+")
				|| tfTelefone.getText().indexOf(" ") != -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Erro ao editar");
			alerta.setTitle("Erro");
			alerta.setContentText("N˙mero de Telefone inv·lido");
			alerta.show();
		}else {
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tfNome.setText(FachadaPL.getUsuarioLogado().getNome());
		tfTelefone.setText(FachadaPL.getUsuarioLogado().getNumero());
	}

}
