package br.com.zefuinha.projeto_spring_boot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zefuinha.projeto_spring_boot_jpa.entities.OrderItem;

/**
 * Repositório
 * 
 * extends JpaRepository<Entidade, TipoDaChavePrimaria>
 * 
 * Não precisa da anottation \@Repository poqrque ele herda de JpaRepository
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	// O String Data JPA já possui uma implementação padrão com o necessário para
	// controlar a entidade
}
