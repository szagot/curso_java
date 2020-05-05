package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe para obter e realizar uma conex�o com o banco
 */
public class DB {

	private static Connection conn = null;

	/**
	 * Retorna a conex�o com o banco
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		// Se ainda n�o conectou
		if (conn == null) {
			try {

				// Pega as propriedades
				Properties properties = loadProperties();

				// Pega o valor da propriedade URL
				String url = properties.getProperty("dburl");

				// Pega o driver de conex�o
				conn = DriverManager.getConnection(url, properties);

			} catch (SQLException e) {

				throw new DBException(e.getMessage());

			}
		}

		return conn;
	}

	/**
	 * Fecha a conex�o com o banco de dados
	 */
	public static void closeConnection() {
		// A conex�o foi aberta?
		if (conn != null) {
			try {

				conn.close();

			} catch (SQLException e) {

				throw new DBException(e.getMessage());

			}

			conn = null;
		}
	}

	/**
	 * Pega as propriedades da conex�o
	 * 
	 * @return
	 */
	private static Properties loadProperties() {

		// Inicia um stream para arquivo
		try (FileInputStream fs = new FileInputStream("db.properties")) {

			// Pega as propriedades em um stream e retorna
			Properties properties = new Properties();
			properties.load(fs);

			return properties;

		} catch (IOException e) {

			throw new DBException(e.getMessage());

		}

	}

}
