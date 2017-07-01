package Negocio;

import ViewModels.VistaEmpleado;
import ViewModels.VistaSocio;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Empleado {
	
	// Backing fields 
	private int codigo;
	private String nombre;
	private String telefono;
	private String mail;
	private String puesto;
	
	// Constructors
	public Empleado(String nombre, String telefono, String mail, String puesto) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.puesto = puesto;
	}
	
	public Empleado(int codigo, String nombre, String telefono, String mail, String puesto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.puesto = puesto;
	}
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	// Properties
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	//View
	public VistaEmpleado getView(){
		return new VistaEmpleado(codigo, nombre, telefono, mail, puesto);
	}

}