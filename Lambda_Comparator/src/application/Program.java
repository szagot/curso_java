package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("iPhone", 3456.3));
		list.add(new Product("Sansung", 2996.3));
		list.add(new Product("Xiomi", 1456.99));

		// Expressão lambda de comparação para ordenar pelo mais caro
		list.sort((p1, p2) -> p2.getValue().compareTo(p1.getValue()));
		
		for (Product product : list) {
			System.out.println(product);
		}

	}

}
