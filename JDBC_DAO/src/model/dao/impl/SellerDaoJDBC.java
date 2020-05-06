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
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	// Para mapear (cookie) os registros, para evitar instâncias repetidas
	private Map<Integer, Department> deptMap;
	private Map<Integer, Seller> sellerMap;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
		this.deptMap = new HashMap<>();
		this.sellerMap = new HashMap<>();
	}

	@Override
	public void insert(Seller seller) {

		PreparedStatement st = null;
		try {

			st = conn.prepareStatement(
					"INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());
			st.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
			st.setDouble(4, seller.getBaseSalary());
			st.setInt(5, seller.getDepartment().getId());

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
					seller.setId(id);
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
	public void update(Seller seller) {

		PreparedStatement st = null;
		try {

			st = conn.prepareStatement(
					"UPDATE seller SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
							+ "WHERE Id = ?");

			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());
			st.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
			st.setDouble(4, seller.getBaseSalary());
			st.setInt(5, seller.getDepartment().getId());
			st.setInt(6, seller.getId());

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

			// Instanciando parâmetros da query
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
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Preparando a query
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id "
							+ "WHERE DepartmentId = ? ORDER BY Name");

			// Instanciando parâmetros da query
			st.setInt(1, department.getId());
			// Executa a query
			rs = st.executeQuery();

			// Lista e Mapa para verificação de departamento
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

			// Lista e Mapa para verificação de departamento
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
	 * Método auxiliar para declarar o departamento
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		// Verifica se o departamento já foi instanciado anteriormente
		int depId = rs.getInt("DepartmentId");
		Department department = deptMap.get(depId);

		// Se não foi instanciado
		if (department == null) {
			// Cria a instância
			department = new Department();
			department.setId(depId);
			department.setName(rs.getString("DepName"));

			// Adiciona ao map
			deptMap.put(depId, department);
		}

		return department;
	}

	/**
	 * Método auxiliar para instanciar o Seller
	 * 
	 * @param rs
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		// Verifica se o departamento já foi instanciado anteriormente
		int sellerId = rs.getInt("Id");
		Seller seller = sellerMap.get(sellerId);

		// Se não foi instanciado
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
