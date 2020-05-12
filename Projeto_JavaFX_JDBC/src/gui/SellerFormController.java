package gui;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	private Seller entity;
	private SellerService service;
	private DepartmentService deptService;
	// Lista das telas que desejam receber um aviso de alteração de BD
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
	private ComboBox<Department> cbDepartment;

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

	// Lista de departamentos
	private ObservableList<Department> deptObsList;

	public void setSeller(Seller entity) {
		this.entity = entity;
	}

	public void setServices(SellerService service, DepartmentService deptService) {
		this.service = service;
		this.deptService = deptService;
	}

	/**
	 * Adiciona um objeto para receber avisos de que houve uma alteração
	 * 
	 * @param listener
	 */
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (service == null) {
			throw new IllegalStateException("Serviço não pode ser nulo");
		}

		try {
			// Pega os dados do formulário
			entity = getFormData();
			// Salva no BD
			service.saveOrUpdate(entity);
			// Notifica as classes da alteração
			notifyDataChangeListeners();
			// Fecha a janela
			Utils.currentStage(event).close();

		} catch (DBException e) {
			Alerts.showAlert("Erro ", "Erro ao salvar o departamento", e.getMessage(), AlertType.ERROR);
		} catch (ValidationException e) {
			// Se houve uma exceção do tipo Validation, mostra no form
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
		// Restrições
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 100);
		Constraints.setTextFieldDouble(txtBaseSalary);
		Constraints.setTextFieldMaxLength(txtEmail, 100);
		Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");

		// Inicializa os departamentos
		initializeComboBoxDepartment();
	}

	/**
	 * Auxiliar para atualizar os campos do formulário com a entidade
	 */
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entidade não pode ser nula");
		}

		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());
		Locale.setDefault(Locale.US);
		txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
		if (entity.getBirthDate() != null) {
			dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
		}

		// Departamento
		if (entity.getDepartment() == null) {
			// Se for nulo, seleciona o primeiro
			cbDepartment.getSelectionModel().selectFirst();
		} else {
			// Senão, seleciona o itemdo BD
			cbDepartment.setValue(entity.getDepartment());
		}
	}

	/**
	 * Carrega os objetos associaddos
	 */
	public void loadAssociatedObjects() {
		if (deptService == null) {
			throw new IllegalStateException("Serviço de departamento não pode ser nulo");
		}

		List<Department> departments = deptService.findAll();
		deptObsList = FXCollections.observableArrayList(departments);
		cbDepartment.setItems(deptObsList);
	}

	/**
	 * Pega os dados do formulário e instancia um departamento
	 * 
	 * @return
	 */
	private Seller getFormData() {
		Seller seller = new Seller();

		ValidationException exception = new ValidationException("Erro de validação");

		seller.setId(Utils.tryParseToInt(txtId.getText()));

		// O campo nome está vazio?
		if (txtName.getText() == null || txtName.getText().trim().isEmpty()) {
			exception.addError("name", "Este campo não pode ser vazio");
		}
		seller.setName(txtName.getText());

		// O campo email está vazio?
		if (txtEmail.getText() == null || txtEmail.getText().trim().isEmpty()) {
			exception.addError("email", "Este campo não pode ser vazio");
		}
		seller.setEmail(txtEmail.getText());

		// Data de nascimento
		if (dpBirthDate.getValue() == null) {
			exception.addError("birthDate", "Escolha uma data de nascimento");
		} else {
			Instant instant = Instant.from(dpBirthDate.getValue().atStartOfDay(ZoneId.systemDefault()));
			seller.setBirthDate(Date.from(instant));
		}

		// O campo salário está vazio?
		if (txtBaseSalary.getText() == null || txtBaseSalary.getText().trim().isEmpty()) {
			exception.addError("baseSalary", "Este campo não pode ser vazio");
		}
		seller.setBaseSalary(Utils.tryParseToDouble(txtBaseSalary.getText()));

		// Departamento
		seller.setDepartment(cbDepartment.getValue());

		// Verifica se teve exceções
		if (exception.getErrors().size() > 0) {
			throw exception;
		}

		return seller;
	}

	/**
	 * Auxiliar para notificação de alteração
	 */
	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			// Emite o aviso para cada classe
			listener.onDataChanged();
		}
	}

	/**
	 * Auxiliar para preencher os erros no formulário
	 * 
	 * @param error
	 */
	private void setErrorMessages(Map<String, String> errors) {
		Set<String> fields = errors.keySet();

		// Pega o erro referente a nome
		lblErrorName.setText(fields.contains("name") ? errors.get("name") : "");

		// Pega o erro referente a email
		lblErrorEmail.setText(fields.contains("email") ? errors.get("email") : "");

		// Pega o erro referente a email
		lblErrorBirthDate.setText(fields.contains("birthDate") ? errors.get("birthDate") : "");

		// Pega o erro referente a salario
		lblErrorBaseSalary.setText(fields.contains("baseSalary") ? errors.get("baseSalary") : "");
	}

	/**
	 * Inicializa o combobox com os departamentos
	 */
	private void initializeComboBoxDepartment() {
		Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>() {
			@Override
			protected void updateItem(Department item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};

		cbDepartment.setCellFactory(factory);
		cbDepartment.setButtonCell(factory.call(null));
	}

}
