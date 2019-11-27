package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.LoginApp;
import GUI.System.CadastroApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CadastroUsuarioController implements Initializable{

	@FXML private TextField tfNome;
	@FXML private TextField tfEmail;
	@FXML private TextField tfTelefone;
	@FXML private PasswordField pfSenha;
	
	@FXML
	private void handleCadastrar() throws UsuarioJaExisteException {
		Usuario usuario = new Usuario(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), pfSenha.getText());
		
		int countPonto = 0;
		int posPonto = tfEmail.getText().indexOf(".");
		
		while ( posPonto != -1 ) {
		   countPonto++;
		   posPonto = tfEmail.getText().indexOf( ".",posPonto + 1 );
		}
		
		int countArroba = 0;
		int posArroba = tfEmail.getText().indexOf("@");
		
		while ( posArroba != -1 ) {
		   countArroba++;
		   posArroba = tfEmail.getText().indexOf( "@",posArroba + 1 );
		}
		
		if(FachadaPL.getInstance().usuarioExiste(tfEmail.getText()) == false && !tfEmail.getText().equals("") 
				&& tfEmail.getText().indexOf(" ") == -1 && tfEmail.getText().endsWith(".com")
				&& countArroba == 1 && countPonto == 1) {
			if(!tfNome.getText().equals("") && tfNome.getText().matches("^[A-Za-záàâãéèêíïóôõöûúçñÁÀÂÃÉÊÈÍÏÓÔÕÖÚÛÇÑ ]+$") == true) {
				if(!pfSenha.getText().equals("")){
					if(tfTelefone.getText().length() == 9 && tfTelefone.getText().matches("[0-9]+") == true
							&& tfTelefone.getText().indexOf(" ") == -1){
						FachadaPL.getInstance().cadastrarUsuario(usuario);
						LoginApp tela = new LoginApp();
						CadastroApp.getStage().close();
						try {
							tela.start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						Alert alerta = new Alert(AlertType.ERROR);
						alerta.setHeaderText("Telefone incorreto");
						alerta.setTitle("Erro");
						alerta.setContentText("Telefone com valores inválidos, digite o telefone com apenas 9 dígitos");
						alerta.show();
					}
				}else {
					Alert alerta = new Alert(AlertType.ERROR);
					alerta.setHeaderText("Senha nula");
					alerta.setTitle("Erro");
					alerta.setContentText("Senha nula, digite a nova senha novamente");
					alerta.show();
				}
			}else {
				if(tfNome.getText().equals("")) {
					Alert alerta = new Alert(AlertType.ERROR);
					alerta.setHeaderText("Nome nulo");
					alerta.setTitle("Erro");
					alerta.setContentText("Nome nulo, digite o nome novamente");
					alerta.show();
				}else {
					Alert alerta = new Alert(AlertType.ERROR);
					alerta.setHeaderText("Nome inválido");
					alerta.setTitle("Erro");
					alerta.setContentText("Nome inválido, digite somente letras");
					alerta.show();
				}
			}
		}else {
			if(FachadaPL.getInstance().usuarioExiste(tfEmail.getText()) == true){
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Email já existe");
				alerta.setTitle("Erro");
				alerta.setContentText("Email indisponível, tente outro email");
				alerta.show();
			}else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Email nulo ou inválido");
				alerta.setTitle("Erro");
				alerta.setContentText("Email nulo ou inválido, digite um email com @, '.com' e sem deixar espaços");
				alerta.show();
			}
		}
	}

	@FXML
	private void handleCancelar(ActionEvent ae) {
		LoginApp tela = new LoginApp();
		CadastroApp.getStage().close();

		try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tfNome.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				try {
					handleCadastrar();
				} catch (UsuarioJaExisteException e1) {
					e1.printStackTrace();
				}
			}
		});
		tfTelefone.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				try {
					handleCadastrar();
				} catch (UsuarioJaExisteException e1) {
					e1.printStackTrace();
				}
			}
		});
		pfSenha.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				try {
					handleCadastrar();
				} catch (UsuarioJaExisteException e1) {
					e1.printStackTrace();
				}
			}
		});
		tfEmail.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				try {
					handleCadastrar();
				} catch (UsuarioJaExisteException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
