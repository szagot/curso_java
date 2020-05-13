package br.com.zefuinha.projeto_spring_boot_mongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;

/**
 * Recursos para usuários
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		// TODO: teste
		User maria = new User(1, "Maria Silva", "maria@gmail.com");
		User alex = new User(2, "Alex Green", "alex@gmail.com");

		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(maria, alex));

		// Resposta completa com headers e body
		return ResponseEntity.ok().body(users);

	}

}
