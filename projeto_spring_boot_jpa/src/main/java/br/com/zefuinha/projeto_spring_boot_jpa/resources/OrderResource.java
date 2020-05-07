package br.com.zefuinha.projeto_spring_boot_jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.Order;
import br.com.zefuinha.projeto_spring_boot_jpa.services.OrderService;

/**
 * Mapeamento (URI) para usuários
 */

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	/**
	 * /orders
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = service.findAll();

		return ResponseEntity.ok().body(orders);
	}

	/**
	 * /orders/{id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = service.findById(id);

		return ResponseEntity.ok().body(order);
	}

}
