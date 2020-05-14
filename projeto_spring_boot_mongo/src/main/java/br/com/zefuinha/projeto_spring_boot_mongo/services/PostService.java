package br.com.zefuinha.projeto_spring_boot_mongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.Post;
import br.com.zefuinha.projeto_spring_boot_mongo.repositories.PostRepository;
import br.com.zefuinha.projeto_spring_boot_mongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	// @Autowired faz com que o objeto seja instanciado automaticamente
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		// Retorna apenas se foi encontrado
		return post.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
}
