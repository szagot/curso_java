package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	/**
	 * Elementos que terão alguma ação
	 */

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	/**
	 * Métodos (ações) dos elementos acima
	 */

	@FXML
	public void onMenuItemSellerAction() {

		// TODO: Teste
		System.out.println("onMenuItemSellerAction");

	}

	@FXML
	public void onMenuItemDepartmentAction() {

		// Abre a janela principal de Departamento
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			// Carrega os dados da tabela
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});

	}

	@FXML
	public void onMenuItemAboutAction() {

		// Abre a janela de about
		loadView("/gui/About.fxml", x -> {
		});

	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// TODO Auto-generated method stub

	}

	/**
	 * Método para abrir outras views
	 * 
	 * synchronized -> garante que a abertura de tela não seja interrompida por
	 * processos paralelo
	 * 
	 * @param absoluteName
	 */
	private synchronized <Type> void loadView(String absoluteName, Consumer<Type> intializingAction) {
		try {

			// Intancia a view
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));

			// Abre a tela (que se espera ser do tipo VBox)
			VBox newVBox = loader.load();

			// Pega a cena (tela) principal para poder vincular a tela que está sendo aberta
			Scene mainScene = Main.getMainScene();
			// Pega o primeiro elemento da minha view
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			// Guarda o menu (primeiro filho da janela principal)
			Node mainMenu = mainVBox.getChildren().get(0);

			// Limpa todo mundo do VBox principal
			mainVBox.getChildren().clear();

			// Recoloca o menu
			mainVBox.getChildren().add(mainMenu);
			// Adiciona a janela que está sendo aberta
			mainVBox.getChildren().addAll(newVBox.getChildren());

			// Incializando ação da janela
			Type controller = loader.getController();
			intializingAction.accept(controller);

		} catch (IOException e) {

			Alerts.showAlert("IO Error", "Erro ao carregar a página", e.getMessage(), AlertType.ERROR);
		}
	}

}
