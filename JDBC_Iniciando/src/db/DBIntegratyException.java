package db;

/**
 * Exce��o para integridade referencial 
 *
 */
public class DBIntegratyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBIntegratyException(String msg) {
		super(msg);
	}

}
