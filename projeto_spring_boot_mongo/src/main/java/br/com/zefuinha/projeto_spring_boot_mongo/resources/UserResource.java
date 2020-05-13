package br.com.zefuinha.projeto_spring_boot_mongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
