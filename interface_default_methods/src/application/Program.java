package application;

import java.util.Locale;
import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;
import services.UsaInterestService;

public class Program {
	public static void main(String args[]) {

		/**
		 * Fazer um programa para ler uma quantia e a duração em meses de um empréstimo.
		 * Informar o valor a ser pago depois de decorrido o prazo do empréstimo,
		 * conforme regras de juros do Brasil. A regra de cálculo de juros do Brasil é
		 * juro composto padrão de 2% ao mês. (Payment = amount * pow((1 + interestRate
		 * / 100), n))
		 */

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Empréstimo: $ ");
		double amount = sc.nextDouble();

		System.out.print("Quantidade de Meses: ");
		int months = sc.nextInt();

		InterestService isB = new BrazilInterestService();
		double paymentB = isB.payment(amount, months);

		InterestService isU = new UsaInterestService();
		double paymentU = isU.payment(amount, months);

		System.out.println();
		System.out.printf("Pagamento após %d meses\nBrasil: R$ %.2f\n", months, paymentB);
		System.out.printf("USA...:  $ %.2f", paymentU);

	}
}
