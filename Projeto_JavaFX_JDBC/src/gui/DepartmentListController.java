package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		initializeNodes();
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
	 * Inicializa os serviços de departamento
	 * 
	 * @param service
	 */
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

}
