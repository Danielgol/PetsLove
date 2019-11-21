package GUI.Controller;

import GUI.AlterarSenhaApp;
import GUI.EditarUsuarioApp;
import GUI.PerfilUsuarioApp;
import GUI.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarUsuarioController {

	  @FXML
	    private TextField tfNome;

	    @FXML
	    private TextField tfTelefone;

    @FXML
    void handleCancelar( ) {
    	PerfilUsuarioApp perfilUsuario = new PerfilUsuarioApp();
    	EditarUsuarioApp.getStage().close();
    	
    	try {
			perfilUsuario.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleSalvar( ) {

    }

}
