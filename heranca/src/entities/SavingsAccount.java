package entities;

public class SavingsAccount extends Account {

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
	 */
	@Override
	public void withdraw(double amount) {
		// Na conta poupan�a n�o tem nenhuma taxa
		balance -= amount;
	}
}
