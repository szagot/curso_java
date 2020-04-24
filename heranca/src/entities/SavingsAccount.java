package entities;

/**
 * O "final" impede que a classe SavingsAccount seja herdada por outra classe
 */
public final class SavingsAccount extends Account {

	private Double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * Atualiza o saldo baseado na taxa de juros
	 */
	public void updateBalance() {
		balance += balance * interestRate;
	}

	/**
	 * Sobreposição. Use sempre a notação @Override
	 * O "final" impede que e esse método seja sobreposto por uma subclasse
	 * é recomendado usar o final quando o método foi sobreposto
	 */
	@Override
	public final void withdraw(double amount) {
		// Na conta poupança não tem nenhuma taxa
		balance -= amount;
	}
}
