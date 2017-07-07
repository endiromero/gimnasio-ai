package ViewModels;

import java.util.Date;

public class VistaAbono {
	private int idAbono;
	private String nombre;
	private float precio;
	private Date vigencia;
	public int getIdAbono() {
		return idAbono;
	}
	public void setIdAbono(int idAbono) {
		this.idAbono = idAbono;
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
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	public VistaAbono(int idAbono, String nombre, float precio, Date vigencia) {
		super();
		this.idAbono = idAbono;
		this.nombre = nombre;
		this.precio = precio;
		this.vigencia = vigencia;
	}

}
