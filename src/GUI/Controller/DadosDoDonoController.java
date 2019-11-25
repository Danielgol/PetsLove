package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.System.CaixaDeEntradaApp;
import GUI.System.DadosDoDonoApp;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DadosDoDonoController implements Initializable {

	public static Usuario selecionado;

	@FXML private Label nomeDono;
	@FXML private Label numeroDono;
	@FXML private Label emailDono;

	@FXML
	void handleSair() {
		CaixaDeEntradaApp tela = new CaixaDeEntradaApp();
		DadosDoDonoApp.getStage().close();

		try {
			tela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setSelecionado(Usuario dono){
		selecionado = dono;
	}
	
	private void mostrarDetalhesDono(Usuario usuario) {
		if (usuario != null) {
			nomeDono.setText(usuario.getNome());
			numeroDono.setText(usuario.getNumero());
			emailDono.setText(usuario.getEmail());

		}
		else {
			nomeDono.setText("");
			emailDono.setText("");
			numeroDono.setText("");

		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mostrarDetalhesDono(selecionado);

	}

}
