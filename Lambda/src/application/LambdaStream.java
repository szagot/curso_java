package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Product;

public class LambdaStream {

	public static void main(String[] args) {
		/**
		 * Mostrar o pre�o m�dio dos produtos. Depois, mostrar os nomes, em ordem
		 * decrescente, dos produtos que possuem pre�o inferior ao pre�o m�dio
		 */

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.0));
		list.add(new Product("Mouse", 50.0));
		list.add(new Product("Tablet", 350.0));
		list.add(new Product("HD Case", 80.0));
		list.add(new Product("Computer", 850.0));
		list.add(new Product("Monitor", 290.0));

		// Calculando a m�dia
		double avg =
				// Gerando um stream da lista
				list.stream()
						// Pegando apenas os valores
						.map(p -> p.getValue())
						// Somando todos os elementos da lista, e dividindo pela quantidade
						.reduce(0.0, (x, y) -> x + y) / list.size();
		
		System.out.printf("M�dia dos valores: %.2f\n", avg);

		// Pegando nome dos produtos abaixo da m�dia, em ordem decrescente
		List<String> names = list.stream()
				// Pegando apenas produtos abaixo da m�dia
				.filter(p -> p.getValue() < avg)
				// Pegando apenas os nomes deles
				.map(p -> p.getName())
				// Ordenando em ordem decrescente
				.sorted((p1, p2) -> p2.toUpperCase().compareTo(p1.toUpperCase()))
				// Gerando lista a partir do stream
				.collect(Collectors.toList());

		System.out.println("\nProdutos abaixo da m�dia");
		names.forEach(System.out::println);

	}

}
