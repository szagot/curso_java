package model.services;

// Usando a interface
public class BrazilTaxService implements TaxService {

	/**
	 * Retorna a taxa calculada
	 * 
	 * @param amount
	 * @return
	 */
	public double tax(double amount) {
		return (amount <= 100.0) ? (amount * 0.2) : (amount * 0.15);
	}

}
