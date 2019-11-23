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
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import javafx.beans.property.SimpleStringProperty;
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
    private TableColumn<Animal, String> colunaAnimais;
    
    @FXML
    private TableColumn<Animal, String> colunaTipo;
    
    @FXML
    private Label labelNome;

    @FXML
    private Label labelSexo;

    @FXML
    private Label labelIdade;

    @FXML
    private Label labelRaca;

    @FXML
    private Label labelDescricao;
    
    @FXML
    private Label labelTituloTamPel;

    @FXML
    private Label labelPelagemTamanho;
    
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
    	colunaAnimais.setCellValueFactory(new PropertyValueFactory<Animal, String>("nome"));
    	colunaTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getTypeName()));
    	tabelaAnimais.setItems(atualizaTabela());
    }
    
    public ObservableList<Animal> atualizaTabela(){
    	return FXCollections.observableArrayList(fachada.listarAnimaisPorDono(fachada.getUsuarioLogado()));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initTable();
		
       
         
        
        tabelaAnimais.getSelectionModel().selectedItemProperty()
        .addListener(
                (observable, oldValue, newValue) -> mostrarDetalhesAnimal(newValue));
 
        
	}
	
	 private void mostrarDetalhesAnimal(Animal animal) {
	        if (animal != null) {

	        	// preenche os labels com os dados da conta
	        	labelNome.setText(animal.getNome());
	        	labelSexo.setText(animal.getSexo().sexo);
	        	labelIdade.setText("11");
	        	labelDescricao.setText(animal.getDescricao());
	        	if(animal instanceof Gato)
	        	{
	        		labelTituloTamPel.setText("Pelagem:");
	        		labelRaca.setText(((Gato) animal).getRaca().valor);
	        		labelPelagemTamanho.setText(((Gato) animal).getPelagem().pelagem);
	        	}
	        	if(animal instanceof Cachorro)
	        	{
	        		labelTituloTamPel.setText("Tamanho:");
	        		labelRaca.setText(((Cachorro) animal).getRaca().valor);
	        		labelPelagemTamanho.setText(((Cachorro) animal).getTamanho().tamanho);
	        	}
	        	
	        	

	        } else {
	        	
	        	// conta nula
	        	labelNome.setText("");
	        	labelSexo.setText("");
	        	labelIdade.setText("");
	        	labelDescricao.setText("");
	        	labelRaca.setText("");
	        	labelPelagemTamanho.setText("");
	        }
	    }
	    
}
