package entities;

/**
 * Herdando de Account
 */
public class BusinessAccount extends Account {

	private static final double discount = 10;

	private Double loanLimit;

	public BusinessAccount() {
		// Chamando o construtor da classe de onde se herdou os dados
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		// Chamando o construtor da classe de onde se herdou os dados
		super(number, holder, balance);
		// Adicionando o parâmetro dessa classe
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	/**
	 * Empréstimo
	 * 
	 * @param amount
	 */
	public void loan(double amount) {
		if (amount <= loanLimit) {
			// Isso só é permitido, pq balance é protected. Caso contrário, não seria
			// possível acessar o atributo
			balance += amount - discount;
		}
	}

}
