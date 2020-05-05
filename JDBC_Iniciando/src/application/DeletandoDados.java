package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DBIntegratyException;

public class DeletandoDados {

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
					"DELETE FROM department WHERE Id = ?");

			// ID
			st.setInt(1, 2);

			// Faz a execução da query e retorna as linhas afetadas
			int qtRows = st.executeUpdate();

			System.out.println("Finalizado! Quantidade de registros afetados: " + qtRows);

		} catch (SQLException e) {

			// Lançando uma exceção de exemplo para quando se tentar apagar um registro com
			// chave estrangeira comprometida
			throw new DBIntegratyException("Erro ao tentar apagar registro: " + e.getMessage());

		} finally {

			// Fechando a conexão
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}
