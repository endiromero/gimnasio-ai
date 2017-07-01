package ViewModels;

import java.util.Vector;

import Negocio.Abono;
import Negocio.AptoMedico;
import Negocio.Deporte;

public class VistaEmpleado {
	
	private int codigo;
	private String nombre;
	private String telefono;
	private String mail;
	private String puesto;
	
	public VistaEmpleado (int codigo, String nombre, String telefono, String mail, String puesto){
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.puesto = puesto;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}
	
	public String getPuesto() {
		return puesto;
	}

}