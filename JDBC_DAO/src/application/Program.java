package application;

import java.util.Date;
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
		List<Seller> sellersDept = sellerDao.findByDepartment(department);

		for (Seller obj : sellersDept) {
			System.out.println(obj);
		}

		// Testando findByDeparment
		System.out.println("\n=== TESTE 3: Seller findAll ===");
		List<Seller> sellers = sellerDao.findAll();

		for (Seller obj : sellers) {
			System.out.println(obj);
		}

		// Testando insert
		System.out.println("\n=== TESTE 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Daniel Bispo", "szagot@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println(newSeller);

		// Testando update
		System.out.println("\n=== TESTE 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println(seller);

	}

}
