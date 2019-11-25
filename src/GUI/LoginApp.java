package GUI;

import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class LoginApp extends Application {

	private static Stage stage;
	
	public static void main(String[] args) throws UsuarioJaExisteException {
		
		/*
		Usuario u = new Usuario("jerimum", "123456789", "@.com", "1");
		Usuario u2 = new Usuario("joao", "987654321", "2@.com", "1");
		Gato g = new Gato(11, 10, EnumSexo.FEMEA, "bixo", u, EnumPelagem.FELPUDO, EnumRacaGato.ABISSINIO, "chato");
		Gato g2 = new Gato(18, 2, EnumSexo.MACHO, "bixanochato", u2, EnumPelagem.RASO, EnumRacaGato.BALINES, "safasfgsgsgasdfgsadfgsdafsad");
		Cachorro c = new Cachorro(13, 9, EnumSexo.MACHO, "doguinho", u, EnumRacaCachorro.BORDERCOLLIE, EnumTamanho.ALTO, "legal");
		Cachorro c1 = new Cachorro(15, 3, EnumSexo.FEMEA, "doguinhaaaaa", u2, EnumRacaCachorro.AKITA, EnumTamanho.MEDIO, "um cachorro mt amigavel que so faz dormir e comer e cagar e encher a paciencia pq essse programa merda ta cheio de bug.");
		FachadaPL.getInstance().cadastrarUsuario(u);
		FachadaPL.getInstance().cadastrarUsuario(u2);
		FachadaPL.getInstance().cadastrarAnimal(c);
		FachadaPL.getInstance().cadastrarAnimal(g);
		FachadaPL.getInstance().cadastrarAnimal(c1);
		FachadaPL.getInstance().cadastrarAnimal(g2);
		*/
		
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View/LoginOverview.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("resources/PetsLogoImgPng.png");
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
