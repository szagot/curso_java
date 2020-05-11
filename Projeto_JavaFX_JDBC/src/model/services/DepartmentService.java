package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	// Usa a factory para pegar os dados do BD
	private DepartmentDao dao = DaoFactory.createDepartmentDAO();

	/**
	 * Pega todos os registros
	 * 
	 * @return
	 */
	public List<Department> findAll() {
		return dao.findAll();
	}

	/**
	 * Salva ou atualiza
	 * 
	 * @param department
	 */
	public void saveOrUpdate(Department department) {
		if (department.getId() == null) {
			// Departamento novo
			dao.insert(department);
		} else {
			// Atualiza o departamento
			dao.update(department);
		}
	}
}
