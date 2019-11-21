package GUI.Controller;

import GUI.CaixaDeEntradaApp;
import GUI.DadosDoDonoApp;
import GUI.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CaixaDeEntradaController {

	 @FXML
	    private TableView<?> tabelaSolicitacoes;

	    @FXML
	    private Label nomeAnimal;

	    @FXML
	    private Label statusSolicitacao;

	    @FXML
	    void handleVoltar() {
	    	TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
	    	CaixaDeEntradaApp.getStage().close();
	    	
	    	try {
				telaPrinc.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void handleAceitar() {

	    }

	    @FXML
	    void handleDadosDoDono() {
	    	DadosDoDonoApp telaDono = new DadosDoDonoApp();
	    	CaixaDeEntradaApp.getStage().close();
	    	
	    	try {
				telaDono.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void handleRecusar() {

	    }
}
