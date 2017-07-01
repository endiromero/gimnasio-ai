package Datos;

import java.util.ArrayList;
import java.util.List;

import Negocio.Empleado;
import Negocio.Socio;

public class TestEmpleadosManager implements EmpleadosManager {
	
	private static TestEmpleadosManager instance = new TestEmpleadosManager();
	
	public static TestEmpleadosManager getInstance() {
		return instance;
	}
	
	private ArrayList<Empleado> empleadosBackingList = new ArrayList<Empleado>();
	
	private TestEmpleadosManager() {
		empleadosBackingList.add(new Empleado(1, "Alejandra", "4000-0000", "mail@mail.com", "Gerente MKT"));
		empleadosBackingList.add(new Empleado(2, "Sebastián", "0000-0004", "test@test.com", "Gerente IT"));
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		List<Empleado> result = new ArrayList<Empleado>();
		// Copiamos cada uno de los empleados para simular traída de DB.
		for (Empleado currentEmpleado : empleadosBackingList) {
			result.add(new Empleado(
				currentEmpleado.getCodigo(),
				currentEmpleado.getNombre(),
				currentEmpleado.getTelefono(),
				currentEmpleado.getMail(),
				currentEmpleado.getPuesto()
			));
		}
		return result;
	}

	@Override
	public void addEmpleado(Empleado newEmpleado) {
		newEmpleado.setCodigo(getMaxId() + 1);
		empleadosBackingList.add(new Empleado(
				newEmpleado.getCodigo(),
				newEmpleado.getNombre(),
				newEmpleado.getTelefono(),
				newEmpleado.getMail(),
				newEmpleado.getPuesto()
			));
	}
	
	private int getMaxId() {
		int maxId = 0;
		for(Empleado currentEmpleado: empleadosBackingList)
			if(currentEmpleado.getCodigo() > maxId)
				maxId = currentEmpleado.getCodigo();
		return maxId;
	}

	@Override
	public void editEmpleado(int codigo, Empleado modifiedEmpleado) throws Exception {
		if(codigo != modifiedEmpleado.getCodigo())
			throw new Exception();
		Empleado s = null;
		for (Empleado currentEmpleado : empleadosBackingList)
			if (currentEmpleado.getCodigo() == codigo) {
				s = currentEmpleado;
				break;
			}
		s.setNombre(modifiedEmpleado.getNombre());
		s.setTelefono(modifiedEmpleado.getTelefono());
		s.setMail(modifiedEmpleado.getMail());
		s.setPuesto(modifiedEmpleado.getPuesto());
	}

	@Override
	public void deleteEmpleado(int codigo) {
		Empleado s = null;
		for (Empleado currentEmpleado : empleadosBackingList)
			if (currentEmpleado.getCodigo() == codigo) {
				s = currentEmpleado;
				break;
			}
		empleadosBackingList.remove(s);
	}

}