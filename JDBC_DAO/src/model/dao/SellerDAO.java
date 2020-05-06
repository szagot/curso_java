package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDAO {

	/**
	 * Inserção de dados
	 * 
	 * @param department
	 */
	void insert(Seller department);

	/**
	 * Atualização de dados
	 * 
	 * @param department
	 */
	void update(Seller department);

	/**
	 * Deleção de dados
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
