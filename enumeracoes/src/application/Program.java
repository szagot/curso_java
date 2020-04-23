package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		// Instanciando uma classe usando ENUM
		Order order = new Order(1080, new Date(), OrderStatus.AGUARDANDO_PAGAMENTO);
		System.out.println(order);
		
		// Transformando string em um ENUM
		OrderStatus os1 = OrderStatus.ENTREGUE;
		OrderStatus os2 = OrderStatus.valueOf("ENTREGUE");
		System.out.println(os1);
		System.out.println(os2);

	}

}
