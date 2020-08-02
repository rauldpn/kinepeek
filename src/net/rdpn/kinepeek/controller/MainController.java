package net.rdpn.kinepeek.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.rdpn.kinepeek.dao.ClienteDAO;
import net.rdpn.kinepeek.dao.ServicioDAO;
import net.rdpn.kinepeek.model.Cliente;
import net.rdpn.kinepeek.model.Servicio;

@Controller
public class MainController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value = "/")
	public ModelAndView listCliente(ModelAndView model) {
		List<Cliente> clientes = clienteDAO.list();
		model.addObject("clientes", clientes);
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView nuevoCliente(ModelAndView model) {
		Cliente nuevoCliente = new Cliente();
		model.addObject("cliente", nuevoCliente);
		model.setViewName("cliente_form");		

		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCliente(@ModelAttribute Cliente cliente) {
		
		if (cliente.getId() == null) {
			clienteDAO.save(cliente);	
		} else {
			clienteDAO.update(cliente);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCliente(HttpServletRequest request) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = clienteDAO.get(id);
		
		ModelAndView model = new ModelAndView("cliente_form");
		model.addObject("cliente", cliente);
		
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCliente(@RequestParam Integer id) {
		clienteDAO.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	/////////////////////////////////////
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public ModelAndView deleteCliente(HttpServletRequest request) {
		
		Integer clienteId = Integer.parseInt(request.getParameter("id"));
		List<Servicio> servicios = servicioDAO.list(clienteId);
		
		ModelAndView model = new ModelAndView("cliente_file");
		model.addObject("servicios", servicios);
		
		return model;
	}
	
	@RequestMapping(value = "/newService", method = RequestMethod.GET)
	public ModelAndView nuevoServicio(HttpServletRequest request) {	
		
		Integer clienteId = Integer.parseInt(request.getParameter("clienteId"));
		Servicio nuevoServicio = new Servicio();
		nuevoServicio.setClienteId(clienteId);
		
		ModelAndView model = new ModelAndView("servicio_form");
		model.addObject("servicio", nuevoServicio);
		
		return model;
	}
	
	@RequestMapping(value = "/saveService", method = RequestMethod.POST)
	public ModelAndView saveServicio(@ModelAttribute Servicio servicio) {
		
		if (servicio.getId() == null) {
			servicioDAO.save(servicio);	
		} else {
			servicioDAO.update(servicio);	
		}
		
		return new ModelAndView("redirect:/file?id=" + servicio.getClienteId());
	}
	
	@RequestMapping(value = "/editService", method = RequestMethod.GET)
	public ModelAndView editService(HttpServletRequest request) {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Servicio servicio = servicioDAO.get(id);
		
		ModelAndView model = new ModelAndView("servicio_form");
		model.addObject("servicio", servicio);
		
		return model;
	}
	
	@RequestMapping(value = "/deleteService", method = RequestMethod.GET)
	public ModelAndView deleteService(@RequestParam Integer id) {
		Servicio servicio = servicioDAO.get(id);
		Integer  clientId = servicio.getClienteId();
		servicioDAO.delete(id);
		return new ModelAndView("redirect:/file?id=" + clientId);
	}
	
}
