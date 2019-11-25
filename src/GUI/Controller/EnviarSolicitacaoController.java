package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.System.EnviarSolicitacaoApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.SolicitacaoJaExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Solicitacao;
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

	private static Animal destinatario;

	@FXML private TableView<Animal> tabelaAnimais;
	@FXML private TableColumn<Animal, String> colunaAnimais;
	@FXML private TableColumn<Animal, String> colunaTipo;

	@FXML
	void handleCancelar( ) {
		destinatario = null;
		TelaPrincipalApp tela = new TelaPrincipalApp();
		EnviarSolicitacaoApp.getStage().close();

		try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleConfirmar() throws SolicitacaoJaExisteException {
		Animal remetente = tabelaAnimais.getSelectionModel().getSelectedItem();
		Solicitacao solicitacao = new Solicitacao(remetente, destinatario);
		FachadaPL.getInstance().criarSolicitacao(solicitacao);
		
		TelaPrincipalApp tela = new TelaPrincipalApp();
		EnviarSolicitacaoApp.getStage().close();

		try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initTable() {
		colunaAnimais.setCellValueFactory(new PropertyValueFactory<Animal, String>("nome"));
		colunaTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
		tabelaAnimais.setItems(atualizaTabela());
	}

	public ObservableList<Animal> atualizaTabela(){
		return FXCollections.observableArrayList(FachadaPL.getInstance()
				.listarAnimaisCompativeisPorDono(destinatario, FachadaPL.getUsuarioLogado()));
	}

	public static void setDestinatario(Animal animal) {
		if(!FachadaPL.getUsuarioLogado().equals(FachadaPL.getInstance().procurarUsuario(animal.getEmailDono()))) {
			destinatario = animal;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
	}

}
