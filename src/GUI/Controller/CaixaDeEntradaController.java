package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GUI.System.CaixaDeEntradaApp;
import GUI.System.DadosDoDonoApp;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CaixaDeEntradaController implements Initializable {

	@FXML private TableView<Solicitacao> tabelaSolicitacoes;
    @FXML private TableColumn<Solicitacao, String> colunaSolicitacoes;
    @FXML private TableColumn<Solicitacao, String> colunaStatus;
    @FXML private Label labelNome;
    @FXML private Label labelSexo;
    @FXML private Label labelIdade;
    @FXML private Label labelRaca;
    @FXML private Label labelDescricao;
    @FXML private Label labelTituloTamPel;
    @FXML private Label labelPelagemTamanho;

    @FXML
    void handleApagarSolicitacao( ) throws SolicitacaoNaoExisteException {
    	Solicitacao selecionada = tabelaSolicitacoes.getSelectionModel().getSelectedItem();
    	FachadaPL.getInstance().removerSolicitacao(selecionada);
    	initTable();
    }
    
	@FXML
	void handleVoltar() {
		TelaPrincipalApp telaPrinc = new TelaPrincipalApp();
		CaixaDeEntradaApp.getStage().close();

		try {
			telaPrinc.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void handleDadosDoDono() {
		Solicitacao selecionada = tabelaSolicitacoes.getSelectionModel().getSelectedItem();
		if(selecionada.getStatus().equals("Aceito")){
			DadosDoDonoController.setSelecionado(FachadaPL.getInstance().procurarUsuario(selecionada.getRemetente().getEmailDono()));
			DadosDoDonoApp telaDono = new DadosDoDonoApp();
			DadosDoDonoApp.setLocal(false);
			CaixaDeEntradaApp.getStage().close();

			try {
				telaDono.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void handleAceitar() {
		//TODO: Aceitar Solicitacao
	}

	@FXML
	void handleRecusar() {
		//TODO: Recusar Solicitacao
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
				labelPelagemTamanho.setText(((Gato) animal).getPelagem().valor);
			}else if(animal instanceof Cachorro){
				labelTituloTamPel.setText("Tamanho:");
				labelRaca.setText(((Cachorro) animal).getRaca().valor);
				labelPelagemTamanho.setText(((Cachorro) animal).getTamanho().valor);
			}
		} else {
			labelNome.setText("");
			labelSexo.setText("");
			labelIdade.setText("");
			labelDescricao.setText("");
			labelRaca.setText("");
			labelPelagemTamanho.setText("");
		}
	}

	public void initTable() {
		colunaSolicitacoes.setCellValueFactory(new PropertyValueFactory<Solicitacao, String>("nome"));
		colunaStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));
		tabelaSolicitacoes.setItems(atualizaTabela());
	}

	public ObservableList<Solicitacao> atualizaTabela(){
		return FXCollections.observableArrayList(FachadaPL.getInstance().listarSolicitacoesRecebidas(FachadaPL.getUsuarioLogado()));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
		tabelaSolicitacoes.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> mostrarDetalhesAnimal(newValue.getRemetente()));
	}
	
}
