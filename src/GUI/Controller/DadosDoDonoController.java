package GUI.Controller;

import GUI.System.DadosDoDonoApp;
import GUI.System.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DadosDoDonoController {

	@FXML private Label nomeDono;
    @FXML private Label numeroDono;
    @FXML private Label emailDono;

    @FXML
    void handleSair() {
    	TelaPrincipalApp tela = new TelaPrincipalApp();
    	DadosDoDonoApp.getStage().close();
    	
    	try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
