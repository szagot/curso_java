package br.com.zefuinha.projeto_spring_boot_jpa.entities.enums;

public enum OrderStatus {

	// @formatter:off
	WAITING_PAYMENT(1), 
	PAID(2), 
	SHIPPED(3), 
	DELIVERED(4), 
	CANCELED(5);
	// @formatter:on

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	/**
	 * Devolve o OrderStatus do código informado
	 * 
	 * @param code
	 * @return
	 */
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			// Encontrou o código apropriado?
			if (value.getCode() == code) {
				return value;
			}
		}

		// Se chegou até aqui é porque o código não existe
		throw new IllegalArgumentException("Código do status do pedido é inválido");
	}
}
