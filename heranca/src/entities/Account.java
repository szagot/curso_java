package entities;

public class Account {

	private static final double tax = 5;
	
	private Integer number;
	private String holder;
	// Permite que seja acessado pelas subclasses
	protected Double balance;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	/**
	 * Saque
	 * @param amount
	 */
	public void withdraw(double amount) {
		balance -= amount + tax;
	}

	/**
	 * Depósito
	 * @param amount
	 */
	public void deposit(double amount) {
		balance += amount;
	}
}
