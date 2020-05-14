package br.com.zefuinha.projeto_spring_boot_mongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.Post;
import br.com.zefuinha.projeto_spring_boot_mongo.resources.util.URL;
import br.com.zefuinha.projeto_spring_boot_mongo.services.PostService;

/**
 * Recursos para usuários
 */

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	/**
	 * GET /posts/{id}
	 * 
	 * @param text
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findbyId(@PathVariable String id) {
		Post post = service.findById(id);

		// Resposta completa com headers e body
		return ResponseEntity.ok().body(post);
	}

	/**
	 * GET /posts/titlesearch?text=texto%20procurado
	 * 
	 * @param text
	 * @return
	 */
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findbyTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		// Usa a classe auxiliar para decodificar o texto
		text = URL.decodeParam(text);

		List<Post> posts = service.findByTitle(text);

		// Resposta completa com headers e body
		return ResponseEntity.ok().body(posts);
	}

}
