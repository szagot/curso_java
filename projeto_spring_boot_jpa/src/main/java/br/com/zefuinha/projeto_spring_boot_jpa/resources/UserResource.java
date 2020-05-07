package br.com.zefuinha.projeto_spring_boot_jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.User;

/**
 * Mapeamento (URI) para usuários
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		// TODO: testando localhost:8080/users
		User user = new User(1L, "Maria", "maria@gmail.com", "997014416", "12345");

		return ResponseEntity.ok().body(user);
	}

}
