package br.com.zefuinha.projeto_spring_boot_mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zefuinha.projeto_spring_boot_mongo.domain.User;
import br.com.zefuinha.projeto_spring_boot_mongo.repositories.UserRepository;

@Service
public class UserService {

	// @Autowired faz com que o objeto seja instanciado automaticamente
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
}
