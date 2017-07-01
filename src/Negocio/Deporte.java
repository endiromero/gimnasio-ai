package Negocio;

import java.util.Vector;

public class Deporte {
	
	
	private int id_deporte;
	private String titulo;
	private String descripcion;
	private Vector <Clase> clases;
	
	public Deporte(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	public Deporte() {
		// TODO Auto-generated constructor stub
	}

	public int getId_deporte() {
		return id_deporte;
	}
	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
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
	

}
