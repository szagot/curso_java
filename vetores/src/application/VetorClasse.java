package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class VetorClasse {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Pegando a quantidade de posi��es no vetor
		System.out.print("Digite a quantidade de produtos: ");
		int n = sc.nextInt();

		// Criando um vetor de classe
		Product[] products = new Product[n];

		// Lendo os produtos
		for (int i = 0; i < products.length; i++) {
			sc.nextLine();
			
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Valor: $ ");
			double price = sc.nextDouble();
			products[i] = new Product(name, price);
		}

		// Calculando m�dia dos pre�os
		double sum = 0.0;
		for (int i = 0; i < products.length; i++) {
			sum += products[i].getPrice();
		}
		double media = sum / products.length;
		
		System.out.printf("A m�dia do(s) %d produto(s) � %.2f", n, media);

		sc.close();

	}

}
