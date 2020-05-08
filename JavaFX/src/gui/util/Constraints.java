package gui.util;

import javafx.scene.control.TextField;

/**
 * Classe auxiliar para limitações dos campos
 */
public class Constraints {
	/**
	 * Controla inputs para inteiros
	 * 
	 * @param txt
	 */
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			// Apenas dígitos?
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}

			// Campo vazio?
			if (newValue.isEmpty()) {
				txt.setText("0");
			}
		});
	}

	/**
	 * Controle inputs de tamanho limitado
	 * 
	 * @param txt
	 * @param max
	 */
	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	/**
	 * Controla inputs para Double
	 * 
	 * @param txt
	 */
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.,]\\d*)?")) {
				txt.setText(oldValue);
			}

			// Campo vazio?
			if (newValue.isEmpty()) {
				txt.setText("0");
			}
		});
	}
}
