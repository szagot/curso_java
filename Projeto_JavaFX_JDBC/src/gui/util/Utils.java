package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	/**
	 * Respons�vel por retornar o palco atual do elemento que disparou o evento
	 * 
	 * @param event
	 * @return
	 */
	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}

	/**
	 * Retorna o integer de dentro de um string. Se n�o for um inteiro v�lido,
	 * retorna nulo
	 * 
	 * @param str
	 * @return
	 */
	public static Integer tryParseToInt(String str) {
		try {
			Integer number = Integer.parseInt(str);
			if (number == 0) {
				return null;
			} else {
				return number;
			}
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
