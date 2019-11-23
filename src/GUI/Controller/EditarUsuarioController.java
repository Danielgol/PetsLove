package GUI.Controller;

import GUI.System.AlterarSenhaApp;
import GUI.System.EditarUsuarioApp;
import GUI.System.PerfilUsuarioApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioNaoExisteException;
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
    void handleSalvar( ) throws UsuarioNaoExisteException {
    	FachadaPL.getInstance().getUsuarioLogado().setNome(tfNome.getText());
    	FachadaPL.getInstance().getUsuarioLogado().setNumero(tfTelefone.getText());
    	FachadaPL.getInstance().atualizarUsuario(FachadaPL.getInstance().getUsuarioLogado());
    	PerfilUsuarioApp perfilUsuario = new PerfilUsuarioApp();
    	EditarUsuarioApp.getStage().close();
    	
    	try {
			perfilUsuario.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
