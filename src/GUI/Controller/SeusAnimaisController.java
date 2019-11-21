package GUI.Controller;

import GUI.System.CadastrarCachorroApp;
import GUI.System.CadastrarGatoApp;
import GUI.System.EditarCachorroApp;
import GUI.System.SeusAnimaisApp;
import GUI.System.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SeusAnimaisController {


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
    void handleVoltar() {
    	TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void handleCadastrarCachorro( ) {
    	CadastrarCachorroApp cadastrarCachorro = new CadastrarCachorroApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			cadastrarCachorro.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleCadastrarGato( ) {
    	CadastrarGatoApp cadastrarGato = new CadastrarGatoApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			cadastrarGato.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleEditar( ) {
    	EditarCachorroApp editarCao = new EditarCachorroApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			editarCao.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleRemover( ) {

    }

}
