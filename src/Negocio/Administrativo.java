package Negocio;

public class Administrativo extends Empleado {
	
	private String puesto;
	private float bruto;
	private float obraSocial;
	private float retenciones;
	
	public Administrativo(String nombre, String telefono, String mail, String puesto2, float bruto) {
		super(nombre, telefono, mail);
		puesto = puesto2;
		this.bruto = bruto;
		obraSocial = obraSocial;
		retenciones = retenciones;
	}
		
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
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
