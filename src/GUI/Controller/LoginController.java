package GUI.Controller;

import GUI.MainApp;
import PetsLove.sistema.FachadaPL;
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

	@FXML
	public void handleCadastrese()
	{
		
	}
}
