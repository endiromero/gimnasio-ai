package Negocio;

public class JornadaCompleta {
	
	private float basico;
	private float retencion;
	private float deducciones;
	
	public JornadaCompleta(float basico, float retencion, float deducciones) {
		super();
		this.basico = basico;
		this.retencion = retencion;
		this.deducciones = deducciones;
	}
	public float getBasico() {
		return basico;
	}
	public void setBasico(float basico) {
		this.basico = basico;
	}
	public float getRetencion() {
		return retencion;
	}
	public void setRetencion(float retencion) {
		this.retencion = retencion;
	}
	public float getDeducciones() {
		return deducciones;
	}
	public void setDeducciones(float deducciones) {
		this.deducciones = deducciones;
	}
	

}
