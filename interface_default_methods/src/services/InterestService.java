package services;

import java.security.InvalidParameterException;

public interface InterestService {

	public double getInterestRate();

	/**
	 * M�todo padr�o para c�lculo de pagamento. Dessa forma se elimina a necessidade
	 * de uma classe abstrata para casos assim.
	 * 
	 * ATEN��O! Esse tipo de m�todo s� est� dispon�vel a partir do JAVA 8.
	 * 
	 * @param amount
	 * @param months
	 * @return
	 */
	default double payment(Double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("O n�mero de meses precisa ser maior que 0");
		}

		return amount * Math.pow(1.0 + getInterestRate() / 100, months);
	}

}
