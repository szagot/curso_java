package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class ProgramPegaDados {

	public static void main(String[] args) {

		// Inicia o gerencidor de conexão e acesso a dados do BD
		// (vide: /JPAMaven/src/main/resources/META-INF/persistence.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// Pega o registro de ID 2
		Pessoa p = em.find(Pessoa.class, 2);

		// Mostrando
		System.out.println();
		System.out.println(p);
		System.out.println();

		// Fecha as conexões
		em.close();
		emf.close();
	}

}
