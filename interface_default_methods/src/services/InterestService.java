package services;

import java.security.InvalidParameterException;

public interface InterestService {

	public double getInterestRate();

	/**
	 * Método padrão para cálculo de pagamento. Dessa forma se elimina a necessidade
	 * de uma classe abstrata para casos assim.
	 * 
	 * ATENÇÃO! Esse tipo de método só está disponível a partir do JAVA 8.
	 * 
	 * @param amount
	 * @param months
	 * @return
	 */
	default double payment(Double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("O número de meses precisa ser maior que 0");
		}

		return amount * Math.pow(1.0 + getInterestRate() / 100, months);
	}

}
