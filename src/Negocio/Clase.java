package Negocio;

import java.util.Date;

public class Clase {

	
	private int codigo;
	private Date dia;
	private Date horario;
	private Profesor profesor;
	
	
	public Clase(Date dia, Date horario) {
		super();
		this.dia = dia;
		this.horario = horario;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
