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
import javafx.stage.Stage;
import petslove.gui.system.CaixaDeEntradaApp;
import petslove.gui.system.DadosDoDonoApp;
import petslove.gui.system.TelaPrincipalApp;
import petslove.sistema.FachadaPL;
import petslove.sistema.exceptions.SolicitacaoNaoExisteException;
import petslove.sistema.negocios.beans.Animal;
import petslove.sistema.negocios.beans.Cachorro;
import petslove.sistema.negocios.beans.Gato;
import petslove.sistema.negocios.beans.Solicitacao;

public class CaixaDeEntradaController implements Initializable {

	@FXML private Label labelNome;
    @FXML private Label labelSexo;
    @FXML private Label labelIdade;
    @FXML private Label labelRaca;
    @FXML private Label labelDescricao;
    @FXML private Label labelTituloTamPel;
    @FXML private Label labelPelagemPorte;
	@FXML private TableView<Solicitacao> tabelaSolicitacoes;
    @FXML private TableColumn<Solicitacao, String> colunaSolicitacoes;
    @FXML private TableColumn<Solicitacao, String> colunaStatus;
    
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
		if(selecionada != null) {
			if(selecionada.getStatus().equals(Solicitacao.ACEITO)){
				DadosDoDonoController.setSelecionado(FachadaPL.getInstance().procurarUsuario(selecionada.getEmailDonoRemetente()));
				DadosDoDonoApp telaDono = new DadosDoDonoApp();
				DadosDoDonoApp.setLocal(false);
				CaixaDeEntradaApp.getStage().close();

				try {
					telaDono.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Solicita��o em analise");
				alerta.setTitle("Erro");
				alerta.setContentText("Enquanto a solicita��o estiver em analise voc� n�o poder� ver os dados do dono");
				alerta.show();
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhuma solicita��o selecionada");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione uma solicita��o");
			alerta.show();	
		}
	}

	@FXML
	void handleAceitar() throws SolicitacaoNaoExisteException {
		Solicitacao selecionada = tabelaSolicitacoes.getSelectionModel().getSelectedItem();
		if(selecionada != null) {
			if(selecionada.getStatus().equals(Solicitacao.ANALISANDO)){
				FachadaPL.getInstance().aceitarSolicitacao(selecionada);
			}else if(selecionada.getStatus().equals(Solicitacao.ACEITO)){
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Erro ao aceitar");
				alerta.setTitle("Erro");
				alerta.setContentText("Esta solicita��o j� foi aceita");
				alerta.show();	
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhuma solicita��o selecionada");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione uma solicita��o");
			alerta.show();	
		}
		tabelaSolicitacoes.refresh();
		initTable();
	}

	@FXML
	void handleRecusar() throws SolicitacaoNaoExisteException {
		Solicitacao selecionada = tabelaSolicitacoes.getSelectionModel().getSelectedItem();
		if(selecionada != null) {
			if(selecionada.getStatus().equals(Solicitacao.ANALISANDO)){
				FachadaPL.getInstance().recusarSolicitacao(selecionada);
			}else if(selecionada.getStatus().equals(Solicitacao.ACEITO)){
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Erro ao recusar");
				alerta.setTitle("Erro");
				alerta.setContentText("Esta solicita��o j� foi aceita");
				alerta.show();	
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Nenhuma solicita��o selecionada");
			alerta.setTitle("Erro");
			alerta.setContentText("Selecione uma solicita��o");
			alerta.show();	
		}
		initTable();
	}

	private void mostrarDetalhesAnimal(Solicitacao solicitacao) {
		if (solicitacao != null) {
			Animal animal = FachadaPL.getInstance().procurarAnimal(solicitacao.getIdRemetente());
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
		new SimpleStringProperty(FachadaPL.getInstance().procurarAnimal(cellData.getValue().getIdDestinatario()).getNome()));
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
		.addListener((observable, oldValue, newValue) -> mostrarDetalhesAnimal(newValue));
	}
	
}
