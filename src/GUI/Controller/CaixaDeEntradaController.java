package GUI.Controller;

import GUI.System.CaixaDeEntradaApp;
import GUI.System.DadosDoDonoApp;
import GUI.System.TelaPrincipalApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CaixaDeEntradaController {

	@FXML private TableView<?> tabelaSolicitacoes;
	@FXML private Label nomeAnimal;
	@FXML private Label statusSolicitacao;

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
		DadosDoDonoApp telaDono = new DadosDoDonoApp();
		DadosDoDonoApp.setLocal(false);
		CaixaDeEntradaApp.getStage().close();

		try {
			telaDono.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
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
	
}
