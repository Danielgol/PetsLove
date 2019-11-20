package GUI.Controller;

import GUI.LoginApp;
import GUI.TelaPrincipalApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TelaPrincipalController {

		
	
	  @FXML
	    private TableView<?> tabelaAnimais;

	    @FXML
	    private Label labelTipo;

	    @FXML
	    private Label labelNome;

	    @FXML
	    private Label labelSexo;

	    @FXML
	    private Label labelIdade;

	    @FXML
	    private Label labelRacaPelagem;

	    @FXML
	    private Label labelDescricao;
	    
	    @FXML
	    private void handleSeusAnimais() {
	       
	       
	    }
	    
	    @FXML
	    private void handleCaixaDeEntrada() {
	       
	    	
	       
	    }
	    
	    @FXML
	    private void handleSuasSolicitacoes() {
	   
	       
	    }
	    
	    @FXML
	    private void handlePerfil() {
	       
	    	 
	       
	    }
	    
	    @FXML
	    private void handleSair(ActionEvent ae) {
	        LoginApp login = new LoginApp();
	    	TelaPrincipalApp.getStage().close();
	    	
	    	try {
				login.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	    }
	    
}
