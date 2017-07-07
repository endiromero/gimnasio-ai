package Negocio;

import ViewModels.VistaClase;

public class Clase {

	// Backing fields
	private int codigo;
	private String dia;
	private String hora;
	private Profesor profesor;
	private Deporte deporte;

	// Constructors
	public Clase(int codigo, String dia, String hora, Deporte deporte) {
		super();
		this.codigo = codigo;
		this.dia = dia;
		this.hora = hora;
		this.deporte = deporte;
	}

	public Clase(String dia, String hora, Deporte deporte) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.deporte = deporte;
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

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	// View
	public VistaClase getView() {
		return new VistaClase(codigo, dia, hora, deporte.getView());
	}

}
