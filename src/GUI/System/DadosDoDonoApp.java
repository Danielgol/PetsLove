package GUI.System;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DadosDoDonoApp extends Application {

private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../View/DadosDoDono.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("resources/PetsLogoImgPng.png");
		stage.getIcons().add(image);
		stage.setTitle("Dados do Dono");
		stage.setScene(scene);
		stage.show();
		setStage(stage);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		DadosDoDonoApp.stage = stage;
	
	}
}
