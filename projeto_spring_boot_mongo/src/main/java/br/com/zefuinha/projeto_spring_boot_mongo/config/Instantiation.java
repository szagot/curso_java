package br.com.zefuinha.projeto_spring_boot_mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.Post;
import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;
import br.com.zefuinha.projeto_spring_boot_mongo.dto.AuthorDTO;
import br.com.zefuinha.projeto_spring_boot_mongo.repositories.PostRepository;
import br.com.zefuinha.projeto_spring_boot_mongo.repositories.UserRepository;

/**
 * Classe para comandos ao inicializar o projeto
 */
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Apagando dados existentes
		postRepository.deleteAll();
		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para são paulo, abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));

		// Associando posts
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
