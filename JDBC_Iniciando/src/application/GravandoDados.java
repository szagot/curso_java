package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class GravandoDados {

	public static void main(String[] args) {

		// Testando a conexão com o BD
		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			// Iniciando conexão
			conn = DB.getConnection();

			// Preparando classe para inserção de dados
			st = conn.prepareStatement(
					// SQL
					"INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)",
					// Parâmetro opcional para pegar o ID gerado
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Daniel Bispo");
			st.setString(2, "szagot@gmail.com");
			st.setDate(3, new Date(sdf.parse("03/10/1981").getTime()));
			st.setDouble(4, 3200.0);
			st.setInt(5, 4);

			// Faz a execução da query e retorna as linhas afetadas
			int qtRows = st.executeUpdate();

			// Se tiver alguma linha afetada
			if (qtRows > 0) {
				System.out.println("Linhas afetadas: " + qtRows);

				// Prepara a leitura de todos os IDs gerados
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					// Pega a primeira coluna, que contem o ID gerado
					int id = rs.getInt(1);
					System.out.println("ID do registro gerado: " + id);
				}
				rs.close();
				
			} else {
				System.out.println("Finalizado! Nenhuma linha afetada.");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ParseException e) {

			e.printStackTrace();

		} finally {

			// Fechando a conexão
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}
