package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Department;

public class ProgramTestDepartment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDAO();

		// Testando findById
		System.out.println("=== TESTE 1: Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);


		// Testando findAll
		System.out.println("\n=== TESTE 2: Department findAll ===");
		List<Department> departments = departmentDao.findAll();

		for (Department obj : departments) {
			System.out.println(obj);
		}

		// Testando insert
		System.out.println("\n=== TESTE 3: Department insert ===");
		Department newDepartment = new Department(null, "Financeiro");
		departmentDao.insert(newDepartment);
		System.out.println(newDepartment);

		// Testando update
		System.out.println("\n=== TESTE 4: Department update ===");
		department = departmentDao.findById(1);
		department.setName("Computadores");
		departmentDao.update(department);
		System.out.println(department);

		// Testando update
		System.out.println("\n=== TESTE 5: Department update ===");
		System.out.print("Digite o ID para ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.printf("Departmento %d Apagado!\n", id);
		
		sc.close();

	}

}
