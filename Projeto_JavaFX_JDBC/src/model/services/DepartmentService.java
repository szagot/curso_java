package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	// Usa a factory para pegar os dados do BD
	private DepartmentDao dao = DaoFactory.createDepartmentDAO();

	public List<Department> findAll() {

		return dao.findAll();

	}

}
