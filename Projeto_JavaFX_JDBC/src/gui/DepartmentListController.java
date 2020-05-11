package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, Integer> tableColId;

	@FXML
	private TableColumn<Department, String> tableColName;

	@FXML
	private Button btNew;

	// Dependência de serviço
	private DepartmentService service;

	// Lista para carregar os dados da tabela
	private ObservableList<Department> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {

		// Abre a janela de diálogo de cadastro do departamento
		createDialogForm(new Department(), "/gui/DepartmentForm.fxml", Utils.currentStage(event));

	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		initializeNodes();
	}

	/**
	 * Inicializa os serviços de departamento
	 * 
	 * @param service
	 */
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	/**
	 * Método auxiliar para inicializar os componentes da tabela
	 */
	private void initializeNodes() {

		// Iniciando o comportamento das colunas
		tableColId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColName.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Ajustando tabela à janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());

	}

	/**
	 * Método auxiliar para carregar os dados da tabela
	 */
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service não pode ser nulo");
		}

		// Carrega a lista da tabela
		List<Department> departments = service.findAll();
		obsList = FXCollections.observableArrayList(departments);
		tableViewDepartment.setItems(obsList);

	}

	/**
	 * Método auxiliar para criar uma janela de diálogo
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

			// Carrega os dados do departamento informado no formulário
			DepartmentFormController controller = loader.getController();
			controller.setDepartment(department);
			controller.setDepartmentService(new DepartmentService());
			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com os dados do Departamento");
			dialogStage.setScene(new Scene(pane));
			// Não pode ser redimensionada
			dialogStage.setResizable(false);
			// Informa quem é o pai desse diálogo
			dialogStage.initOwner(parentStage);
			// Indica que a janela é do tipo MODAL (não permite o acesso da janela anterior
			// enquanto esta estiver aberta)
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// Ícone da Janela
			dialogStage.getIcons().add(Main.APP_ICON);
			// Mostra a janela
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("IO Error", "Erro ao abrir a view", e.getMessage(), AlertType.ERROR);
		}
	}
}
