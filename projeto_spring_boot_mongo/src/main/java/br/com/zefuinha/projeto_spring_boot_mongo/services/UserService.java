package br.com.zefuinha.projeto_spring_boot_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;
import br.com.zefuinha.projeto_spring_boot_mongo.dto.UserDTO;
import br.com.zefuinha.projeto_spring_boot_mongo.repositories.UserRepository;
import br.com.zefuinha.projeto_spring_boot_mongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	// @Autowired faz com que o objeto seja instanciado automaticamente
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		// Retorna apenas se foi encontrado
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}

	public User insert(User user) {
		return repository.insert(user);
	}

	public void delete(String id) {
		// Busca o ID apenas para lançar e exceção caso não exista
		findById(id);
		// Deleta
		repository.deleteById(id);
	}

	/**
	 * Converte de um DTO para a Entidade normal
	 * 
	 * @param userDTO
	 * @return
	 */
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
