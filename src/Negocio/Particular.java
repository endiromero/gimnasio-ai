package Negocio;

public class Particular extends Profesor {

	private float valorHora;

	public Particular(String nombre, String telefono, String mail, int matricula, float valorHora) {
		super(nombre, telefono, mail, matricula);
		this.valorHora = valorHora;
	}

	public Particular(int idProfesor, String nombre, String telefono, String mail, int matricula, float valorHora) {
		super(idProfesor, nombre, telefono, mail, matricula);
		this.valorHora = valorHora;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

}
