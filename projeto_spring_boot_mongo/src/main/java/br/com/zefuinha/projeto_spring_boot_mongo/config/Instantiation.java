package br.com.zefuinha.projeto_spring_boot_mongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;
import br.com.zefuinha.projeto_spring_boot_mongo.repositories.UserRepository;

/**
 * Classe para comandos ao inicializar o projeto
 */
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		// Apagando usuários existentes
		userRepository.deleteAll();

		// Instanciando dados iniciais
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		// Salvando usuários de teste
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

	}

}
