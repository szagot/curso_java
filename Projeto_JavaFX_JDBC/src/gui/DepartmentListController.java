package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DBException;
import db.DBIntegratyException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListener {

	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, Integer> tableColId;

	@FXML
	private TableColumn<Department, String> tableColName;

	@FXML
	private TableColumn<Department, Department> tableColEdit;

	@FXML
	private TableColumn<Department, Department> tableColRemove;

	@FXML
	private Button btNew;

	// Depend�ncia de servi�o
	private DepartmentService service;

	// Lista para carregar os dados da tabela
	private ObservableList<Department> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {

		// Abre a janela de di�logo de cadastro do departamento
		createDialogForm(new Department(), "/gui/DepartmentForm.fxml", Utils.currentStage(event));

	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		initializeNodes();
	}

	/**
	 * Inicializa os servi�os de departamento
	 * 
	 * @param service
	 */
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	/**
	 * M�todo auxiliar para inicializar os componentes da tabela
	 */
	private void initializeNodes() {

		// Iniciando o comportamento das colunas
		tableColId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColName.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Ajustando tabela � janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());

	}

	/**
	 * M�todo auxiliar para carregar os dados da tabela
	 */
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service n�o pode ser nulo");
		}
		
		// Carrega a lista da tabela
		List<Department> departments = service.findAll();
		obsList = FXCollections.observableArrayList(departments);
		tableViewDepartment.setItems(obsList);

		// Acrescenta o bot�o de edi��o e remo��o para cada linha da tabela
		initEditButtons();
		initRemoveButtons();
	}

	/**
	 * M�todo auxiliar para criar uma janela de di�logo
	 * 
	 * @param department
	 * @param absoluteName
	 * @param parentStage
	 */
	private void createDialogForm(Department department, String absoluteName, Stage parentStage) {
		try {
			// Intancia a view
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			// Carrega os dados do departamento informado no formul�rio
			DepartmentFormController controller = loader.getController();
			controller.setDepartment(department);
			controller.setDepartmentService(new DepartmentService());
			controller.updateFormData();

			// Se inscreve para escutar os eventos de altera��o
			controller.subscribeDataChangeListener(this);

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com os dados do Departamento");
			dialogStage.setScene(new Scene(pane));
			// N�o pode ser redimensionada
			dialogStage.setResizable(false);
			// Informa quem � o pai desse di�logo
			dialogStage.initOwner(parentStage);
			// Indica que a janela � do tipo MODAL (n�o permite o acesso da janela anterior
			// enquanto esta estiver aberta)
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// �cone da Janela
			dialogStage.getIcons().add(Main.APP_ICON);
			// Mostra a janela
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("IO Error", "Erro ao abrir a view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();
	}

	/**
	 * Cria os bot�es de edi��o
	 */
	private void initEditButtons() {
		tableColEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColEdit.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("Editar");

			@Override
			protected void updateItem(Department obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/DepartmentForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	/**
	 * Cria bot�es de remo��o
	 */
	private void initRemoveButtons() {
		tableColRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColRemove.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("Remover");

			@Override
			protected void updateItem(Department department, boolean empty) {
				super.updateItem(department, empty);
				if (department == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(department));
			}
		});
	}

	/**
	 * Remove a entidade do departamento
	 * 
	 * @param department
	 * @return
	 */
	private void removeEntity(Department department) {
		// Confirma com o us�rio a dele��o
		Optional<ButtonType> result = Alerts.showConfirmation("Confirma��o", "Deseja apagar esse departamento?");

		// A dele��o foi confirmada?
		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("O seriv�o n�o pode ser nulo");
			}

			try {
				// Remove o departamento
				service.remove(department);
				// Atualiza os dados da tabela
				updateTableView();
			} catch (DBIntegratyException e) {
				Alerts.showAlert("Error IO", "Erro ao remover o departamento", e.getMessage(), AlertType.ERROR);
			}
		}
	}

}
