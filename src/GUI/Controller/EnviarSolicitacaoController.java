package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GUI.LoginApp;
import GUI.System.CadastroApp;
import GUI.System.EnviarSolicitacaoApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Animal;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EnviarSolicitacaoController implements Initializable{

    @FXML private TableView<Animal> tabelaAnimais;
    @FXML private TableColumn<Animal, String> colunaAnimais;
    @FXML private TableColumn<Animal, String> colunaTipo;

    @FXML
    void handleCancelar( ) {
    	TelaPrincipalApp tela = new TelaPrincipalApp();
    	EnviarSolicitacaoApp.getStage().close();
    	
    	try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void handleConfirmar( ) {
    	
    }

    public void initTable() {
		colunaAnimais.setCellValueFactory(new PropertyValueFactory<Animal, String>("nome"));
		colunaTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
		tabelaAnimais.setItems(atualizaTabela());
	}

	public ObservableList<Animal> atualizaTabela(){
		
		return FXCollections.observableArrayList(FachadaPL.getInstance().listarAnimais());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
		
	}

}
