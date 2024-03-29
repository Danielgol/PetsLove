package petslove.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import petslove.gui.system.EnviarSolicitacaoApp;
import petslove.gui.system.TelaPrincipalApp;
import petslove.sistema.FachadaPL;
import petslove.sistema.exceptions.SolicitacaoJaExisteException;
import petslove.sistema.negocios.beans.Animal;
import petslove.sistema.negocios.beans.Solicitacao;

public class EnviarSolicitacaoController implements Initializable{

	private static Animal destinatario;

	@FXML private TableView<Animal> tabelaAnimais;
	@FXML private TableColumn<Animal, String> colunaAnimais;
	@FXML private TableColumn<Animal, String> colunaTipo;

	@FXML
	void handleCancelar() {
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
	void handleConfirmar(){
		Animal remetente = tabelaAnimais.getSelectionModel().getSelectedItem();
		if(remetente != null) {
			Solicitacao solicitacao = new Solicitacao(remetente.getId(), destinatario.getId(), remetente.getEmailDono(), destinatario.getEmailDono());
			try {
				FachadaPL.getInstance().criarSolicitacao(solicitacao);
				TelaPrincipalApp tela = new TelaPrincipalApp();
				EnviarSolicitacaoApp.getStage().close();
				try {
					tela.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}catch(SolicitacaoJaExisteException e) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Solicita��o j� existente");
				alerta.setTitle("Erro");
				alerta.setContentText("Voc� j� tem uma solicita��o para este animal");
				alerta.show();
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhum animal selecionado");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione animal desejado");
			alerta.show();
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
