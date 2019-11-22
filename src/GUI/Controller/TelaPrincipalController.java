package GUI.Controller;

import GUI.LoginApp;
import GUI.System.CaixaDeEntradaApp;
import GUI.System.PerfilUsuarioApp;
import GUI.System.SeusAnimaisApp;
import GUI.System.SuasSolicitacoesApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import PetsLove.sistema.FachadaPL;

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
	       SeusAnimaisApp seusAn = new SeusAnimaisApp();
	       TelaPrincipalApp.getStage().close();
	       
	       try {
			seusAn.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    
	    @FXML
	    private void handleCaixaDeEntrada() {
	       CaixaDeEntradaApp caixaEnt = new CaixaDeEntradaApp();
	       TelaPrincipalApp.getStage().close();
	    	
	       try {
			caixaEnt.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	    }
	    
	    @FXML
	    private void handleSuasSolicitacoes() {
	    	SuasSolicitacoesApp suasSol = new SuasSolicitacoesApp();
	    	TelaPrincipalApp.getStage().close();
	    	
	    	try {
				suasSol.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    private void handlePerfil() {
	       
	    	 PerfilUsuarioApp perfil = new PerfilUsuarioApp();
	    	 TelaPrincipalApp.getStage().close();
	    	 
	    	 try {
				perfil.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	    }
	    
	    @FXML
	    void handleEnviarSolicitacao(ActionEvent event) {

	    }

	    
	    @FXML
	    private void handleSair(ActionEvent ae) {
	        FachadaPL.getInstance();
			FachadaPL.logout();
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
