package model.exceptions;

/**
 * Se extender de:
 * 
 * - Exception, o compilador vai obrigar a tratar.
 * 
 * - RuntimeException, o compilador não obriga a usar um try..catch
 * 
 * @author szagot
 *
 */
public class ReservationExcepetion extends Exception {

	/**
	 * Declaração de versão.
	 * 
	 * O "L" maiúsculo indica um inteiro do tipo "long"
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Isso permite que eu possa instanciar a minha exceção já passando uma msg pra
	 * ela
	 * 
	 * @param msg
	 */
	public ReservationExcepetion(String msg) {
		super(msg);
	}

}
