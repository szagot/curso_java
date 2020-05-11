package gui.util;

import java.util.Optional;

import application.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Alerts {

	/**
	 * Mostra alertas no sistema
	 * 
	 * @param title
	 * @param header
	 * @param content
	 * @param type
	 */
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		// Adiciona ícone a caixa de alerta
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(Main.APP_ICON);

		alert.show();
	}

	/**
	 * Mostra um alerta com botões opcionais de confirmação
	 * 
	 * @param title
	 * @param content
	 * @return
	 */
	public static Optional<ButtonType> showConfirmation(String title, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		// Adiciona ícone a caixa de alerta
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(Main.APP_ICON);

		return alert.showAndWait();
	}
}
