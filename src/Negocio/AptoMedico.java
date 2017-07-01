package Negocio;

import java.util.Date;

public class AptoMedico {
	
	private Date fechaCertificado;
	private Date fechaCaducidad;
	private String profesional;
	private String observaciones;
	
	public AptoMedico(Date fechaCertificado, Date fechaCaducidad,
			String profesional, String observaciones) {
		super();
		this.fechaCertificado = fechaCertificado;
		this.fechaCaducidad = fechaCaducidad;
		this.profesional = profesional;
		this.observaciones = observaciones;
	}
	public Date getFechaCertificado() {
		return fechaCertificado;
	}
	public void setFechaCertificado(Date fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getProfesional() {
		return profesional;
	}
	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	

}
