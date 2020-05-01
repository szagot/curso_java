package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Cria a variável do tipo classe genérica, para melhor portabilidade
		PrintService<Integer> ps = new PrintService<>();

		System.out.print("Quantos itens você irá digitar? ");
		Integer qt = sc.nextInt();

		for (int i = 0; i < qt; i++) {
			Integer value = sc.nextInt();
			ps.addValue(value);
		}
		
		ps.print();
		System.out.println("Primeiro item: " + ps.first());

		sc.close();

	}

}
