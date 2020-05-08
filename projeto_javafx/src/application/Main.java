package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {

			// Pega a viu criada no Scene Builder
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));

			// Define como cena inicial
			Scene scene = new Scene(parent);
			stage.setScene(scene);

			// Inicia a cena
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
