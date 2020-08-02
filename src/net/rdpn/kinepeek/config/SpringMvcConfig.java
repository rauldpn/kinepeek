package net.rdpn.kinepeek.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.rdpn.kinepeek.dao.ClienteDAO;
import net.rdpn.kinepeek.dao.ClienteDAOImpl;
//import net.rdpn.kinepeek.dao.ServicioDAO;
//import net.rdpn.kinepeek.dao.ServicioDAOImpl;
import net.rdpn.kinepeek.dao.ServicioDAO;
import net.rdpn.kinepeek.dao.ServicioDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.rdpn.kinepeek")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kinepeek");
		dataSource.setUsername("kinepeek");
		dataSource.setPassword("kinepeek");
		
		return dataSource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

	@Bean
	public ClienteDAO getClienteDAO() {
		return new ClienteDAOImpl(getDataSource());
	}

	@Bean
	public ServicioDAO getServicioDAO() {
		return new ServicioDAOImpl(getDataSource());
	}
	
}
