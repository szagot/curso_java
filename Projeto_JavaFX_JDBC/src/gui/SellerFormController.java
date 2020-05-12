package gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DBException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	private Seller entity;
	private SellerService service;
	// Lista das telas que desejam receber um aviso de altera��o de BD
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtEmail;

	@FXML
	private DatePicker dpBirthDate;

	@FXML
	private TextField txtBaseSalary;

	@FXML
	private Label lblErrorName;

	@FXML
	private Label lblErrorEmail;

	@FXML
	private Label lblErrorBirthDate;

	@FXML
	private Label lblErrorBaseSalary;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	public void setSeller(Seller entity) {
		this.entity = entity;
	}

	public void setSellerService(SellerService service) {
		this.service = service;
	}

	/**
	 * Adiciona um objeto para receber avisos de que houve uma altera��o
	 * 
	 * @param listener
	 */
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (service == null) {
			throw new IllegalStateException("Servi�o n�o pode ser nulo");
		}

		try {
			// Pega os dados do formul�rio
			entity = getFormData();
			// Salva no BD
			service.saveOrUpdate(entity);
			// Notifica as classes da altera��o
			notifyDataChangeListeners();
			// Fecha a janela
			Utils.currentStage(event).close();

		} catch (DBException e) {
			Alerts.showAlert("Erro ", "Erro ao salvar o departamento", e.getMessage(), AlertType.ERROR);
		} catch (ValidationException e) {
			// Se houve uma exce��o do tipo Validation, mostra no form
			setErrorMessages(e.getErrors());
		}
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		// Fecha a janela
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		initializeNodes();
	}

	/**
	 * Auxiliar para iniciar os objetos da janelas
	 */
	private void initializeNodes() {
		// Restri��es
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 100);
		Constraints.setTextFieldDouble(txtBaseSalary);
		Constraints.setTextFieldMaxLength(txtEmail, 100);
		Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");
	}

	/**
	 * Auxiliar para atualizar os campos do formul�rio com a entidade
	 */
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entidade n�o pode ser nula");
		}

		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());
		Locale.setDefault(Locale.US);
		txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
		if (entity.getBirthDate() != null) {
			dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
		}
	}

	/**
	 * Pega os dados do formul�rio e instancia um departamento
	 * 
	 * @return
	 */
	private Seller getFormData() {
		Seller seller = new Seller();

		ValidationException exception = new ValidationException("Erro de valida��o");

		seller.setId(Utils.tryParseToInt(txtId.getText()));

		// O campo nome est� vazio?
		if (txtName.getText() == null || txtName.getText().trim().isEmpty()) {
			exception.addError("name", "O campo n�o pode ser vazio");
		}

		seller.setName(txtName.getText());

		// Verifica se teve exce��es
		if (exception.getErrors().size() > 0) {
			throw exception;
		}

		return seller;
	}

	/**
	 * Auxiliar para notifica��o de altera��o
	 */
	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			// Emite o aviso para cada classe
			listener.onDataChanged();
		}
	}

	/**
	 * Auxiliar para preencher os erros no formul�rio
	 * 
	 * @param error
	 */
	private void setErrorMessages(Map<String, String> errors) {
		Set<String> fields = errors.keySet();

		// Pega o erro referente a nome
		if (fields.contains("name")) {
			lblErrorName.setText(errors.get("name"));
		}
	}

}
