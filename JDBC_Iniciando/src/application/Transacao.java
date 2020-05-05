package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

/**
 * Transa��es garantem que toda a sequencia ser� realizada.
 * 
 * Se houver falha em algum processo, � feito um rollback em todos os processos.
 * Caso contr�rio, a transa��o � comitada
 */
public class Transacao {

	public static void main(String[] args) {

		// Testando a conex�o com o BD
		Connection conn = null;
		Statement st = null;

		try {

			// Iniciando conex�o
			conn = DB.getConnection();

			// Impede que a transa��o seja confirmada automaticamente
			conn.setAutoCommit(false);

			st = conn.createStatement();

			// Executa a primeira query da transa��o
			int qtRows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 5000 WHERE DepartmentId = 2");

			// Simula um erro
			//if (true) {
			//	throw new SQLException("Fake error");
			//}

			// Executa a segunda query da transa��o
			int qtRows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 6000 WHERE DepartmentId = 1");

			// Confirma o t�rmino da transa��o. Se algo der errado e n�o chegar aqui, a
			// transa��o n�o ser� confirmada e os dados n�o ser�o alterados
			conn.commit();

			System.out.printf("Finalizado!\nQuery 1: %d afetados\nQuery 2: %d afetados", qtRows1, qtRows2);

		} catch (SQLException e) {
			// Se houve uma exce��o, faz o rollback da transa��o
			try {
				conn.rollback();

				// Informa a aplica��o que houve um rollback
				throw new DBException("Transa��o n�o conclu�da! Rollback realizado devido ao erro: " + e.getMessage());

			} catch (SQLException e1) {
				// Se houver um erro no rollback
				throw new DBException(
						"Transa��o n�o conclu�da, e ocorreu o seguinte erro ao tentar realizar o Rollback: "
								+ e.getMessage());
			}

		} finally {

			// Fechando a conex�o
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}
