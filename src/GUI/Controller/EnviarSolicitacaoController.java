package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
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

	private static Animal selecionado;

	@FXML private TableView<Animal> tabelaAnimais;
	@FXML private TableColumn<Animal, String> colunaAnimais;
	@FXML private TableColumn<Animal, String> colunaTipo;

	@FXML
	void handleCancelar( ) {
		selecionado = null;
		TelaPrincipalApp tela = new TelaPrincipalApp();
		EnviarSolicitacaoApp.getStage().close();

		try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleConfirmar() {

		/*TODO: Fazer funcionar o enviar solicitação
		 *Lembrar de:
		 *1. Animal selecionado na Tela principal será o destinatario
		 *2. A tabela de animais na tela de enviar solicitação deverá conter animais da pessoa que quer enviar a solicitação, do mesmo tipo
		 *										que o animal que foi solicitado e de sexo oposto. 
		 *										Ex: solicitei um gato femea, na tela de enviar solicitação só pode aparecer gatos machos da pessoa
		 *3.Pensar se é necessário o animal ser da mesma raça.
		 */

	}

	public void initTable() {
		colunaAnimais.setCellValueFactory(new PropertyValueFactory<Animal, String>("nome"));
		colunaTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
		tabelaAnimais.setItems(atualizaTabela());
	}

	public ObservableList<Animal> atualizaTabela(){
		return FXCollections.observableArrayList(FachadaPL.getInstance().listarAnimaisCompativeis(selecionado));
	}

	public static void setSelecionado(Animal animal) {
		if(!FachadaPL.getUsuarioLogado().equals(animal.getDono())) {
			selecionado = animal;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
	}

}
