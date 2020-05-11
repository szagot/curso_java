package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	/**
	 * Responsável por retornar o palco atual do elemento que disparou o evento
	 * 
	 * @param event
	 * @return
	 */
	public static Stage currentStage(ActionEvent event) {

		return (Stage) ((Node) event.getSource()).getScene().getWindow();

	}

}
