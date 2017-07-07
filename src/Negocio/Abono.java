package Negocio;

import java.sql.Timestamp;
import java.util.Date;

public class Abono {
	
	private int codigo;
	private String nombre;
	private float precio;
	private Timestamp inicioVigencia;
	private Timestamp finalVigencia;
	
	public Abono(String nombre, float precio, Timestamp inicioVigencia, Timestamp finalVigencia) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.inicioVigencia = inicioVigencia;
		this.finalVigencia = finalVigencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Timestamp getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Timestamp inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Timestamp getFinalVigencia() {
		return finalVigencia;
	}

	public void setFinalVigencia(Timestamp finalVigencia) {
		this.finalVigencia = finalVigencia;
	}
	
}
