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

		// Testando: Se tudo estiver certo, isso irá alterar todos os registros que
		// repetirem nessa sessão (apenas na impressão, e não no BD)
		seller.getDepartment().setName("Teste doido");
		seller.setName("Doidinho de Pedra");

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

	}

}
