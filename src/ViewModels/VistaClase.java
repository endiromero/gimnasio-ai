package ViewModels;

import java.util.Date;
import java.util.Vector;

import Negocio.Abono;
import Negocio.AptoMedico;
import Negocio.Deporte;

public class VistaClase {
	
	private int codigo;
	private Date fecha;
	
	public VistaClase (int codigo, Date fecha){
		this.codigo = codigo;
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public Date getFecha() {
		return fecha;
	}

}
