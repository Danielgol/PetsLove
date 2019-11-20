package GUI.Controller;


import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import GUI.CadastroApp;
import GUI.LoginApp;
import GUI.TelaPrincipalApp;

public class LoginController implements Initializable{

	
		
	
		@FXML
	    private TextField tfEmail;

	    @FXML
	    private PasswordField tfSenha;
	    
	    

	    @FXML void handleCadastrar() {
	    	CadastroApp c = new CadastroApp();
	    	LoginApp.getStage().close();
	    	try {
				c.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    @FXML
	    void handleEntrar() {
	    	TelaPrincipalApp t = new TelaPrincipalApp();
	    	LoginApp.getStage().close();
	    	try {
				t.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		@Override
		public void initialize(URL url, ResourceBundle rb) {
			// TODO Auto-generated method stub
			
		}
	   
	    
}
