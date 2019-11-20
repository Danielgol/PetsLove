package GUI;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

import GUI.Controller.CadastroUsuarioController;
import PetsLove.sistema.negocios.beans.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

    private static Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PetsLove");

        initRootLayout();

        abrirLoginOverview();
    }
    
    /**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o person overview dentro do root layout.
     */
    public  void abrirLoginOverview() {
        try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/LoginOverView.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();
            
            // Define o person overview dentro do root layout.
            rootLayout.setCenter(loginOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void abrirCadastro() {
    	 try {
    	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
    	        FXMLLoader loader = new FXMLLoader();
    	        loader.setLocation(MainApp.class.getResource("View/Cadastro.fxml"));
    	        AnchorPane page = (AnchorPane) loader.load();

    	        // Cria o palco dialogStage.
    	        Stage dialogStage = new Stage();
    	        dialogStage.setTitle("Cadastrar");
    	        dialogStage.initModality(Modality.WINDOW_MODAL);
    	        dialogStage.initOwner(primaryStage);
    	        Scene scene = new Scene(page);
    	        dialogStage.setScene(scene);

    	        // Mostra a janela e espera at� o usu�rio fechar.
    	        dialogStage.showAndWait();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }
    
    public static void abrirTelaPrincipal()
    {
    	 try {
 	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(MainApp.class.getResource("View/TelaPrincipal.fxml"));
 	        AnchorPane page = (AnchorPane) loader.load();

 	        // Cria o palco dialogStage.
 	        Stage dialogStage = new Stage();
 	        dialogStage.setTitle("Tela Principal");
 	        dialogStage.initModality(Modality.WINDOW_MODAL);
 	        dialogStage.initOwner(primaryStage);
 	        Scene scene = new Scene(page);
 	        dialogStage.setScene(scene);

 	        // Mostra a janela e espera at� o usu�rio fechar.
 	        dialogStage.showAndWait();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
    }
    
    public static void abrirSeusAnimais()
    {
    	try {
 	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(MainApp.class.getResource("View/SeusAnimais.fxml"));
 	        AnchorPane page = (AnchorPane) loader.load();

 	        // Cria o palco dialogStage.
 	        Stage dialogStage = new Stage();
 	        dialogStage.setTitle("Seus Animais");
 	        dialogStage.initModality(Modality.WINDOW_MODAL);
 	        dialogStage.initOwner(primaryStage);
 	        Scene scene = new Scene(page);
 	        dialogStage.setScene(scene);

 	        // Mostra a janela e espera at� o usu�rio fechar.
 	        dialogStage.showAndWait();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
    }
    
    public static void abrirCaixaDeEntrada()
    {
    	try {
 	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(MainApp.class.getResource("View/CaixaDeEntrada.fxml"));
 	        AnchorPane page = (AnchorPane) loader.load();

 	        // Cria o palco dialogStage.
 	        Stage dialogStage = new Stage();
 	        dialogStage.setTitle("Caixa de Entrada");
 	        dialogStage.initModality(Modality.WINDOW_MODAL);
 	        dialogStage.initOwner(primaryStage);
 	        Scene scene = new Scene(page);
 	        dialogStage.setScene(scene);

 	        // Mostra a janela e espera at� o usu�rio fechar.
 	        dialogStage.showAndWait();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
    }
    
    public static void abrirSuasSolicitacoes()
    {
    	try {
 	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(MainApp.class.getResource("View/SuasSolicitacoes.fxml"));
 	        AnchorPane page = (AnchorPane) loader.load();

 	        // Cria o palco dialogStage.
 	        Stage dialogStage = new Stage();
 	        dialogStage.setTitle("Suas Solicita��es");
 	        dialogStage.initModality(Modality.WINDOW_MODAL);
 	        dialogStage.initOwner(primaryStage);
 	        Scene scene = new Scene(page);
 	        dialogStage.setScene(scene);

 	        // Mostra a janela e espera at� o usu�rio fechar.
 	        dialogStage.showAndWait();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
    }
    
    public static void abrirPerfilUsuario()
    {
    	try {
 	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(MainApp.class.getResource("View/PerfilUsuario.fxml"));
 	        AnchorPane page = (AnchorPane) loader.load();

 	        // Cria o palco dialogStage.
 	        Stage dialogStage = new Stage();
 	        dialogStage.setTitle("Perfil do Usu�rio");
 	        dialogStage.initModality(Modality.WINDOW_MODAL);
 	        dialogStage.initOwner(primaryStage);
 	        Scene scene = new Scene(page);
 	        dialogStage.setScene(scene);

 	        // Mostra a janela e espera at� o usu�rio fechar.
 	        dialogStage.showAndWait();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
    }
    
    public static void abrirAlterarSenha()
    {
    	try {
 	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(MainApp.class.getResource("View/AlterarSenha.fxml"));
 	        AnchorPane page = (AnchorPane) loader.load();

 	        // Cria o palco dialogStage.
 	        Stage dialogStage = new Stage();
 	        dialogStage.setTitle("Alterar Senha");
 	        dialogStage.initModality(Modality.WINDOW_MODAL);
 	        dialogStage.initOwner(primaryStage);
 	        Scene scene = new Scene(page);
 	        dialogStage.setScene(scene);

 	        // Mostra a janela e espera at� o usu�rio fechar.
 	        dialogStage.showAndWait();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
    }
  
}
