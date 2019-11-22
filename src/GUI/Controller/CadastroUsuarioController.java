package GUI.Controller;



import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import GUI.LoginApp;
import GUI.System.CadastroApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CadastroUsuarioController implements Initializable{
	
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
	  
    	
    	@Override
    	public void initialize(URL arg0, ResourceBundle arg1) {
    		// TODO Auto-generated method stub
    		tfNome.setOnKeyPressed((KeyEvent e)->{
    			if(e.getCode() == KeyCode.ENTER) {
    				try {
						handleCadastrar();
					} catch (UsuarioJaExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    		});
    		
    		tfTelefone.setOnKeyPressed((KeyEvent e)->{
    			if(e.getCode() == KeyCode.ENTER) {
    				try {
						handleCadastrar();
					} catch (UsuarioJaExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    		});
    		
    		pfSenha.setOnKeyPressed((KeyEvent e)->{
    			if(e.getCode() == KeyCode.ENTER) {
    				try {
						handleCadastrar();
					} catch (UsuarioJaExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    		});
    		
    		tfEmail.setOnKeyPressed((KeyEvent e)->{
    			if(e.getCode() == KeyCode.ENTER) {
    				try {
						handleCadastrar();
					} catch (UsuarioJaExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    		});
    	}
	   
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	    
	    
	    
	    @FXML
	    private void handleCadastrar() throws UsuarioJaExisteException {
	        this.usuario = new Usuario(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), pfSenha.getText());
	        if(fachada.usuarioExiste(tfEmail.getText()) == false && !tfEmail.getText().equals("") 
	        		&& tfEmail.getText().indexOf(" ") == -1 && tfEmail.getText().endsWith(".com") && tfEmail.getText().indexOf("@") != -1) {
	        	if(!tfNome.getText().equals("") && tfNome.getText().matches("^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˚˙ÁÒ¡¿¬√… »Õœ”‘’÷⁄€«— ]+$") == true) {
	        		if(!pfSenha.getText().equals("")){
	        			if(tfTelefone.getText().length() == 9 && tfTelefone.getText().matches("[0-9]+") == true
	        					&& tfTelefone.getText().indexOf(" ") == -1){
	        				fachada.cadastrarUsuario(usuario);
	        				LoginApp tela = new LoginApp();
	        				CadastroApp.getStage().close();
	        				try {
	        					tela.start(new Stage());
	        				} catch (Exception e) {
	        					// TODO Auto-generated catch block
	        					e.printStackTrace();
	        			}
	        			}else {
	        				Alert alerta = new Alert(AlertType.ERROR);
			            	alerta.setHeaderText("Telefone incorreto");
			            	alerta.setTitle("Erro");
			            	alerta.setContentText("Telefone com valores inv·lidos, digite o telefone com apenas 9 dÌgitos");
			            	alerta.show();
	        			}
	        		}else {
	        			Alert alerta = new Alert(AlertType.ERROR);
		            	alerta.setHeaderText("Senha nula");
		            	alerta.setTitle("Erro");
		            	alerta.setContentText("Senha nula, digite a nova senha novamente");
		            	alerta.show();
	        		}
	        	}else {
	        		if(tfNome.getText().equals("")) {
	        			Alert alerta = new Alert(AlertType.ERROR);
	        			alerta.setHeaderText("Nome nulo");
	        			alerta.setTitle("Erro");
	        			alerta.setContentText("Nome nulo, digite o nome novamente");
	        			alerta.show();
	        		}else {
	        			Alert alerta = new Alert(AlertType.ERROR);
		            	alerta.setHeaderText("Nome inv·lido");
		            	alerta.setTitle("Erro");
		            	alerta.setContentText("Nome inv·lido, digite somente letras");
		            	alerta.show();
	        		}
	        	}
	        }else {
	        		if(fachada.usuarioExiste(tfEmail.getText()) == true){
	        		Alert alerta = new Alert(AlertType.ERROR);
	        		alerta.setHeaderText("Email j· existe");
	        		alerta.setTitle("Erro");
	        		alerta.setContentText("Email indisponÌvel, tente outro email");
	        		alerta.show();
	        	}else {
	        		Alert alerta = new Alert(AlertType.ERROR);
	        		alerta.setHeaderText("Email nulo ou inv·lido");
	        		alerta.setTitle("Erro");
	        		alerta.setContentText("Email nulo ou inv·lido, digite um email com @, '.com' e sem deixar espaÁos");
	        		alerta.show();
	        	}
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
