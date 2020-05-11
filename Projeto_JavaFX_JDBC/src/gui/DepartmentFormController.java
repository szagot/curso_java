package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	private Department entity;
	private DepartmentService service;
	// Lista das telas que desejam receber um aviso de alteração de BD
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Label lblErrorName;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
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
	}

	/**
	 * Pega os dados do formulário e instancia um departamento
	 * 
	 * @return
	 */
	private Department getFormData() {
		Department department = new Department();

		department.setId(Utils.tryParseToInt(txtId.getText()));
		department.setName(txtName.getText());

		return department;
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

}
