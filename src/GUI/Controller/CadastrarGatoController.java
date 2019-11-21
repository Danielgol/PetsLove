package GUI.Controller;

import GUI.System.CadastrarGatoApp;
import GUI.System.SeusAnimaisApp;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarGatoController {

	   @FXML
	    private ChoiceBox<?> cbSexo;

	    @FXML
	    private ChoiceBox<?> cbPelagem;

	    @FXML
	    private TextArea taDescricao;

	    @FXML
	    private TextField tfNome;

	    @FXML
	    private TextField tfIdade;

	    @FXML
	    void handleCadastrar( ) {

	    }

	    @FXML
	    void handleCancelar( ) {
	    	SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
	    	CadastrarGatoApp.getStage().close();
	    	
	    	try {
	    		seusAnimais.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
}
