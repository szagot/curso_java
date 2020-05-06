package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/**
 * Classe respons�vel por instanciar os m�todos
 */
public class DaoFactory {

	/**
	 * Retorna a inst�ncia de Seller
	 * 
	 * @return
	 */
	public static SellerDao createSellerDAO() {
		// Usando o drive JDBC
		return new SellerDaoJDBC(DB.getConnection());
	}

}
