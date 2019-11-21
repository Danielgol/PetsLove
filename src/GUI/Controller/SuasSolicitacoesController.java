package GUI.Controller;


import GUI.SuasSolicitacoesApp;
import GUI.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SuasSolicitacoesController {

	  @FXML
	    private TableView<?> tabelaSolicitacoes;

	    @FXML
	    private Label nomeAnimal;

	    @FXML
	    private Label statusSolicitacao;

	    
	    @FXML
	    void handleVoltar() {
	    	TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
	    	SuasSolicitacoesApp.getStage().close();
	    	
	    	try {
				telaPrinc.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void handleCancelarSolicitacao( ) {

	    }

	    @FXML
	    void handleDadosDoDono( ) {

	    }

}
