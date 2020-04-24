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
	 * Sobreposi��o. Use sempre a nota��o @Override
	 * O "final" impede que e esse m�todo seja sobreposto por uma subclasse
	 * � recomendado usar o final quando o m�todo foi sobreposto
	 */
	@Override
	public final void withdraw(double amount) {
		// Na conta poupan�a n�o tem nenhuma taxa
		balance -= amount;
	}
}
