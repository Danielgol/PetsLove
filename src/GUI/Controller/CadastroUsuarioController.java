package GUI.Controller;



import java.time.LocalDate;

import GUI.LoginApp;
import GUI.System.CadastroApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CadastroUsuarioController {
	
	private Stage dialogStage;
    private Usuario usuario;
    private boolean okClicked = false;  
    private FachadaPL fachada = FachadaPL.getInstance();
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfSenha;
	  
	    
	    @FXML
	    private void initialize() {
	    }
	    
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	    
	    
	    @FXML
	    private void handleCadastrar() throws UsuarioJaExisteException {
	        this.usuario = new Usuario(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), pfSenha.getText());
	        fachada.cadastrarUsuario(usuario);
	        LoginApp tela = new LoginApp();
	    	CadastroApp.getStage().close();
	    	
	    	try {
				tela.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
	    
	    @FXML
	    private void handleCancelar(ActionEvent ae) {
	    	LoginApp tela = new LoginApp();
	    	CadastroApp.getStage().close();
	    	
	    	try {
				tela.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    }

}
