package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GUI.System.AlterarSenhaApp;
import GUI.System.EditarUsuarioApp;
import GUI.System.PerfilUsuarioApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PerfilUsuarioController implements Initializable{


    @FXML
    private Label labelNome;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelEmail;


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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelNome.setText(FachadaPL.getInstance().getUsuarioLogado().getNome());
		labelEmail.setText(FachadaPL.getInstance().getUsuarioLogado().getEmail());
		labelTelefone.setText(FachadaPL.getInstance().getUsuarioLogado().getNumero());
		
	}
}
