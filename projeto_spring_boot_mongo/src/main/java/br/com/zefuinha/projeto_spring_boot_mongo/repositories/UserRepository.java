package br.com.zefuinha.projeto_spring_boot_mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
