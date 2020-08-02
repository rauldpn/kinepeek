package net.rdpn.kinepeek.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.rdpn.kinepeek.model.Servicio;

class ServicioDAOTest {

	private DriverManagerDataSource dataSource;
	private ServicioDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kinepeek");
		dataSource.setUsername("kinepeek");
		dataSource.setPassword("kinepeek");
		
		dao = new ServicioDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Date     date     = new Date();
		Servicio servicio = new Servicio(1, date, "Alejandro Cuevas", "Test JUnit de inserción de servicio");
		
		int result = dao.save(servicio);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Date     date     = new Date();
		Servicio servicio = new Servicio(1, 1, date, "Alejandro Cuevas", "Test JUnit de inserción de servicio - ACTUALIZADO");
		
		int result = dao.update(servicio);
		assertTrue(result > 0);	
	}

	@Test
	void testGet() {
		Integer  id = 1;
		Servicio servicio =  dao.get(id);
		
		if (servicio != null) {
			System.out.print(servicio);
		}
		
		assertNotNull(servicio);
	}

	@Test
	void testDelete() {
		Integer id = 1;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Servicio> listServicios = dao.list();
		
		for (Servicio aServicio : listServicios) {
			System.out.println(aServicio);
		}
		
		assertTrue(!listServicios.isEmpty());
	}
	
	@Test
	void testList2() {
		List<Servicio> listServicios = dao.list(1);
		
		for (Servicio aServicio : listServicios) {
			System.out.println(aServicio);
		}
		
		assertTrue(!listServicios.isEmpty());
	}

}
