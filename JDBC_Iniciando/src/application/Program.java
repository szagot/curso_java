package application;

import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {

		// Testando a conexão com o BD
		Connection db = DB.getConnection();

		// Fechando a conexão
		DB.closeConnection();

	}

}
