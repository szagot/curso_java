package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Daniel", "daniel@gmail.com");
		Pessoa p3 = new Pessoa(null, "Alini", "alini@gmail.com");

		// Inicia o gerencidor de conexão e acesso a dados do BD
		// (vide: /JPAMaven/src/main/resources/META-INF/persistence.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// Inicia a transação
		em.getTransaction().begin();
		// Persiste os dados no BD
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		// Salva os objetos persistidos no BD
		em.getTransaction().commit();

		// Mostra os dados
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		// Fecha as conexões
		em.close();
		emf.close();
	}

}
