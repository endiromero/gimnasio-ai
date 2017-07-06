package Negocio;

import java.sql.Timestamp;
import java.util.Date;

public class Abono {
	
	private int codigo;
	private String nombre;
	private float precio;
	private Date Vigencia;
	
	public Abono(String nombre, float precio, Date Vigencia) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.Vigencia = Vigencia;

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

	public Date getVigencia() {
		return Vigencia;
	}

	public void setVigenciaDesde(Date Vigencia) {
		this.Vigencia = Vigencia;
	}
	
}
