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
	public VistaSocio (){
		
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
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
