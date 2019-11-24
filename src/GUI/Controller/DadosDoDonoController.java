package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GUI.System.CaixaDeEntradaApp;
import GUI.System.DadosDoDonoApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DadosDoDonoController implements Initializable {

	public static Usuario selecionado;
	
	@FXML private Label nomeDono;
    @FXML private Label numeroDono;
    @FXML private Label emailDono;

    @FXML
    void handleSair() {
    	CaixaDeEntradaApp tela = new CaixaDeEntradaApp();
    	DadosDoDonoApp.getStage().close();
    	
    	try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void setSelecionado(Usuario dono)
    {
    	selecionado = dono;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
}
