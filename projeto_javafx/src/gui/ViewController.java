package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Person> comboBoxPerson;

	// Implemetan o comportamento entre a minha lista e o combobox
	private ObservableList<Person> obsList;

	@FXML
	private Button btAll;

	@FXML
	public void onComboBoxPersonAction() {
		// Pega o item selecionado
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();

		// Imprime o item selecionado no console
		System.out.println(person);
	}

	@FXML
	public void onBtAllAction() {
		// Pega cada uma das pessoas
		for(Person person:comboBoxPerson.getItems()) {
			// E imprime no console
			System.out.println(person);
		}
	}

	/**
	 * Executa quando o controlador for criado
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Cria uma lista de pessoas para exemplo (seria puxado do BD)
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Daniel Bispo", "szagot@gmail.com"));
		persons.add(new Person(2, "Alini Bispo", "alini.r.bispo@gmail.com"));
		persons.add(new Person(3, "Filipe Daniel", "filipe.d.bispo@gmail.com"));
		persons.add(new Person(4, "Alejandro Gabriel", "alejandro.r.bispo@gmail.com"));

		// Define um ObservableList a partir da lista
		obsList = FXCollections.observableArrayList(persons);

		// Adiciona a lista ao comboBox
		comboBoxPerson.setItems(obsList);

		// Define o padrão para pegar os nomes das pessoas
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));

	}

}
