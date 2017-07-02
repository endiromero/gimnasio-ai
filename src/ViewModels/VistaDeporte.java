package ViewModels;

import java.util.Vector;

import Negocio.Abono;
import Negocio.AptoMedico;
import Negocio.Deporte;

public class VistaDeporte {
	
	private int idDeporte;
	private String titulo;
	private String descripcion;
	
	public VistaDeporte (int idDeporte, String titulo, String descripcion){
		this.idDeporte = idDeporte;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
