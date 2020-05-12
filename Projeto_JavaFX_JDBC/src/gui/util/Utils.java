package gui.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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

	/**
	 * Retorna o double de dentro de um string. Se n�o for um double v�lido, retorna
	 * nulo
	 * 
	 * @param str
	 * @return
	 */
	public static Double tryParseToDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Formata campos de data
	 * https://stackoverflow.com/questions/47484280/format-of-date-in-the-javafx-tableview
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
	 * Formata o campo de digita��o para Data
	 * https://stackoverflow.com/questions/26831978/javafx-datepicker-getvalue-in-a-specific-format
	 * 
	 * @param datePicker
	 * @param format
	 */
	public static void formatDatePicker(DatePicker datePicker, String format) {
		datePicker.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
			{
				datePicker.setPromptText(format.toLowerCase());
			}

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		});
	}

	/**
	 * Formata campos de ponto flutuante
	 * https://stackoverflow.com/questions/47484280/format-of-date-in-the-javafx-tableview
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
