package br.com.zefuinha.projeto_spring_boot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.User;
import br.com.zefuinha.projeto_spring_boot_jpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 * Lista registros
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return repository.findAll();
	}

	/**
	 * Pega registro pelo ID
	 * 
	 * @param id
	 * @return
	 */
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);

		return user.get();
	}

	/**
	 * Insere um registo
	 * 
	 * @param user
	 * @return
	 */
	public User insert(User user) {
		return repository.save(user);
	}

	/**
	 * Apaga um registro
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
