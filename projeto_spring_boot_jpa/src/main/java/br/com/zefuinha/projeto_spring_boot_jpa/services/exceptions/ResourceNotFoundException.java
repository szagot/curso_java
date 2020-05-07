package br.com.zefuinha.projeto_spring_boot_jpa.services.exceptions;

/**
 * Exceção para recurso não encontrado
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Recurso não encontrado. ID " + id);
	}

}
