package br.com.zefuinha.projeto_spring_boot_mongo.services.exceptions;

/**
 * Exceção para quando não existir um registro com os parâmetros informados
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
