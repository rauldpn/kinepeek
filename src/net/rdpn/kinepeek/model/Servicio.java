package net.rdpn.kinepeek.model;

import java.util.Date;

public class Servicio {
	
	private Integer Id;
	private Integer ClienteId;
	private Date    Fecha;
	private String  Fisioterapeuta;
	private String  Descripcion;
	
	public Servicio() {
		
	}
	
	public Servicio(Integer id, Integer clienteId, Date fecha, String fisioterapeuta, String descripcion) {
		this(clienteId, fecha, fisioterapeuta, descripcion);
		this.Id = id;
	}
	
	public Servicio(Integer clienteId, Date fecha, String fisioterapeuta, String descripcion) {
		this.ClienteId = clienteId;
		this.Fecha = fecha;
		this.Fisioterapeuta = fisioterapeuta;
		this.Descripcion = descripcion;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getClienteId() {
		return ClienteId;
	}

	public void setClienteId(Integer clienteId) {
		ClienteId = clienteId;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getFisioterapeuta() {
		return Fisioterapeuta;
	}

	public void setFisioterapeuta(String fisioterapeuta) {
		Fisioterapeuta = fisioterapeuta;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Servicio [Id=" + Id + ", ClienteId=" + ClienteId + ", Fecha=" + Fecha + ", Fisioterapeuta="
				+ Fisioterapeuta + ", Descripcion=" + Descripcion + "]";
	}

}
