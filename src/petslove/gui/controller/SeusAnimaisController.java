package petslove.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import petslove.gui.system.CadastrarCachorroApp;
import petslove.gui.system.CadastrarGatoApp;
import petslove.gui.system.EditarCachorroApp;
import petslove.gui.system.EditarGatoApp;
import petslove.gui.system.SeusAnimaisApp;
import petslove.gui.system.TelaPrincipalApp;
import petslove.sistema.FachadaPL;
import petslove.sistema.negocios.beans.Animal;
import petslove.sistema.negocios.beans.Cachorro;
import petslove.sistema.negocios.beans.Gato;

public class SeusAnimaisController implements Initializable {

	@FXML private Label labelNome;
	@FXML private Label labelSexo;
	@FXML private Label labelIdade;
	@FXML private Label labelRaca;
	@FXML private Label labelDescricao;
	@FXML private Label labelTituloTamPel;
	@FXML private Label labelPelagemPorte;
	@FXML private TableView<Animal> tabelaAnimais;
	@FXML private TableColumn<Animal, String> colunaAnimais;
	@FXML private TableColumn<Animal, String> colunaTipo;

	@FXML
	void handleCadastrarCachorro() {
		CadastrarCachorroApp cadastrarCachorro = new CadastrarCachorroApp();
		SeusAnimaisApp.getStage().close();

		try {
			cadastrarCachorro.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleCadastrarGato() {
		CadastrarGatoApp cadastrarGato = new CadastrarGatoApp();
		SeusAnimaisApp.getStage().close();

		try {
			cadastrarGato.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleEditar() {
		Animal animalSelecionado = tabelaAnimais.getSelectionModel().getSelectedItem();
		if(animalSelecionado instanceof Gato){
			EditarGatoController.setSelecionado(animalSelecionado);
			EditarGatoApp editarGato = new EditarGatoApp();
			SeusAnimaisApp.getStage().close();

			try {
				editarGato.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(animalSelecionado instanceof Cachorro){
			EditarCachorroController.setSelecionado(animalSelecionado);
			EditarCachorroApp editarCao = new EditarCachorroApp();
			SeusAnimaisApp.getStage().close();

			try {
				editarCao.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhum animal foi selecionado");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione um animal para editar");
			alerta.show();
		}
	}

	@FXML
	void handleRemover() {
		Animal animalSelecionado = tabelaAnimais.getSelectionModel().getSelectedItem();
		if(animalSelecionado != null) {
			FachadaPL.getInstance().removerAnimal(animalSelecionado);
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhum animal foi selecionado");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione um animal para remover");
			alerta.show();
		}
		initTable();
	}
	
	@FXML
	void handleVoltar() {
		TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
		SeusAnimaisApp.getStage().close();

		try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarDetalhesAnimal(Animal animal) {
		if (animal != null) {
			labelNome.setText(animal.getNome());
			labelSexo.setText(animal.getSexo().valor);
			labelIdade.setText(Integer.toString(animal.getIdade()));
			labelDescricao.setText(animal.getDescricao());
			if(animal instanceof Gato){
				labelTituloTamPel.setText("Pelagem:");
				labelRaca.setText(((Gato) animal).getRaca().valor);
				labelPelagemPorte.setText(((Gato) animal).getPelagem().valor);
			}else if(animal instanceof Cachorro){
				labelTituloTamPel.setText("Porte:");
				labelRaca.setText(((Cachorro) animal).getRaca().valor);
				labelPelagemPorte.setText(((Cachorro) animal).getPorte().valor);
			}
		} else {
			labelNome.setText("");
			labelSexo.setText("");
			labelIdade.setText("");
			labelDescricao.setText("");
			labelRaca.setText("");
			labelPelagemPorte.setText("");
		}
	}

	public void initTable() {
		colunaAnimais.setCellValueFactory(new PropertyValueFactory<Animal, String>("nome"));
		colunaTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
		tabelaAnimais.setItems(atualizaTabela());
	}

	public ObservableList<Animal> atualizaTabela(){
		return FXCollections.observableArrayList(FachadaPL.getInstance().listarAnimaisPorDono(FachadaPL.getUsuarioLogado()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initTable();
		tabelaAnimais.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> mostrarDetalhesAnimal(newValue));
	}

}
