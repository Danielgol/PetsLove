package GUI.Controller;

import GUI.LoginApp;
import GUI.System.CadastroApp;
import GUI.System.EnviarSolicitacaoApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.negocios.beans.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class EnviarSolicitacaoController {

    @FXML
    private TableView<Animal> tabelaAnimais;

    @FXML
    private TableColumn<Animal, String> colunaAnimais;

    @FXML
    private TableColumn<Animal, String> colunaTipo;

    @FXML
    void handleCancelar( ) {
    	TelaPrincipalApp tela = new TelaPrincipalApp();
    	EnviarSolicitacaoApp.getStage().close();
    	
    	try {
			tela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleConfirmar( ) {
    	
    }

}
