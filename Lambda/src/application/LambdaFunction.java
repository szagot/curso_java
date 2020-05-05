package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class LambdaFunction {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Monitor", 900.0));
		list.add(new Product("Mouse", 50.0));
		list.add(new Product("Tablet", 350.0));
		list.add(new Product("HD Case", 80.0));

		// Gerando uma nova lista com nomes em maiúsculo
		List<String> names = 
				// Gerando stream a partir da lista
				list.stream()
				// Aplicando a função lambda a cada elemento
				.map(p -> p.getName().toUpperCase())
				// Gerando uma lista a partir do stream
				.collect(Collectors.toList());

		// Imprimindo a lista usando Consumer
		names.forEach(System.out::println);

	}

}
