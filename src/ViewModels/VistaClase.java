package ViewModels;

public class VistaClase {

	private int codigo;
	private String dia;
	private String hora;

	public VistaClase(int codigo, String dia, String hora) {
		this.codigo = codigo;
		this.dia = dia;
		this.hora = hora;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDia() {
		return dia;
	}

	public String getHora() {
		return hora;
	}

}
