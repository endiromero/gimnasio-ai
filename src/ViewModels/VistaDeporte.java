package ViewModels;

public class VistaDeporte {

	private int idDeporte;
	private String titulo;
	private String descripcion;

	public VistaDeporte(int idDeporte, String titulo, String descripcion) {
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

	@Override
	public boolean equals(Object other) {
		VistaDeporte otra = (VistaDeporte) other;
		return (this.idDeporte == otra.getIdDeporte() && this.titulo == otra.getTitulo()
				&& this.descripcion == otra.getDescripcion());
	}
	
	@Override
	public String toString() {
		return titulo;
	}

}
