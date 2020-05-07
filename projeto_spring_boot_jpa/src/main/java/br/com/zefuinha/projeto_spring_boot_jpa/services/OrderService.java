package br.com.zefuinha.projeto_spring_boot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.Order;
import br.com.zefuinha.projeto_spring_boot_jpa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	/**
	 * Lista registros
	 * 
	 * @return
	 */
	public List<Order> findAll() {
		return repository.findAll();
	}

	/**
	 * Pega registro pelo ID
	 * 
	 * @param id
	 * @return
	 */
	public Order findById(Long id) {
		Optional<Order> order = repository.findById(id);

		return order.get();
	}
}
