package GUI.Controller;

import GUI.AlterarSenhaApp;
import GUI.PerfilUsuarioApp;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AlterarSenhaController {

	  @FXML
	    void handleSair() {
		  PerfilUsuarioApp perfilTela = new PerfilUsuarioApp();
		  AlterarSenhaApp.getStage().close();
		  
		  try {
			perfilTela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
}
