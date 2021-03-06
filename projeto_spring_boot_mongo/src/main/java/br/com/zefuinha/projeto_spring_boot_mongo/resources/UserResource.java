package br.com.zefuinha.projeto_spring_boot_mongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.Post;
import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;
import br.com.zefuinha.projeto_spring_boot_mongo.dto.UserDTO;
import br.com.zefuinha.projeto_spring_boot_mongo.services.UserService;

/**
 * Recursos para usuários
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> user = service.findAll();

		// Converte para DTO
		List<UserDTO> userDTO = user.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		// Resposta completa com headers e body
		return ResponseEntity.ok().body(userDTO);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findbyId(@PathVariable String id) {

		User user = service.findById(id);

		// Resposta completa com headers e body
		return ResponseEntity.ok().body(new UserDTO(user));

	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {

		User user = service.fromDTO(userDTO);
		user = service.insert(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		// Resposta headers 201
		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		service.delete(id);

		// Resposta completa com headers e body
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {

		User user = service.fromDTO(userDTO);
		user.setId(id);
		user = service.update(user);

		// Resposta completa com headers e body
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {

		User user = service.findById(id);

		// Resposta completa com headers e body
		return ResponseEntity.ok().body(user.getPosts());

	}

}
