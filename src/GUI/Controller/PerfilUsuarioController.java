package GUI.Controller;

import GUI.System.AlterarSenhaApp;
import GUI.System.EditarUsuarioApp;
import GUI.System.PerfilUsuarioApp;
import GUI.System.TelaPrincipalApp;
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
    void handleEditarDados( ) {
    	 EditarUsuarioApp editarDados = new EditarUsuarioApp();
         PerfilUsuarioApp.getStage().close();
         
         try {
  		editarDados.start(new Stage());
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
