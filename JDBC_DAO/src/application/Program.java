package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDAO();

		// Testando findById
		System.out.println("=== TESTE 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		// Testando findByDeparment
		System.out.println("\n=== TESTE 2: Seller findByDeparment ===");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		for (Seller obj : sellers) {
			System.out.println(obj);
		}

	}

}
