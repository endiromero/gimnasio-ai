package Negocio;

public class Empleado {
	
	private int codigo;
	private String nombre;
	private String telefono;
	private String mail;
	private String Puesto;
	
	public Empleado(String nombre, String telefono, String mail, String puesto) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		Puesto = puesto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPuesto() {
		return Puesto;
	}

	public void setPuesto(String puesto) {
		Puesto = puesto;
	}
	
	

}
