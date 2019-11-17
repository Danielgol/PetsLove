package GUI.Controller;

import GUI.MainApp;
import PetsLove.sistema.FachadaPL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LoginController {

	private MainApp mainApp;
	private FachadaPL fachada = FachadaPL.getInstance();
	

    @FXML
    private Pane painelPrincipal;

    @FXML
    private ImageView Logo;

    @FXML
    private Label email;

    @FXML
    private TextField digitarEmail;

    @FXML
    private Label senha;

    @FXML
    private PasswordField digitarSenha;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Label labelSemConta;

    @FXML
    private Button botaoCadastrar;
	
}
