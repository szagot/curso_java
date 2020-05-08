package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			// Cria a instancia da minha View principal
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent);
			// Seta a cena
			primaryStage.setScene(mainScene);
			// Deine o título
			primaryStage.setTitle("Projeto JavaFX com JDBC");
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
