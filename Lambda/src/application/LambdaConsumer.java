package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class LambdaConsumer {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Monitor", 900.0));
		list.add(new Product("Mouse", 50.0));
		list.add(new Product("Tablet", 350.0));
		list.add(new Product("HD Case", 80.0));

		// Aumentando cada produto em 10% usando Consumer e imprimindo
		// (Se só tiver um comando, não precisa das chaves)
		list.forEach(x -> {
			x.setValue(x.getValue() * 1.1);
			System.out.println(x);
		});
		
	}

}
