package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	/**
	 * Inser��o de dados
	 * 
	 * @param seller
	 */
	void insert(Seller seller);

	/**
	 * Atualiza��o de dados
	 * 
	 * @param seller
	 */
	void update(Seller seller);

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
	 * Traz todos os registros de um departamento
	 * 
	 * @return
	 */
	List<Seller> findByDepartment(Department department);

	/**
	 * Traz todos os registros
	 * 
	 * @return
	 */
	List<Seller> findAll();

}
