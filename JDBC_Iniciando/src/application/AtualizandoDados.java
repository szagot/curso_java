package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class AtualizandoDados {

	public static void main(String[] args) {

		// Testando a conexão com o BD
		Connection conn = null;
		PreparedStatement st = null;

		try {

			// Iniciando conexão
			conn = DB.getConnection();

			// Preparando classe para inserção de dados: Aumenta o salário em 10%
			st = conn.prepareStatement(
					// SQL
					"UPDATE seller SET BaseSalary = ROUND(BaseSalary * ?, 2) WHERE DepartmentId = ?");

			// 10%
			st.setDouble(1, 1.1);
			// Departamento 2 
			st.setInt(2, 2);

			// Faz a execução da query e retorna as linhas afetadas
			int qtRows = st.executeUpdate();

			System.out.println("Finalizado! Quantidade de registros afetados: " + qtRows);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			// Fechando a conexão
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}
