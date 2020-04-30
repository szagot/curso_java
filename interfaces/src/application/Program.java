package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {
	public static void main(String[] args) throws ParseException {

		/**
		 * Exerc�cio proposto: Uma locadora brasileira de carros cobra um valor por hora
		 * para loca��es de at� 12 horas. Por�m, se a dura��o da loca��o ultrapassar 12
		 * horas, a loca��o ser� cobrada com base em um valor di�rio. Al�m do valor da
		 * loca��o, � acrescido no pre�o o valor do imposto conforme regras do pa�s que,
		 * no caso do Brasil, � 20% para valores at� 100.00, ou 15% para valores acima
		 * de 100.00. Fazer um programa que l� os dados da loca��o (modelo do carro,
		 * instante inicial e final da loca��o), bem como o valor por hora e o valor
		 * di�rio de loca��o. O programa deve ent�o gerar a nota de pagamento (contendo
		 * valor da loca��o, valor do imposto e valor total do pagamento) e informar os
		 * dados na tela. Veja os exemplos.
		 */

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Dados do aluguel");

		System.out.print("Modelo do Carro: ");
		String carModel = sc.nextLine();

		System.out.print("Data do Aluguel (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());

		System.out.print("Data de Devolu��o (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());

		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Pre�o por hora: ");
		double pricePerHour = sc.nextDouble();

		System.out.print("Pre�o por Dia: ");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

		// Processando o aluguel
		rentalService.processInvoice(cr);

		System.out.println("INVOICE: ");
		System.out.printf("Pagamento b�sico: %.2f\n", cr.getInvoice().getBasicPayment());
		System.out.printf("Taxa: %.2f\n", cr.getInvoice().getTax());
		System.out.printf("Pagamento Total: %.2f\n", cr.getInvoice().getTotalPayment());

	}
}
