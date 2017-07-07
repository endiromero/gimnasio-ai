package ViewModels;

public class VistaClase {

	private int codigo;
	private String dia;
	private String hora;
	private VistaDeporte deporte;

	public VistaClase(int codigo, String dia, String hora, VistaDeporte deporte) {
		this.codigo = codigo;
		this.dia = dia;
		this.hora = hora;
		this.deporte = deporte;
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
	
	public VistaDeporte getDeporte() {
		return deporte;
	}

}
