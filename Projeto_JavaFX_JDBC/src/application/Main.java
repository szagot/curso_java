package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	public static final Image APP_ICON = new Image("/gui/icon.jpg");

	// Cena (tela) principal
	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) {
		try {

			// Cria a instancia da minha View principal
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

			// Instancia o painel com scroll (j� desenhado no builder scene como principal)
			ScrollPane scrollPane = loader.load();

			// Ajusta os elementos filhos para acompanharem largura e altura da tela
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			// Define a cena principal
			mainScene = new Scene(scrollPane);

			// Seta a cena
			primaryStage.setScene(mainScene);
			// Deine o t�tulo
			primaryStage.setTitle("Projeto JavaFX com JDBC");
			// Define um �cone do projeto
			primaryStage.getIcons().add(APP_ICON);

			// Executa
			primaryStage.show();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	/**
	 * Pega a cena principal
	 * 
	 * @return
	 */
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
