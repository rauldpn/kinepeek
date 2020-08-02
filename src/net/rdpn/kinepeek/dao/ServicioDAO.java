package net.rdpn.kinepeek.dao;

import java.util.List;
import net.rdpn.kinepeek.model.Servicio;

public interface ServicioDAO {
	public int           save(Servicio servicio);
	public int           update(Servicio servicio);
	public Servicio      get(Integer id);
	public int           delete(Integer id);
	public List<Servicio> list();
	public List<Servicio> list(Integer id);
}
