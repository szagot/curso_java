package br.com.zefuinha.projeto_spring_boot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.Product;
import br.com.zefuinha.projeto_spring_boot_jpa.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	/**
	 * Lista registros
	 * 
	 * @return
	 */
	public List<Product> findAll() {
		return repository.findAll();
	}

	/**
	 * Pega registro pelo ID
	 * 
	 * @param id
	 * @return
	 */
	public Product findById(Long id) {
		Optional<Product> product = repository.findById(id);

		return product.get();
	}
}
