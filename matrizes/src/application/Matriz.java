package application;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Determine o tamanho da matriz: ");
		int n = sc.nextInt();

		// Criando uma matriz
		int[][] matriz = new int[n][n];

		for (int lin = 0; lin < matriz.length; lin++) {
			for (int col = 0; col < matriz[lin].length; col++) {
				matriz[lin][col] = sc.nextInt();
			}
		}

		// Mostrando a diagonal principal
		System.out.print("Diagonal Principal: ");
		for (int lin = 0; lin < matriz.length; lin++) {
			System.out.print(matriz[lin][lin] + " ");
		}
		System.out.println();

		// Quantidade de números negativos
		int count = 0;
		for (int lin = 0; lin < matriz.length; lin++) {
			for (int col = 0; col < matriz[lin].length; col++) {
				if (matriz[lin][col] < 0) {
					count++;
				}
			}
		}
		System.out.println("Qtd de números negativos: " + count);

		sc.close();

	}

}
