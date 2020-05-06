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

	// Para mapear (cookie) os registros, para evitar inst�ncias repetidas
	private Map<Integer, Department> deptMap;
	private Map<Integer, Seller> sellerMap;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
		this.deptMap = new HashMap<>();
		this.sellerMap = new HashMap<>();
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

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Preparando a query
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id "
							+ "ORDER BY Name");

			// Executa a query
			rs = st.executeQuery();

			// Lista e Mapa para verifica��o de departamento
			List<Seller> sellers = new ArrayList<>();

			// Percorre pelos resultados
			while (rs.next()) {
				// Adiciona o seller com o departamento
				sellers.add(instantiateSeller(rs, instantiateDepartment(rs)));
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

			// Percorre pelos resultados
			while (rs.next()) {
				// Adiciona o seller com o departamento
				sellers.add(instantiateSeller(rs, instantiateDepartment(rs)));
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

	/**
	 * M�todo auxiliar para declarar o departamento
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		// Verifica se o departamento j� foi instanciado anteriormente
		int depId = rs.getInt("DepartmentId");
		Department department = deptMap.get(depId);

		// Se n�o foi instanciado
		if (department == null) {
			// Cria a inst�ncia
			department = new Department();
			department.setId(depId);
			department.setName(rs.getString("DepName"));

			// Adiciona ao map
			deptMap.put(depId, department);
		}

		return department;
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
		// Verifica se o departamento j� foi instanciado anteriormente
		int sellerId = rs.getInt("Id");
		Seller seller = sellerMap.get(sellerId);

		// Se n�o foi instanciado
		if (seller == null) {
			seller = new Seller();
			seller.setId(sellerId);
			seller.setName(rs.getString("Name"));
			seller.setEmail(rs.getString("Email"));
			seller.setBaseSalary(rs.getDouble("BaseSalary"));
			seller.setBirthDate(rs.getDate("BirthDate"));
			seller.setDepartment(department);

			// Adiciona ao map
			sellerMap.put(sellerId, seller);
		}

		return seller;
	}
}
