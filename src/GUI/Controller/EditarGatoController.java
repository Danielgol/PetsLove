package GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    }

    @FXML
    void handleSalvar( ) {

    }
    
}
