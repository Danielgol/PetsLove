package petslove.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import petslove.gui.system.CaixaDeEntradaApp;
import petslove.gui.system.DadosDoDonoApp;
import petslove.gui.system.SuasSolicitacoesApp;
import petslove.sistema.negocios.beans.Usuario;

public class DadosDoDonoController implements Initializable {

	public static Usuario selecionado;

	@FXML private Label nomeDono;
	@FXML private Label emailDono;
	@FXML private Label numeroDono;

	@FXML
	void handleSair() {
		if(DadosDoDonoApp.isLocal()){
			SuasSolicitacoesApp tela = new SuasSolicitacoesApp();
			DadosDoDonoApp.getStage().close();

			try {
				tela.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(!DadosDoDonoApp.isLocal())	{
			CaixaDeEntradaApp tela = new CaixaDeEntradaApp();
			DadosDoDonoApp.getStage().close();

			try {
				tela.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void mostrarDetalhesDono(Usuario usuario) {
		if(usuario != null) {
			nomeDono.setText(usuario.getNome());
			numeroDono.setText(usuario.getNumero());
			emailDono.setText(usuario.getEmail());
		}else {
			nomeDono.setText("");
			emailDono.setText("");
			numeroDono.setText("");
		}
	}

	public static void setSelecionado(Usuario dono){
		selecionado = dono;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mostrarDetalhesDono(selecionado);
	}

}
