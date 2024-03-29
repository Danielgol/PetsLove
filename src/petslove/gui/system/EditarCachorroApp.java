package petslove.gui.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EditarCachorroApp extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../view/EditarCachorro.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("petslove/gui/resources/PetsLogoImgPng.png");
		stage.getIcons().add(image);
		stage.setTitle("Edi��o de dados de gato");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		setStage(stage);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		EditarCachorroApp.stage = stage;
	}
	
}
