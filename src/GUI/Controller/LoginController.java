package GUI.Controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import GUI.LoginApp;
import GUI.System.CadastroApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;

public class LoginController implements Initializable{




        @FXML
        private TextField tfEmail;

        @FXML
        private PasswordField pfSenha;




        @FXML void handleCadastrar() {
            CadastroApp c = new CadastroApp();
            LoginApp.getStage().close();
            try {
                c.start(new Stage());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        @FXML
        void handleEntrar() {
        	if(FachadaPL.getInstance().usuarioExiste(tfEmail.getText()))
        	{
        		if(FachadaPL.getInstance().procurarUsuario(tfEmail.getText()).getSenha().equals(pfSenha.getText()))
        		{
        			TelaPrincipalApp t = new TelaPrincipalApp();
                    LoginApp.getStage().close();
                    try {
                        t.start(new Stage());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
        		}else {
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
            // TODO Auto-generated method stub

        }


}