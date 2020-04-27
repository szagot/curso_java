package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcecaoSimples {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			// Pega uma linha e divide cada palavra em uma posição do vetor
			String[] vetor = sc.nextLine().split(" ");

			// Pega a posição do vetor desejada para retorno
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		}

		// Exceção para quando se digita uma posição inválida
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição inválida");
		}

		// Exceção para quando se digita um número inválido
		catch (InputMismatchException e) {
			System.out.println("Digite um número para a posição desejada");
		}

		System.out.println("----------------");
		System.out.println("Fim do programa!");
		
		sc.close();

	}

}
