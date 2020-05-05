package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import entities.services.ProductService;

public class LambdaCriandoMetodo {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.0));
		list.add(new Product("Mouse", 50.0));
		list.add(new Product("Tablet", 350.0));
		list.add(new Product("HD Case", 80.0));

		// Calculando a soma dos produtos cujo nome começa com T
		Double sumT = ProductService.filteredSum(list, x -> x.getName().toUpperCase().charAt(0) == 'T');

		System.out.printf("O valor dos produtos começado com T é: R$ %.2f", sumT);
	}

}