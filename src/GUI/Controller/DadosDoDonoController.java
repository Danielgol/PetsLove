package GUI.Controller;

import GUI.DadosDoDonoApp;
import GUI.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DadosDoDonoController {

	@FXML
    private Label nomeDono;

    @FXML
    private Label numeroDono;

    @FXML
    private Label emailDono;

    @FXML
    void handleSair() {
    	TelaPrincipalApp tela = new TelaPrincipalApp();
    	DadosDoDonoApp.getStage().close();
    	
    	try {
			tela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
