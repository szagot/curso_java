package br.com.zefuinha.projeto_spring_boot_jpa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.User;
import br.com.zefuinha.projeto_spring_boot_jpa.repositories.UserRepository;
import br.com.zefuinha.projeto_spring_boot_jpa.services.exceptions.DatabaseException;
import br.com.zefuinha.projeto_spring_boot_jpa.services.exceptions.ResourceNotFoundException;

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

		// Retorna o usuário ou uma exceção personalizada no caso do id não existir
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
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
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// Se o ID não existir, lança a exceção personalizada para 404
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			// Se o ID a ser apagado estiver sendo usado por um pedido, lança a exceção de
			// violação de chave estrangeira
			throw new DatabaseException(e.getMessage());
		}
	}

	/**
	 * Atualiza um registro
	 * 
	 * @param id   Indica o ID do registro a ser alterado
	 * @param user
	 * @return
	 */
	public User update(Long id, User user) {
		try {
			// Prepara um objeto monitorado baseado no ID, sem precisar pegar no BD
			User entity = repository.getOne(id);

			// Atualiza os dados
			updateData(entity, user);

			// Salva no BD
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			// Se o ID não existir, lança a exceção personalizada para 404
			throw new ResourceNotFoundException(id);
		}
	}

	/**
	 * Atualiza os dados de entity, baseado no obj user
	 * 
	 * @param entity
	 * @param user
	 */
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

		// Nem ID e nem Senha são atualizados aqui
	}
}
