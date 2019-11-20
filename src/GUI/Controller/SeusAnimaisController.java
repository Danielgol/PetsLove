package GUI.Controller;

import GUI.SeusAnimaisApp;
import GUI.TelaPrincipalApp;
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
    void handleSair() {
    	TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
