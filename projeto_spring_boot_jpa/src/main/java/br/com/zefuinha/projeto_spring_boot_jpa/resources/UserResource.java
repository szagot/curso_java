package br.com.zefuinha.projeto_spring_boot_jpa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 * GET /users
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();

		return ResponseEntity.ok().body(users);
	}

	/**
	 * GET /users/{id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);

		return ResponseEntity.ok().body(user);
	}

	/**
	 * POST /users
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		user = service.insert(user);

		// Criando o URI com as informações de retorno
		URI uri = ServletUriComponentsBuilder
				// Da requisição atual,
				.fromCurrentRequest()
				// Seta o recurso para pegar o item criado
				.path("/{id}")
				// Passando o valor do parâmetro
				.buildAndExpand(user.getId())
				// Convertendo para um objeto do tipo URI
				.toUri();

		return ResponseEntity.created(uri).body(user);
	}

}
