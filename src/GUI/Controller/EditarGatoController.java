package GUI.Controller;

import GUI.System.CadastrarGatoApp;
import GUI.System.EditarGatoApp;
import GUI.System.SeusAnimaisApp;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarGatoController {


    @FXML
    private ComboBox<String> cbSexo;

    @FXML
    private ComboBox<String> cbPelagem;

    @FXML
    private TextArea taDescricao;

    @FXML
    private TextField tfNome;
    @FXML
    private ComboBox<String> cbRaca;

    @FXML
    private DatePicker dpDataDeNascimento;


    @FXML
    void handleCancelar( ) {
    	SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
    	EditarGatoApp.getStage().close();
    	
    	try {
    		seusAnimais.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleSalvar( ) {

    }
    
}
