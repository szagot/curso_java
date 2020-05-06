package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Preparando a query
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id "
							+ "WHERE seller.Id = ?");

			// Instanciando par�metros da query
			st.setInt(1, id);
			// Executa a query
			rs = st.executeQuery();

			// Verifica se veio algum resultado
			if (rs.next()) {
				// Retorna o seller com o departamento
				return instantiateSeller(rs, instantiateDepartment(rs));
			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

		return null;
	}

	/**
	 * M�todo auxiliar para instanciar o Seller
	 * 
	 * @param rs
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setDepartment(department);

		return seller;
	}

	/**
	 * M�todo auxiliar para declarar o departamento
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));

		return department;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Preparando a query
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id "
							+ "WHERE DepartmentId = ? ORDER BY Name");

			// Instanciando par�metros da query
			st.setInt(1, department.getId());
			// Executa a query
			rs = st.executeQuery();

			// Lista e Mapa para verifica��o de departamento
			List<Seller> sellers = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();

			// Percorre pelos resultados
			while (rs.next()) {
				// Verifica se o departamento j� foi instanciado anteriormente
				int depId = rs.getInt("DepartmentId");
				Department dep = map.get(depId);

				// Se n�o foi instanciado
				if (dep == null) {
					// Cria a inst�ncia
					dep = instantiateDepartment(rs);
					// Adiciona ao map
					map.put(depId, dep);
				}

				// Adiciona o seller com o departamento
				sellers.add(instantiateSeller(rs, dep));
			}

			// Retorna todos os sellers encontrados (ou uma lista vazia)
			return sellers;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
