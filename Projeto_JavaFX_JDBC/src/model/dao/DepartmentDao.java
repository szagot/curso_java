package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	/**
	 * Inserção de dados
	 * 
	 * @param department
	 */
	void insert(Department department);

	/**
	 * Atualização de dados
	 * 
	 * @param department
	 */
	void update(Department department);

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
	Department findById(Integer id);

	/**
	 * Traz todos os registros
	 * 
	 * @return
	 */
	List<Department> findAll();

}
