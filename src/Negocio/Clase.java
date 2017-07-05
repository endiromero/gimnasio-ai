package Negocio;

import java.util.Date;

import ViewModels.VistaClase;

public class Clase {

	// Backing fields
	private int codigo;
	private Date fecha;
	private Profesor profesor;
	
	// Constructors
	public Clase(int codigo, Date fecha) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
	}
	
	public Clase(Date fecha) {
		super();
		this.fecha = fecha;
	}
	
	public Clase() {
		super();
	}
	
	
	// Properties
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	// View
	public VistaClase getView(){
		return new VistaClase(codigo, fecha);
	}
	
	
}
