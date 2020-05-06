package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDAO {

	/**
	 * Inser��o de dados
	 * 
	 * @param department
	 */
	void insert(Seller department);

	/**
	 * Atualiza��o de dados
	 * 
	 * @param department
	 */
	void update(Seller department);

	/**
	 * Dele��o de dados
	 * 
	 * @param id
	 */
	void deleteById(Integer id);

	/**
	 * Localiza pelo ID
	 * 
	 * @param id
	 * @return
	 */
	Seller findById(Integer id);

	/**
	 * Traz todos os registros
	 * 
	 * @return
	 */
	List<Seller> findAll();

}
