package GUI.Controller;

import GUI.AlterarSenhaApp;
import GUI.PerfilUsuarioApp;
import GUI.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PerfilUsuarioController {


    @FXML
    private Label nomeUsuario;

    @FXML
    private Label numeroUsuario;

    @FXML
    private Label emailUsuario;

    @FXML
    private Label idUsuario;

    @FXML
    private void handleAlterarSenha() {
       AlterarSenhaApp alterarSenha = new AlterarSenhaApp();
       PerfilUsuarioApp.getStage().close();
       
       try {
		alterarSenha.start(new Stage());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    @FXML
    void handleSair() {
    	TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
    	PerfilUsuarioApp.getStage().close();
    	
    	try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
