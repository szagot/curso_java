package br.com.zefuinha.projeto_spring_boot_jpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.User;
import br.com.zefuinha.projeto_spring_boot_jpa.repositories.UserRepository;

/**
 * implements CommandLineRunner fará com que o teste seja executado na linha de
 * comando (quando o projeto for iniciado)
 * 
 * O banco H2 dura apenas enquanto o sistema está ativo. Por isso todos os
 * testes são feitos na inicialização
 */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		/**
		 * Popula a tabela usuário com alguns usuários de teste
		 */
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// salvando no BD todos os objetos criados
		userRepository.saveAll(Arrays.asList(u1, u2));

	}

}
