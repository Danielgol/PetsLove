package GUI.Controller;

import GUI.System.AlterarSenhaApp;
import GUI.System.PerfilUsuarioApp;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class AlterarSenhaController {

    @FXML
    private PasswordField pfSenhaAtual;

    @FXML
    private PasswordField pfNovaSenha1;

    @FXML
    private PasswordField pfNovaSenha2;

	  @FXML
	    void handleCancelar() {
		  PerfilUsuarioApp perfilTela = new PerfilUsuarioApp();
		  AlterarSenhaApp.getStage().close();
		  
		  try {
			perfilTela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	  
	   @FXML
	    void handleSalvar( ) {

	    }
}
