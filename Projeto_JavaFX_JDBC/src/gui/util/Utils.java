package gui.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
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

	/**
	 * Retorna o integer de dentro de um string. Se não for um inteiro válido,
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

	/**
	 * Formata campos de data
	 * 
	 * @param <T>
	 * @param tableColumn
	 * @param format
	 */
	public static <T> void formatTableColumnDate(TableColumn<T, Date> tableColumn, String format) {
		tableColumn.setCellFactory(column -> {
			TableCell<T, Date> cell = new TableCell<T, Date>() {
				private SimpleDateFormat sdf = new SimpleDateFormat(format);

				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (empty) {
						setText(null);
					} else {
						setText(sdf.format(item));
					}
				}
			};
			return cell;
		});
	}

	/**
	 * Formata campos de ponto flutuante
	 * 
	 * @param <T>
	 * @param tableColumn
	 * @param decimalPlaces
	 */
	public static <T> void formatTableColumnDouble(TableColumn<T, Double> tableColumn, int decimalPlaces) {
		tableColumn.setCellFactory(column -> {
			TableCell<T, Double> cell = new TableCell<T, Double>() {
				@Override
				protected void updateItem(Double item, boolean empty) {
					super.updateItem(item, empty);
					if (empty) {
						setText(null);
					} else {
						Locale.setDefault(Locale.US);
						setText(String.format("%." + decimalPlaces + "f", item));
					}
				}
			};
			return cell;
		});
	}

}
