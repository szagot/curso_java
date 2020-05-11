package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	/**
	 * Inser��o de dados
	 * 
	 * @param department
	 */
	void insert(Department department);

	/**
	 * Atualiza��o de dados
	 * 
	 * @param department
	 */
	void update(Department department);

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
	Department findById(Integer id);

	/**
	 * Traz todos os registros
	 * 
	 * @return
	 */
	List<Department> findAll();

}
