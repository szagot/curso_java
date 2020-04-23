package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite os dados do Produto");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Valor: ");
		double price = sc.nextDouble();

		Product product = new Product(name, price);
		
		// Isso irá executar o product.toString()
		System.out.println();
 		System.out.println("Dados do produto: " + product);

		// Adiciona unidades ao produto
		System.out.println();
		System.out.print("Quantidade a adicionar: ");
		product.increaseStock(sc.nextInt());

		System.out.println();
		System.out.println("Dados atualizados: " + product);

		// Remove unidades do produto
		System.out.println();
		System.out.print("Quantidade a remover: ");
		product.decreaseStock(sc.nextInt());

		System.out.println();
		System.out.println("Dados atualizados: " + product);

		sc.close();

	}

}
