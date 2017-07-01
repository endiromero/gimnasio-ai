package Negocio;

import java.util.Vector;

import ViewModels.VistaSocio;

public class Socio {
	
	private int idSocio;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private AptoMedico aptoMedico;
	private Abono abono;
	private Vector <Deporte> deportes;
	
	
	public Socio(String nombre, String domicilio, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	public Socio(int idSocio, String nombre, String domicilio, String telefono, String mail) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	public Socio() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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
	public AptoMedico getAptoMedico() {
		return aptoMedico;
	}
	public void setAptoMedico(AptoMedico aptoMedico) {
		this.aptoMedico = aptoMedico;
	}
	public Abono getAbono() {
		return abono;
	}
	public void setAbono(Abono abono) {
		this.abono = abono;
	}
	public Vector<Deporte> getDeportes() {
		return deportes;
	}
	public void setDeportes(Vector<Deporte> deportes) {
		this.deportes = deportes;
	}
	
	public VistaSocio getView(){
		return new VistaSocio(idSocio, nombre, domicilio, telefono, mail);
	}

}
