package GUI.Controller;

import GUI.MainApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

	private MainApp mainApp;
	private FachadaPL fachada = FachadaPL.getInstance();
	
		@FXML
	    private TextField tfEmail;

	    @FXML
	    private PasswordField tfSenha;
	    
	    public void setMainApp(MainApp app) {
			this.mainApp = app;
		}
	    
	    @FXML
	    private void initialize() {
	        
	    }

	    @FXML
	    private void handleCadastrar() {
	       
	    	 mainApp.abrirCadastro();
	       
	    }
	    
	    @FXML
	    private void handleEntrar() {
	       
	    	 mainApp.abrirTelaPrincipal();
	       
	    }
	    
	    
}
