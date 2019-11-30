package petslove.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import petslove.gui.system.AlterarSenhaApp;
import petslove.gui.system.PerfilUsuarioApp;
import petslove.sistema.FachadaPL;
import petslove.sistema.exceptions.UsuarioNaoExisteException;

public class AlterarSenhaController {

	@FXML private PasswordField pfSenhaAtual;
	@FXML private PasswordField pfNovaSenha1;
	@FXML private PasswordField pfNovaSenha2;

	@FXML
	void handleCancelar() {
		PerfilUsuarioApp perfilTela = new PerfilUsuarioApp();
		AlterarSenhaApp.getStage().close();

		try {
			perfilTela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleSalvar( ) throws UsuarioNaoExisteException {
		if(pfSenhaAtual.getText().equals(FachadaPL.getUsuarioLogado().getSenha())){
			if(pfNovaSenha1.getText().equals("") || pfNovaSenha2.getText().equals("")) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Senha nula");
				alerta.setTitle("Erro");
				alerta.setContentText("Senha nula, digite a nova senha novamente");
				alerta.show();
			}
			else if(pfNovaSenha1.getText().equals(pfNovaSenha2.getText())) {
				FachadaPL.getUsuarioLogado().setSenha(pfNovaSenha1.getText());
				FachadaPL.getInstance().atualizarUsuario(FachadaPL.getUsuarioLogado());
				
				Alert alerta = new Alert(AlertType.INFORMATION);
				alerta.setHeaderText("Senha atualizada");
				alerta.setTitle("Confirmada");
				alerta.setContentText("Sua senha foi atualizada com sucesso!!");
				alerta.showAndWait();

				PerfilUsuarioApp perfilTela = new PerfilUsuarioApp();
				AlterarSenhaApp.getStage().close();

				try {
					perfilTela.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Senhas incompatíveis");
				alerta.setTitle("Erro");
				alerta.setContentText("Senhas incompatíveis, digite a nova senha novamente");
				alerta.show();
			}
		}else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Senha atual incorreta");
			alerta.setTitle("Erro");
			alerta.setContentText("Senha incorreta, digite novamente");
			alerta.show();
		}
	}

}
