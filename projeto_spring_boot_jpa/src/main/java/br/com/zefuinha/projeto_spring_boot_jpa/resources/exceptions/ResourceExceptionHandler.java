package br.com.zefuinha.projeto_spring_boot_jpa.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.zefuinha.projeto_spring_boot_jpa.services.exceptions.ResourceNotFoundException;

/**
 * Intercepta as exceções para que possamos tratar
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Esse método intercepta qualquer exceção do tipo informado em ExceptionHandler
	 * e trata aqui
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(
				// Time do erro
				Instant.now(),
				// Status do erro
				status.value(),
				// Erro
				error,
				// Mensagem
				e.getMessage(),
				// URL (path)
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

}
