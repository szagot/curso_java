package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/**
 * Classe responsável por instanciar os métodos
 */
public class DaoFactory {

	/**
	 * Retorna a instância de Seller
	 * 
	 * @return
	 */
	public static SellerDao createSellerDAO() {
		// Usando o drive JDBC
		return new SellerDaoJDBC(DB.getConnection());
	}

}
