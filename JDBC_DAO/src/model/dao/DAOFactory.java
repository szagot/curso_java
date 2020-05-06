package model.dao;

import model.dao.impl.SellerDAOJDBC;

/**
 * Classe responsável por instanciar os métodos
 */
public class DAOFactory {

	/**
	 * Retorna a instância de Seller
	 * 
	 * @return
	 */
	public static SellerDAO createSellerDAO() {
		// Usando o drive JDBC
		return new SellerDAOJDBC();
	}

}
