package net.rdpn.kinepeek.dao;

import java.util.List;
import net.rdpn.kinepeek.model.Cliente;

public interface ClienteDAO {

	public int           save(Cliente cliente);
	public int           update(Cliente cliente);
	public Cliente       get(Integer id);
	public int           delete(Integer id);
	public List<Cliente> list();
	
}
