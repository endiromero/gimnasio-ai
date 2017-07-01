package ViewModels;

import java.util.Vector;

import Negocio.Abono;
import Negocio.AptoMedico;
import Negocio.Deporte;

public class VistaSocio {
	
	private int idSocio;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	
	public VistaSocio (int idSocio, String nombre, String domicilio, String telefono, String mail){
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

}
