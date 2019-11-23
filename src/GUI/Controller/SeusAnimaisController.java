package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GUI.System.CadastrarCachorroApp;
import GUI.System.CadastrarGatoApp;
import GUI.System.EditarCachorroApp;
import GUI.System.SeusAnimaisApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SeusAnimaisController implements Initializable {

	private FachadaPL fachada = FachadaPL.getInstance();
	
    @FXML
    private TableView<Animal> tabelaAnimais;
    
    @FXML
    private TableColumn<Animal, String> clmAnimais;
    
    @FXML
    private Label labelTipo;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelSexo;

    @FXML
    private Label labelIdade;

    @FXML
    private Label labelRacaPelagem;

    @FXML
    private Label labelDescricao;
    
    @FXML
    void handleVoltar() {
    	TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void handleCadastrarCachorro( ) {
    	CadastrarCachorroApp cadastrarCachorro = new CadastrarCachorroApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			cadastrarCachorro.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleCadastrarGato( ) {
    	CadastrarGatoApp cadastrarGato = new CadastrarGatoApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			cadastrarGato.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleEditar( ) {
    	EditarCachorroApp editarCao = new EditarCachorroApp();
    	SeusAnimaisApp.getStage().close();
    	
    	try {
			editarCao.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleRemover( ) {

    }
    
    public void initTable() {
    	clmAnimais.setCellValueFactory(new PropertyValueFactory<Animal, String>("nome"));
    	tabelaAnimais.setItems(atualizaTabela());
    }
    
    public ObservableList<Animal> atualizaTabela(){
    	return FXCollections.observableArrayList(fachada.listarAnimais());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initTable();
	}
}
