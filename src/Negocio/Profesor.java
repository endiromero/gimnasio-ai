package Negocio;

public class Profesor extends Empleado {
	
	private int matricula;

	public Profesor(String nombre, String telefono, String mail, int matricula) {
		super(nombre, telefono, mail);
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
