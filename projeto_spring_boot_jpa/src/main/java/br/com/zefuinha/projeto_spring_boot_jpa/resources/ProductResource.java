package br.com.zefuinha.projeto_spring_boot_jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.Product;
import br.com.zefuinha.projeto_spring_boot_jpa.services.ProductService;

/**
 * Mapeamento (URI) para produtos
 */

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	/**
	 * /products
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = service.findAll();

		return ResponseEntity.ok().body(products);
	}

	/**
	 * /products/{id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = service.findById(id);

		return ResponseEntity.ok().body(product);
	}

}
