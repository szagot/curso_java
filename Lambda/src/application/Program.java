package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Monitor", 900.0));
		list.add(new Product("Mouse", 50.0));
		list.add(new Product("Tablet", 350.0));
		list.add(new Product("HD Case", 80.0));

		// Remove da lista os itens cujo valores são superiores a 100
		list.removeIf(x -> x.getValue() >= 100);

		for (Product product : list) {
			System.out.println(product);
		}

	}

}
