package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;
	// Agora ela depende da interface, e não mais depende da classe específica
	// BrazilTaxService
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	/**
	 * Gera a nota de pagamento
	 * 
	 * @param carRental
	 */
	public void processInvoice(CarRental carRental) {
		// Pegando o valor em milissegundos da data de entrada
		long tStart = carRental.getStart().getTime();
		// Pegando o valor em milissegundos da data de saída
		long tFinish = carRental.getFinish().getTime();
		// Diferença em horas
		double hours = (double) (tFinish - tStart) / 1000 / 60 / 60;

		// O aluguel foi menor ou igual a 12 horas?
		double basicPayment;
		if (hours <= 12.0) {
			// Valor de base do pagamento
			basicPayment = Math.ceil(hours) * pricePerHour;
		} else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}

		// Calcula a taxa
		double tax = taxService.tax(basicPayment);

		// Cria uma invoice baseado no pagamento de base e taxa
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
