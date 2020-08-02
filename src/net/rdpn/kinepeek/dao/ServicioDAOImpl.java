package net.rdpn.kinepeek.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.rdpn.kinepeek.model.Servicio;

public class ServicioDAOImpl implements ServicioDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ServicioDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	@Override
	public int save(Servicio s) {
		
		String sql = "INSERT INTO Servicios (ClienteId, Fecha, Fisioterapeuta, Descripcion) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, s.getClienteId(), s.getFecha(), s.getFisioterapeuta(), s.getDescripcion());

	}

	@Override
	public int update(Servicio s) {

		String sql = "UPDATE Servicios SET ClienteId = ?, Fecha = ?, Fisioterapeuta = ?, Descripcion = ? WHERE Id = ?";
		return jdbcTemplate.update(sql, s.getClienteId(), s.getFecha(), s.getFisioterapeuta(), s.getDescripcion(), s.getId());
		
	}

	@Override
	public Servicio get(Integer id) {
		String sql = "SELECT * FROM Servicios WHERE id = " + id;
		
		ResultSetExtractor<Servicio> extractor = new ResultSetExtractor<Servicio>() {
			
			@Override
			public Servicio extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if (rs.next()) {
					Integer clienteId      = rs.getInt("ClienteId");
					Date    fecha          = rs.getDate("Fecha");
					String  fisioterapeuta = rs.getString("Fisioterapeuta");
					String  descripcion    = rs.getString("Descripcion");
					
					return new Servicio(id, clienteId, fecha, fisioterapeuta, descripcion);
				}
				
				return null;
				
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Servicios where id = " + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Servicio> list() {
		String sql = "SELECT * FROM Servicios";
		
		RowMapper<Servicio> rowMapper = new RowMapper<Servicio>() {

			@Override
			public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id             = rs.getInt("id");
				Integer clienteId      = rs.getInt("ClienteId");
				Date    fecha          = rs.getDate("Fecha");
				String  fisioterapeuta = rs.getString("Fisioterapeuta");
				String  descripcion    = rs.getString("Descripcion");
				
				return new Servicio(id, clienteId, fecha, fisioterapeuta, descripcion);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public List<Servicio> list(Integer id) {
		String sql = "SELECT * FROM Servicios WHERE ClienteId = " + id + " ORDER BY Fecha DESC";
		
		RowMapper<Servicio> rowMapper = new RowMapper<Servicio>() {

			@Override
			public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id             = rs.getInt("id");
				Integer clienteId      = rs.getInt("ClienteId");
				Date    fecha          = rs.getDate("Fecha");
				String  fisioterapeuta = rs.getString("Fisioterapeuta");
				String  descripcion    = rs.getString("Descripcion");
				
				return new Servicio(id, clienteId, fecha, fisioterapeuta, descripcion);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
