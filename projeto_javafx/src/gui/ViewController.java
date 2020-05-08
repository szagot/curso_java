package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;
	@FXML
	private Label lblResult;
	@FXML
	private Button btSum;

	@FXML
	public void onBtSumAction() {

		try {

			// Pega os textos das caixas
			double number1 = Double.parseDouble(txtNumber1.getText().replace(',', '.'));
			double number2 = Double.parseDouble(txtNumber2.getText().replace(',', '.'));
			double sum = number1 + number2;

			// Mostra o resultado na label de resultado
			lblResult.setText(String.format("%.2f", sum));

		} catch (NumberFormatException e) {

			Alerts.showAlert("Erro!", "Digite apenas números válidos", e.getMessage(), AlertType.ERROR);

		}

	}

	/**
	 * Executa quando o controlador for criado
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Marca os campos do tipo double
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		
		// Coloca um limite de caracteres
		Constraints.setTextFieldMaxLength(txtNumber1, 10);
		Constraints.setTextFieldMaxLength(txtNumber2, 10);

	}

}
