package net.rdpn.kinepeek.model;

import java.util.Date;

public class Cliente {

	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FNacimiento;
	private String Email;
	private String Telefono;

	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nombre, String apellido, Date fNacimiento, String email, String telefono) {
		this(nombre, apellido, fNacimiento, email, telefono);
		this.Id          = id;
	}
	
	public Cliente(String nombre, String apellido, Date fNacimiento, String email, String telefono) {
		this.Nombre      = nombre;
		this.Apellido    = apellido;
		this.FNacimiento = fNacimiento;
		this.Email       = email;
		this.Telefono    = telefono;
	}	

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return this.Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public Date getFNacimiento() {
		return this.FNacimiento;
	}

	public void setFNacimiento(Date fNacimiento) {
		this.FNacimiento = fNacimiento;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [Id=" + Id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", FNacimiento=" + FNacimiento
				+ ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}
	
}
