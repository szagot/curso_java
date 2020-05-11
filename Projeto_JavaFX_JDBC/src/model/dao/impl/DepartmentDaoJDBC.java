package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBException;
import db.DBIntegratyException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	// Para mapear (cookie) os registros, para evitar instâncias repetidas
	private Map<Integer, Department> deptMap;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
		this.deptMap = new HashMap<>();
	}

	@Override
	public void insert(Department department) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, department.getName());

			// Atualiza o BD e salva os registros afetados
			int rowsAffected = st.executeUpdate();

			// Pega as chaves geradas se houveram inserções
			if (rowsAffected > 0) {

				ResultSet rs = st.getGeneratedKeys();
				// Confirma a existência de registro
				if (rs.next()) {
					// Pega o registro da inserção
					int id = rs.getInt(1);
					// Salva o id no objeto informado
					department.setId(id);
				}
				DB.closeResultSet(rs);

			} else {

				// Nenhuma linha alterou???
				throw new DBException("Erro inesperado! Nenhuma linha foi afetada");

			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Department department) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");

			st.setString(1, department.getName());
			st.setInt(2, department.getId());

			// Atualiza o BD e salva os registros afetados
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			// Preparando a query
			st = conn.prepareStatement("DELETE FROM department WHERE department.Id = ?");
			st.setInt(1, id);

			// Executando deleção
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DBIntegratyException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Preparando a query
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");

			// Instanciando parâmetros da query
			st.setInt(1, id);
			// Executa a query
			rs = st.executeQuery();

			// Verifica se veio algum resultado
			if (rs.next()) {
				// Retorna o departamento
				return instantiateDepartment(rs);
			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

		return null;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Preparando a query
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");

			// Executa a query
			rs = st.executeQuery();

			// Lista e Mapa para verificação de departamento
			List<Department> departments = new ArrayList<>();

			// Percorre pelos resultados
			while (rs.next()) {
				// Adiciona o department com o departamento
				departments.add(instantiateDepartment(rs));
			}

			// Retorna todos os departments encontrados (ou uma lista vazia)
			return departments;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	/**
	 * Método auxiliar para declarar o departamento
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		// Verifica se o departamento já foi instanciado anteriormente
		int depId = rs.getInt("Id");
		Department department = deptMap.get(depId);

		// Se não foi instanciado
		if (department == null) {
			// Cria a instância
			department = new Department();
			department.setId(depId);
			department.setName(rs.getString("Name"));

			// Adiciona ao map
			deptMap.put(depId, department);
		}

		return department;
	}
}
