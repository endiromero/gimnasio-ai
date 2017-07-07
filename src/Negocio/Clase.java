package Negocio;

import ViewModels.VistaClase;

public class Clase {

	// Backing fields
	private int codigo;
	private String dia;
	private String hora;
	private Profesor profesor;

	// Constructors
	public Clase(int codigo, String dia, String hora) {
		super();
		this.codigo = codigo;
		this.dia = dia;
		this.hora = hora;
	}

	public Clase(String dia, String hora) {
		super();
		this.dia = dia;
		this.hora = hora;
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

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	// View
	public VistaClase getView() {
		return new VistaClase(codigo, dia, hora);
	}

}
