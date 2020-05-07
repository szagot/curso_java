package br.com.zefuinha.projeto_spring_boot_jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.User;
import br.com.zefuinha.projeto_spring_boot_jpa.services.UserService;

/**
 * Mapeamento (URI) para usuários
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	/**
	 * /users
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();

		return ResponseEntity.ok().body(users);
	}

	/**
	 * /users/{id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);

		return ResponseEntity.ok().body(user);
	}

}
