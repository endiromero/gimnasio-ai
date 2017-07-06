package Negocio;

public class Recibo 
	{
		private int mes;
		private int ano;
		private Empleado empleado;
		private float sueldoNeto;
		
		public Recibo(int mes, int ano, Empleado empleado, float sueldo) {
			super();
			this.mes = mes;
			this.ano = ano;
			this.empleado = empleado;
			this.sueldoNeto = sueldo;
		}

		public int getMes() {
			return mes;
		}
		public void setMes(int mes) {
			this.mes = mes;
		}
		public int getAño() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
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

