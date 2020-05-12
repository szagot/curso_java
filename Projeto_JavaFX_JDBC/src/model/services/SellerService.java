package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

	// Usa a factory para pegar os dados do BD
	private SellerDao dao = DaoFactory.createSellerDAO();

	/**
	 * Pega todos os registros
	 * 
	 * @return
	 */
	public List<Seller> findAll() {
		return dao.findAll();
	}

	/**
	 * Salva ou atualiza
	 * 
	 * @param seller
	 */
	public void saveOrUpdate(Seller seller) {
		if (seller.getId() == null) {
			// Departamento novo
			dao.insert(seller);
		} else {
			// Atualiza o departamento
			dao.update(seller);
		}
	}

	/**
	 * Remove um departamento
	 * 
	 * @param seller
	 */
	public void remove(Seller seller) {
		dao.deleteById(seller.getId());
	}
}
