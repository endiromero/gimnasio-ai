package Negocio;

import ViewModels.VistaEmpleado;

public abstract class Empleado {

	// Backing fields
	private int idEmpleado;
	private String nombre;
	private String telefono;
	private String mail;

	// Constructors
	public Empleado(String nombre, String telefono, String mail) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
	}

	public Empleado(int idEmpleado, String nombre, String telefono, String mail) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
	}

	public int getidEmpleado() {
		return idEmpleado;
	}

	public void setidEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public VistaEmpleado getView() {
		return new VistaEmpleado(idEmpleado, nombre, telefono, mail);
	}
}