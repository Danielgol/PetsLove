package GUI.Controller;

import GUI.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TelaPrincipalController {

	private Stage dialogStage;
	
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
	       
	    	 MainApp.abrirSeusAnimais();
	       
	    }
	    
	    @FXML
	    private void handleCaixaDeEntrada() {
	       
	    	 MainApp.abrirCaixaDeEntrada();
	       
	    }
	    
	    @FXML
	    private void handleSuasSolicitacoes() {
	       
	    	 MainApp.abrirSuasSolicitacoes();
	       
	    }
	    
	    @FXML
	    private void handlePerfil() {
	       
	    	 MainApp.abrirPerfilUsuario();
	       
	    }
	    
	    @FXML
	    private void handleSair(ActionEvent ae) {
	       
	    	this.dialogStage.close();
	       
	    }
	    
}
