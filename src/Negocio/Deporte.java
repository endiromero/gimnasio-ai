package Negocio;

import java.util.Vector;

import ViewModels.VistaDeporte;

public class Deporte {

	// Backing Fields
	private int idDeporte;
	private String titulo;
	private String descripcion;
	private Vector<Clase> clases;

	// Constructors
	public Deporte(int idDeporte, String titulo, String descripcion) {
		super();
		this.idDeporte = idDeporte;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public Deporte(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public Deporte() {
		// TODO Auto-generated constructor stub
	}

	// Properties
	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Vector<Clase> getClases() {
		return clases;
	}

	public void setClases(Vector<Clase> clases) {
		this.clases = clases;
	}

	// View
	public VistaDeporte getView() {
		return new VistaDeporte(idDeporte, titulo, descripcion);
	}

}
