package net.rdpn.kinepeek.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Date;
import java.util.List;

import net.rdpn.kinepeek.model.Cliente;

class ClienteDAOTest {

	private DriverManagerDataSource dataSource;
	private ClienteDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kinepeek");
		dataSource.setUsername("kinepeek");
		dataSource.setPassword("kinepeek");
		
		dao = new ClienteDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Date    date    = new Date();
		Cliente cliente = new Cliente("John", "Doe", date, "johndoe@email.com", "9982112233");
		
		int result = dao.save(cliente);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Date    date    = new Date();
		Cliente cliente = new Cliente(2, "John", "Doe", date, "johndoe@email.com", "9982112299");
		
		int result = dao.update(cliente);
		assertTrue(result > 0);				
	}

	@Test
	void testGet() {
		Integer id = 1;
		Cliente cliente =  dao.get(id);
		
		if (cliente != null) {
			System.out.print(cliente);
		}
		
		assertNotNull(cliente);
	}
/*
	@Test
	void testDelete() {
		Integer id = 1;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}
*/

	@Test
	void testList() {
		List<Cliente> listClientes = dao.list();
		
		for (Cliente aCliente : listClientes) {
			System.out.println(aCliente);
		}
		
		assertTrue(!listClientes.isEmpty());
	}

}
