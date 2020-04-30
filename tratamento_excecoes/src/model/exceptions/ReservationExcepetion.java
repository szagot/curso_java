package model.exceptions;

/**
 * Se extender de:
 * 
 * - Exception, o compilador vai obrigar a tratar.
 * 
 * - RuntimeException, o compilador n�o obriga a usar um try..catch
 * 
 * @author szagot
 *
 */
public class ReservationExcepetion extends Exception {

	/**
	 * Declara��o de vers�o.
	 * 
	 * O "L" mai�sculo indica um inteiro do tipo "long"
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Isso permite que eu possa instanciar a minha exce��o j� passando uma msg pra
	 * ela
	 * 
	 * @param msg
	 */
	public ReservationExcepetion(String msg) {
		super(msg);
	}

}
