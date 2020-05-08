package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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

		// TODO: Teste
		System.out.println("onMenuItemDepartmentAction");

	}

	@FXML
	public void onMenuItemAboutAction() {

		// TODO: Teste
		System.out.println("onMenuItemAboutAction");

	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// TODO Auto-generated method stub

	}

}
