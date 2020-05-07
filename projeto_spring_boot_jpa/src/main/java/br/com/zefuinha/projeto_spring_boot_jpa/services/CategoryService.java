package br.com.zefuinha.projeto_spring_boot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.Category;
import br.com.zefuinha.projeto_spring_boot_jpa.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	/**
	 * Lista registros
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		return repository.findAll();
	}

	/**
	 * Pega registro pelo ID
	 * 
	 * @param id
	 * @return
	 */
	public Category findById(Long id) {
		Optional<Category> category = repository.findById(id);

		return category.get();
	}
}
