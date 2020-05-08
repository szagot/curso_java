package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ViewController {

	@FXML
	private Button btTest;

	@FXML
	public void onBtTestAction() {

		// Mostra caixa de alerta
		Alerts.showAlert("Que coisa!", null, "Você clicou mesmo, hein?!", AlertType.INFORMATION);

	}

}
