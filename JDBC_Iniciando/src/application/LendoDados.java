package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class LendoDados {

	public static void main(String[] args) {

		// Testando a conexão com o BD
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			// Iniciando conexão
			conn = DB.getConnection();

			// Preparando classe para execuções de querys
			st = conn.createStatement();

			// Executando query
			rs = st.executeQuery("SELECT Id, Name FROM department ORDER BY Name");

			// Lendo retorno
			while (rs.next()) {
				// Mostrando campos na tela
				System.out.println(rs.getInt("Id") + " - " + rs.getString("Name"));
			}

		} catch (SQLException e) {

			e.getStackTrace();

		} finally {

			// Fechando a conexão
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}
