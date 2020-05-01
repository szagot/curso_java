package model.services;

// Usando a interface
public class UsaTaxService implements TaxService {

	/**
	 * Retorna a taxa calculada
	 * 
	 * @param amount
	 * @return
	 */
	public double tax(double amount) {
		return (amount <= 150.0) ? (amount * 0.3) : (amount * 0.25);
	}

}
