package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.System.DadosDoDonoApp;
import GUI.System.SuasSolicitacoesApp;
import GUI.System.TelaPrincipalApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.SolicitacaoNaoExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Solicitacao;
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
import javafx.stage.Stage;

public class SuasSolicitacoesController implements Initializable {

	@FXML private Label labelNome;
	@FXML private Label labelSexo;
	@FXML private Label labelIdade;
	@FXML private Label labelRaca;
	@FXML private Label labelDescricao;
	@FXML private Label labelTituloTamPel;
	@FXML private Label labelPelagemPorte;
	@FXML private TableView<Solicitacao> tabelaSolicitacoes;
	@FXML private TableColumn<Solicitacao, String> colunaStatus;
	@FXML private TableColumn<Solicitacao, String> colunaSolicitacoes;
	
	@FXML
	void handleApagarSolicitacao() throws SolicitacaoNaoExisteException {
		Solicitacao selecionada = tabelaSolicitacoes.getSelectionModel().getSelectedItem();
		if(selecionada != null) {
			FachadaPL.getInstance().removerSolicitacao(selecionada);
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhuma solicitação selecionada");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione a solicitação desejada");
			alerta.show();
		}
		initTable();
	}

	@FXML
	void handleVoltar() {
		TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
		SuasSolicitacoesApp.getStage().close();

		try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleDadosDoDono() {
		Solicitacao selecionada = tabelaSolicitacoes.getSelectionModel().getSelectedItem();
		if(selecionada != null) {
			if(selecionada.getStatus().equals(Solicitacao.ACEITO)){
				DadosDoDonoController.setSelecionado(FachadaPL.getInstance()
				.procurarUsuario(selecionada.getEmailDonoDestinatario()));
				DadosDoDonoApp telaDono = new DadosDoDonoApp();
				DadosDoDonoApp.setLocal(true);
				SuasSolicitacoesApp.getStage().close();
				
				try {
					telaDono.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(selecionada.getStatus().equals(Solicitacao.ANALISANDO)){
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Solicitação em analise");
				alerta.setTitle("Erro");
				alerta.setContentText("Enquanto a solicitação estiver em analise você não poderá ver os dados do dono");
				alerta.show();
			}else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Solicitação recusada");
				alerta.setTitle("Erro");
				alerta.setContentText("Você não pode ver os dados do dono, pois sua solicitação foi recusada");
				alerta.show();
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhuma solicitação selecionada");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione a solicitação desejada");
			alerta.show();
			
		}
	}

	private void mostrarDetalhesAnimal(Solicitacao solicitacao) {
		if (solicitacao != null) {
			Animal animal = FachadaPL.getInstance().procurarAnimal(solicitacao.getIdDestinatario());
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
		colunaSolicitacoes.setCellValueFactory(cellData ->
		new SimpleStringProperty(FachadaPL.getInstance().procurarAnimal(cellData.getValue().getIdRemetente()).getNome()));
		colunaStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));
		tabelaSolicitacoes.setItems(atualizaTabela());
	}

	public ObservableList<Solicitacao> atualizaTabela(){
		return FXCollections.observableArrayList(FachadaPL.getInstance().listarSolicitacoesEnviadas(FachadaPL.getUsuarioLogado()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
		tabelaSolicitacoes.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> mostrarDetalhesAnimal(newValue));
	}

}
