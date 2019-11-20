package GUI.Controller;



import GUI.CadastroApp;
import GUI.LoginApp;
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
    private FachadaPL fachada;
    
	  @FXML
	    private TextField tfNome;

	    @FXML
	    private TextField tfEmail;

	    @FXML
	    private PasswordField pfSenha;

	    @FXML
	    private TextField tfTelefone;

	  
	    
	    @FXML
	    private void initialize() {
	    }
	    
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	    public void setUsuario(Usuario u) {
	    	this.usuario = u;
	    	tfNome.setText(u.getNome());;
	    	tfEmail.setText(u.getEmail());;
	    	pfSenha.setText(u.getSenha());;
	    	tfTelefone.setText(u.getNumero());;
	    }
	    
	    @FXML
	    private void handleCadastrar() throws UsuarioJaExisteException {
	        
	        
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
