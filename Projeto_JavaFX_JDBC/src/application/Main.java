package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			// Cria a instancia da minha View principal
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

			// Instancia o painel com scroll (já desenhado no builder scene como principal)
			ScrollPane scrollPane = loader.load();

			// Ajusta os elementos filhos para acompanharem largura e altura da tela
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			// Define a cena principal
			Scene mainScene = new Scene(scrollPane);

			// Seta a cena
			primaryStage.setScene(mainScene);
			// Deine o título
			primaryStage.setTitle("Projeto JavaFX com JDBC");
			// Define um ícone do projeto
			primaryStage.getIcons().add(new Image("/gui/icon.jpg"));

			// Executa
			primaryStage.show();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
