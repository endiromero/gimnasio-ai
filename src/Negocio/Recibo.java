package Negocio;

public class Recibo 
	{
		private int mes;
		private int anio;
		private Empleado empleado;
		private float sueldoNeto;
		
		public Recibo(int mes, int anio, Empleado empleado, float sueldo) {
			super();
			this.mes = mes;
			this.anio = anio;
			this.empleado = empleado;
			this.sueldoNeto = sueldo;
		}

		public int getMes() {
			return mes;
		}
		public void setMes(int mes) {
			this.mes = mes;
		}
		public int getAnio() {
			return anio;
		}
		public void setAno(int anio) {
			this.anio = anio;
		}
		public Empleado getEmpleado() {
			return empleado;
		}
		public void setEmpleado(Empleado empleado) {
			this.empleado = empleado;
		}
		public float getSueldoNeto() {
			return sueldoNeto;
		}
}

