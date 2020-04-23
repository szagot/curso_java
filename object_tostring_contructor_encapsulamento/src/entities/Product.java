package entities;

public class Product {

	/**
	 * Modificadores de acesso
	 * 
	 * private: acess�vel apenas na classe
	 * [vazio]: acess�vel para classes do mesmo pacote
	 * protected: acess�vel para qualquer classe que herde da original
	 * public: acess�vel para todas as classes do mesmo m�dulo
	 */
	
	private String name;
	private double price;
	private int quantity;

	/**
	 * Construtor
	 * 
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public Product(String name, double price, int quantity) {
		setName(name);
		setPrice(price);
		increaseStock(quantity);
	}

	/**
	 * Construtor de sobrecarga, para quando a quantidade n�o for informada
	 * 
	 * @param name
	 * @param price
	 */
	public Product(String name, double price) {
		setName(name);
		setPrice(price);
	}

	/**
	 * Getters and Setters
	 */

	public Product setName(String name) {
		// this.parametro s� � necess�rio quando h� uma vari�vel local com o mesmo nome
		// do par�metro
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setPrice(double price) {
		if (price < 0) {
			price = 0;
		}

		this.price = price;

		return this;
	}

	public double getPrice() {
		return price;
	}

	// N�o tem o setQuantity, porque h� m�todos para adicionar ou retirar produtos
	// do estoque
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Retorna o valor total do estoque do produto
	 * 
	 * @return
	 */
	public double totalValueInStock() {
		return price * quantity;
	}

	/**
	 * Aumenta o estoque conforme a quantidade
	 * 
	 * @param quantity
	 */
	public void increaseStock(int quantity) {
		this.quantity += quantity;
	}

	/**
	 * Diminui o estoque conforme a quantidade (m�nimo 0)
	 * 
	 * @param quantity
	 */
	public void decreaseStock(int quantity) {
		this.quantity = (quantity > this.quantity) ? 0 : (this.quantity - quantity);
	}

	/**
	 * Executa automaticamente quando � tentado imprimir a classe diretamente
	 */
	public String toString() {
		// String.format() formata uma string usando o mesmo padr�o de
		// System.out.printf()
		return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " unidade(s), Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}

}
