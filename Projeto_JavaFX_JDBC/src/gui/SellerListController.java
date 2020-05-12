package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
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
import model.entities.Seller;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerListController implements Initializable, DataChangeListener {

	@FXML
	private TableView<Seller> tableViewSeller;

	@FXML
	private TableColumn<Seller, Integer> tableColId;

	@FXML
	private TableColumn<Seller, String> tableColName;

	@FXML
	private TableColumn<Seller, String> tableColEmail;

	@FXML
	private TableColumn<Seller, Date> tableColBirthDate;

	@FXML
	private TableColumn<Seller, Double> tableColBaseSalary;

	@FXML
	private TableColumn<Seller, Seller> tableColEdit;

	@FXML
	private TableColumn<Seller, Seller> tableColRemove;

	@FXML
	private Button btNew;

	// Depend�ncia de servi�o
	private SellerService service;

	// Lista para carregar os dados da tabela
	private ObservableList<Seller> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {

		// Abre a janela de di�logo de cadastro do departamento
		createDialogForm(new Seller(), "/gui/SellerForm.fxml", Utils.currentStage(event));

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
	public void setSellerService(SellerService service) {
		this.service = service;
	}

	/**
	 * M�todo auxiliar para inicializar os componentes da tabela
	 */
	private void initializeNodes() {

		// Iniciando o comportamento das colunas
		tableColId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tableColBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		Utils.formatTableColumnDate(tableColBirthDate, "dd/MM/yyyy");
		tableColBaseSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
		Utils.formatTableColumnDouble(tableColBaseSalary, 2);

		// Ajustando tabela � janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewSeller.prefHeightProperty().bind(stage.heightProperty());

	}

	/**
	 * M�todo auxiliar para carregar os dados da tabela
	 */
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service n�o pode ser nulo");
		}

		// Carrega a lista da tabela
		List<Seller> sellers = service.findAll();
		obsList = FXCollections.observableArrayList(sellers);
		tableViewSeller.setItems(obsList);

		// Acrescenta o bot�o de edi��o e remo��o para cada linha da tabela
		initEditButtons();
		initRemoveButtons();
	}

	/**
	 * M�todo auxiliar para criar uma janela de di�logo
	 * 
	 * @param seller
	 * @param absoluteName
	 * @param parentStage
	 */
	private void createDialogForm(Seller seller, String absoluteName, Stage parentStage) {
		try {
			// Intancia a view
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			// Carrega os dados do departamento informado no formul�rio
			SellerFormController controller = loader.getController();
			controller.setSeller(seller);
			controller.setServices(new SellerService(), new DepartmentService());
			controller.loadAssociatedObjects();

			// Se inscreve para escutar os eventos de altera��o
			controller.subscribeDataChangeListener(this);

			// Atualiza os dados do form
			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com os dados do Vendedor");
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
			e.printStackTrace();
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
		tableColEdit.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("Editar");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> createDialogForm(obj, "/gui/SellerForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	/**
	 * Cria bot�es de remo��o
	 */
	private void initRemoveButtons() {
		tableColRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColRemove.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("Remover");

			@Override
			protected void updateItem(Seller seller, boolean empty) {
				super.updateItem(seller, empty);
				if (seller == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(seller));
			}
		});
	}

	/**
	 * Remove a entidade do departamento
	 * 
	 * @param seller
	 * @return
	 */
	private void removeEntity(Seller seller) {
		// Confirma com o us�rio a dele��o
		Optional<ButtonType> result = Alerts.showConfirmation("Confirma��o", "Deseja apagar esse departamento?");

		// A dele��o foi confirmada?
		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("O seriv�o n�o pode ser nulo");
			}

			try {
				// Remove o departamento
				service.remove(seller);
				// Atualiza os dados da tabela
				updateTableView();
			} catch (DBIntegratyException e) {
				Alerts.showAlert("Error IO", "Erro ao remover o departamento", e.getMessage(), AlertType.ERROR);
			}
		}
	}

}
