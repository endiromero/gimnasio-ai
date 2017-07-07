package Datos;

import java.util.List;

import Negocio.Empleado;

public interface EmpleadosManager {
	
	List<Empleado> getAllEmpleados() throws Exception;

	void addEmpleado(Empleado newEmpleado);

	void editEmpleado(int idEmpleado, Empleado modifiedEmpleado) throws Exception;

	void deleteEmpleado(int idEmpleado);

}