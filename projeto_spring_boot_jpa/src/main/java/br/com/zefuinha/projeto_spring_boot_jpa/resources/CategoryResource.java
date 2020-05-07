package br.com.zefuinha.projeto_spring_boot_jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.Category;
import br.com.zefuinha.projeto_spring_boot_jpa.services.CategoryService;

/**
 * Mapeamento (URI) para Categorias
 */

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	/**
	 * /categories
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = service.findAll();

		return ResponseEntity.ok().body(categories);
	}

	/**
	 * /categories/{id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = service.findById(id);

		return ResponseEntity.ok().body(category);
	}

}
