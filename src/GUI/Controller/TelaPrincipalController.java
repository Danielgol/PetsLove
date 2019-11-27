package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.LoginApp;
import GUI.System.CaixaDeEntradaApp;
import GUI.System.EnviarSolicitacaoApp;
import GUI.System.PerfilUsuarioApp;
import GUI.System.SeusAnimaisApp;
import GUI.System.SuasSolicitacoesApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable{

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
	private void handleSeusAnimais() {
		SeusAnimaisApp seusAn = new SeusAnimaisApp();
		TelaPrincipalApp.getStage().close();

		try {
			seusAn.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleCaixaDeEntrada() {
		CaixaDeEntradaApp caixaEnt = new CaixaDeEntradaApp();
		TelaPrincipalApp.getStage().close();

		try {
			caixaEnt.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleSuasSolicitacoes() {
		SuasSolicitacoesApp suasSol = new SuasSolicitacoesApp();
		TelaPrincipalApp.getStage().close();

		try {
			suasSol.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handlePerfil() {
		PerfilUsuarioApp perfil = new PerfilUsuarioApp();
		TelaPrincipalApp.getStage().close();

		try {
			perfil.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleEnviarSolicitacao(ActionEvent event) {
		EnviarSolicitacaoApp enviarSolicitacao = new EnviarSolicitacaoApp();
		Animal animalSelecionado = tabelaAnimais.getSelectionModel().getSelectedItem();
		if(animalSelecionado != null) {
			if(FachadaPL.getUsuarioLogado().equals(FachadaPL.getInstance().procurarUsuario(animalSelecionado.getEmailDono()))){
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Seleção inválida");
				alerta.setTitle("Erro");
				alerta.setContentText("Este animal lhe pertence");
				alerta.show();
			}else {
				EnviarSolicitacaoController.setDestinatario(animalSelecionado);
				TelaPrincipalApp.getStage().close();
				try {
					enviarSolicitacao.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhum animal selecionado");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione o animal desejado");
			alerta.show();
		}
	}

	@FXML
	private void handleSair(ActionEvent ae) {
		FachadaPL.getInstance();
		FachadaPL.logout();
		LoginApp login = new LoginApp();
		TelaPrincipalApp.getStage().close();

		try {
			login.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarDetalhesAnimal(Animal animal) {
		if(animal != null) {
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
		}else {
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
		return FXCollections.observableArrayList(FachadaPL.getInstance().listarAnimais());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
		tabelaAnimais.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> mostrarDetalhesAnimal(newValue));
	}

}
