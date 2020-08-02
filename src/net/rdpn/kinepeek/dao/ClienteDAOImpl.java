package net.rdpn.kinepeek.dao;

import net.rdpn.kinepeek.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ClienteDAOImpl implements ClienteDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ClienteDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Cliente c) {
		
		String sql = "INSERT INTO Clientes (Nombre, Apellido, Fecha_Nacimiento, Email, Telefono) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getNombre(), c.getApellido(), c.getFNacimiento(), c.getEmail(), c.getTelefono());

	}

	@Override
	public int update(Cliente c) {

		String sql = "UPDATE Clientes SET Nombre = ?, Apellido = ?, Fecha_Nacimiento = ?, Email = ?, Telefono = ? WHERE Id = ?";
		return jdbcTemplate.update(sql, c.getNombre(), c.getApellido(), c.getFNacimiento(), c.getEmail(), c.getTelefono(), c.getId());

	}

	@Override
	public Cliente get(Integer id) {
	
		String sql = "SELECT * FROM Clientes WHERE id = " + id;
		
		ResultSetExtractor<Cliente> extractor = new ResultSetExtractor<Cliente>() {
			
			@Override
			public Cliente extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if (rs.next()) {
					String nombre      = rs.getString("Nombre");
					String apellido    = rs.getString("Apellido");
					Date   fnacimiento = rs.getDate("Fecha_Nacimiento");
					String email       = rs.getString("Email");
					String telefono    = rs.getString("Telefono");
					
					return new Cliente(id, nombre, apellido, fnacimiento, email, telefono);
				}
				
				return null;
				
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Clientes where id = " + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Cliente> list() {
		String sql = "SELECT * FROM Clientes";
		
		RowMapper<Cliente> rowMapper = new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id          = rs.getInt("id");
				String  nombre      = rs.getString("Nombre");
				String  apellido    = rs.getString("Apellido");
				Date    fnacimiento = rs.getDate("Fecha_Nacimiento");
				String  email       = rs.getString("Email");
				String  telefono    = rs.getString("Telefono");
				
				return new Cliente(id, nombre, apellido, fnacimiento, email, telefono);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
