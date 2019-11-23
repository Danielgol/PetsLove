package GUI.Controller;


import GUI.System.EditarCachorroApp;
import GUI.System.SeusAnimaisApp;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarCachorroController {

	  @FXML
	    private TextArea taDescricao;

	    @FXML
	    private TextField tfNome;

	    @FXML
	    private DatePicker dpDataDeNascimento;

	    @FXML
	    private ComboBox<String> cbSexo;

	    @FXML
	    private ComboBox<String> cbPelagem;

	    @FXML
	    private ComboBox<String> cbRaca;

    @FXML
    void handleCancelar( ) {
    	SeusAnimaisApp seusAnimaisTela = new SeusAnimaisApp();
    	EditarCachorroApp.getStage().close();
    	try {
			seusAnimaisTela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleSalvar() {

    }

}
