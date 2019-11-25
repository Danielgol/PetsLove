package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import GUI.LoginApp;
import GUI.System.CadastroApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;

public class LoginController implements Initializable{

	@FXML private TextField tfEmail;
	@FXML private PasswordField pfSenha;

	@FXML void handleCadastrar() {
		CadastroApp c = new CadastroApp();
		LoginApp.getStage().close();
		try {
			c.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleEntrar(ActionEvent ev) {
		logar();
	}

	public void logar() {
		if(FachadaPL.getInstance().usuarioExiste(tfEmail.getText())){
			FachadaPL.login(tfEmail.getText(), pfSenha.getText());
			if(FachadaPL.getUsuarioLogado() != null){
				TelaPrincipalApp t = new TelaPrincipalApp();
				LoginApp.getStage().close();
				try {
					t.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Erro");
				alerta.setTitle("Senha incorreta");
				alerta.setContentText("Senha incorreta, digite novamente");
				alerta.show();
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Email incorreto");
			alerta.setTitle("Erro");
			alerta.setContentText("Email incorreto, digite novamente");
			alerta.show();
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		pfSenha.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				logar();
			}
		});
		tfEmail.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				logar();
			}
		});
	}

}