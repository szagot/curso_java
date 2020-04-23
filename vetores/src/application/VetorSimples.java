package application;

import java.util.Locale;
import java.util.Scanner;

public class VetorSimples {

	/**
	 * Um vetor � um array de posi��o fixa (como o String)
	 */

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Pegando a quantidade de posi��es no vetor
		System.out.print("Digite a quantidade de pessoas: ");
		int n = sc.nextInt();

		// Criando o vetor com n posi��es
		double[] alturas = new double[n];

		// Lendo as alturas
		for (int i = 0; i < alturas.length; i++) {
			System.out.printf("Digite a altura da %da pessoa: ", i + 1);
			alturas[i] = sc.nextDouble();
		}

		// Calculando altura m�dia
		double soma = 0;
		for (int i = 0; i < alturas.length; i++) {
			soma += alturas[i];
		}
		double media = soma / alturas.length;

		System.out.printf("M�dia da altura da(s) %d pessoa(s): %.2f", alturas.length, media);

		sc.close();

	}

}
