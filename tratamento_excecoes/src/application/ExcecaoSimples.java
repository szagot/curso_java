package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcecaoSimples {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			// Pega uma linha e divide cada palavra em uma posi��o do vetor
			String[] vetor = sc.nextLine().split(" ");

			// Pega a posi��o do vetor desejada para retorno
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		}

		// Exce��o para quando se digita uma posi��o inv�lida
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posi��o inv�lida");
		}

		// Exce��o para quando se digita um n�mero inv�lido
		catch (InputMismatchException e) {
			System.out.println("Digite um n�mero para a posi��o desejada");
		}

		System.out.println("----------------");
		System.out.println("Fim do programa!");
		
		sc.close();

	}

}
