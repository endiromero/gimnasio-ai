package Negocio;

public class Contratado extends Profesor {

	private float bruto;
	private float obraSocial;
	private float retenciones;

	public Contratado(String nombre, String telefono, String mail, int matricula, float bruto, float obraSocial,
			float retenciones) {
		super(nombre, telefono, mail, matricula);
		this.bruto = bruto;
		this.obraSocial = obraSocial;
		this.retenciones = retenciones;
	}

	public float getBruto() {
		return bruto;
	}

	public void setBruto(float bruto) {
		this.bruto = bruto;
	}

	public float getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(float obraSocial) {
		this.obraSocial = obraSocial;
	}

	public float getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(float retenciones) {
		this.retenciones = retenciones;
	}

}
