package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	 * Elementos que ter�o alguma a��o
	 */

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	/**
	 * M�todos (a��es) dos elementos acima
	 */

	@FXML
	public void onMenuItemSellerAction() {

		// TODO: Teste
		System.out.println("onMenuItemSellerAction");

	}

	@FXML
	public void onMenuItemDepartmentAction() {

		// TODO: Abre a janela principal de Departamento
		loadView2("/gui/DepartmentList.fxml");

	}

	@FXML
	public void onMenuItemAboutAction() {

		// Abre a janela de about
		loadView("/gui/About.fxml");

	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// TODO Auto-generated method stub

	}

	/**
	 * M�todo para abrir outras views
	 * 
	 * synchronized -> garante que a abertura de tela n�o seja interrompida por
	 * processos paralelo
	 * 
	 * @param absoluteName
	 */
	private synchronized void loadView(String absoluteName) {
		try {

			// Intancia a view
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));

			// Abre a tela (que se espera ser do tipo VBox)
			VBox newVBox = loader.load();

			// Pega a cena (tela) principal para poder vincular a tela que est� sendo aberta
			Scene mainScene = Main.getMainScene();
			// Pega o primeiro elemento da minha view
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			// Guarda o menu (primeiro filho da janela principal)
			Node mainMenu = mainVBox.getChildren().get(0);

			// Limpa todo mundo do VBox principal
			mainVBox.getChildren().clear();

			// Recoloca o menu
			mainVBox.getChildren().add(mainMenu);
			// Adiciona a janela que est� sendo aberta
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {

			Alerts.showAlert("IO Error", "Erro ao carregar a p�gina", e.getMessage(), AlertType.ERROR);
		}
	}

	private void loadView2(String absoluteName) {
		try {

			// Intancia a view
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));

			// Abre a tela (que se espera ser do tipo VBox)
			VBox newVBox = loader.load();

			// Pega a cena (tela) principal para poder vincular a tela que est� sendo aberta
			Scene mainScene = Main.getMainScene();
			// Pega o primeiro elemento da minha view
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			// Guarda o menu (primeiro filho da janela principal)
			Node mainMenu = mainVBox.getChildren().get(0);

			// Limpa todo mundo do VBox principal
			mainVBox.getChildren().clear();

			// Recoloca o menu
			mainVBox.getChildren().add(mainMenu);
			// Adiciona a janela que est� sendo aberta
			mainVBox.getChildren().addAll(newVBox.getChildren());

			// Iniciando os dados da tabela
			DepartmentListController controller = loader.getController();
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();

		} catch (IOException e) {

			Alerts.showAlert("IO Error", "Erro ao carregar a p�gina", e.getMessage(), AlertType.ERROR);
		}
	}

}
