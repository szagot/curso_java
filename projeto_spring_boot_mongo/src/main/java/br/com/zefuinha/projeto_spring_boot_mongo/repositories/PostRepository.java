package br.com.zefuinha.projeto_spring_boot_mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	/**
	 * Query Methods
	 * 
	 * O próprio spring monta a consulta pelo padrão findBy<campo><filtro>(<param>)
	 * 
	 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	 * https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	 * 
	 * @param text
	 * @return
	 */
	List<Post> findByTitleContainingIgnoreCase(String text);

}
