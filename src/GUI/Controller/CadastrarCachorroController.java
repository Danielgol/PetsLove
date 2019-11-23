package GUI.Controller;

import GUI.System.CadastrarCachorroApp;
import GUI.System.SeusAnimaisApp;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarCachorroController {


    @FXML
    private ComboBox<?> cbSexo;

    @FXML
    private ComboBox<?> cbRaca;

    @FXML
    private TextArea taDescricao;

    @FXML
    private TextField tfNome;

    @FXML
    private DatePicker dpDataDeNascimento;


    @FXML
    private ComboBox<?> cbTamanho;

    @FXML
    void handleCadastrar( ) {

    }

    @FXML
    void handleCancelar( ) {
    	SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
    	CadastrarCachorroApp.getStage().close();
    	
    	try {
    		seusAnimais.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
