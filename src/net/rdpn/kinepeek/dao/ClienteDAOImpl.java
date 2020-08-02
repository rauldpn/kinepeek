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

}
