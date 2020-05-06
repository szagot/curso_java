package model.dao;

import model.dao.impl.SellerDAOJDBC;

/**
 * Classe respons�vel por instanciar os m�todos
 */
public class DAOFactory {

	/**
	 * Retorna a inst�ncia de Seller
	 * 
	 * @return
	 */
	public static SellerDAO createSellerDAO() {
		// Usando o drive JDBC
		return new SellerDAOJDBC();
	}

}
