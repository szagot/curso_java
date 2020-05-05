package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

/**
 * Transações garantem que toda a sequencia será realizada.
 * 
 * Se houver falha em algum processo, é feito um rollback em todos os processos.
 * Caso contrário, a transação é comitada
 */
public class Transacao {

	public static void main(String[] args) {

		// Testando a conexão com o BD
		Connection conn = null;
		Statement st = null;

		try {

			// Iniciando conexão
			conn = DB.getConnection();

			// Impede que a transação seja confirmada automaticamente
			conn.setAutoCommit(false);

			st = conn.createStatement();

			// Executa a primeira query da transação
			int qtRows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 5000 WHERE DepartmentId = 2");

			// Simula um erro
			//if (true) {
			//	throw new SQLException("Fake error");
			//}

			// Executa a segunda query da transação
			int qtRows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 6000 WHERE DepartmentId = 1");

			// Confirma o término da transação. Se algo der errado e não chegar aqui, a
			// transação não será confirmada e os dados não serão alterados
			conn.commit();

			System.out.printf("Finalizado!\nQuery 1: %d afetados\nQuery 2: %d afetados", qtRows1, qtRows2);

		} catch (SQLException e) {
			// Se houve uma exceção, faz o rollback da transação
			try {
				conn.rollback();

				// Informa a aplicação que houve um rollback
				throw new DBException("Transação não concluída! Rollback realizado devido ao erro: " + e.getMessage());

			} catch (SQLException e1) {
				// Se houver um erro no rollback
				throw new DBException(
						"Transação não concluída, e ocorreu o seguinte erro ao tentar realizar o Rollback: "
								+ e.getMessage());
			}

		} finally {

			// Fechando a conexão
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}
