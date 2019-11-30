package petslove.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import petslove.sistema.exceptions.UsuarioJaExisteException;
import javafx.scene.image.Image;

public class LoginApp extends Application {

	private static Stage stage;
	
	public static void main(String[] args) throws UsuarioJaExisteException {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("view/LoginOverview.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("petslove/gui/resources/PetsLogoImgPng.png");
		stage.getIcons().add(image);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		setStage(stage);	
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		LoginApp.stage = stage;
	}
	
}
