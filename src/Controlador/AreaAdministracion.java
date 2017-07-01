package Controlador;

import java.util.ArrayList;
import java.util.List;

import Datos.EmpleadosManager;
import Datos.SociosManager;
import Datos.TestEmpleadosManager;
import Datos.TestSociosManager;
import Negocio.Abono;
import Negocio.Clase;
import Negocio.Deporte;
import Negocio.Empleado;
import Negocio.Socio;
import ViewModels.VistaEmpleado;
import ViewModels.VistaSocio;

public class AreaAdministracion {

	private static AreaAdministracion instance;
	// CUANDO TENGAMOS EL MANAGER QUE LE PEGUE A LA DB, CAMBIAR EL DE TEST POR ESE NUEVO.
	private SociosManager socios = TestSociosManager.getInstance();
	private EmpleadosManager empleados = TestEmpleadosManager.getInstance();
	private List<Deporte> deportes;
	private List<Clase> clases;
	private List<Abono> abonos;

	public AreaAdministracion() {
		super();

		this.deportes = deportes;
		this.clases = clases;
		this.abonos = abonos;
	}

	public static AreaAdministracion getInstancia() {
		if (instance == null) {
			return instance = new AreaAdministracion();
		}
		return instance;
	}
	
	// CRUD Socios

	public void agregarSocio(String nombre, String domicilio, String telefono,
			String mail) {
		socios.addSocio(new Socio(nombre, domicilio, telefono, mail));
	}
	
	public List<VistaSocio> obtenerSocios() {
		List<VistaSocio> listaVistasSocios = new ArrayList<VistaSocio>();
		for (Socio s : socios.getAllSocios()) {
			listaVistasSocios.add(s.getView());
		}
		return listaVistasSocios;
	}

	public void modificarSocio(int idSocio, String nombre, String domicilio,
			String telefono, String mail) throws Exception {
		// TODO Auto-generated method stub
		Socio s = null;
		for (Socio currentSocio : socios.getAllSocios()) {
			if (currentSocio.getIdSocio() == idSocio) {
				s = currentSocio;
				break;
			}
		}
		s.setNombre(nombre);
		s.setDomicilio(domicilio);
		s.setTelefono(telefono);
		s.setMail(mail);
		socios.editSocio(idSocio, s);
	}

	public void eliminarSocio(int idSocio) {
		socios.deleteSocio(idSocio);
	}
	
	// CRUD Empleados

		public void agregarEmpleado(String nombre, String telefono,
				String mail, String puesto) {
			empleados.addEmpleado(new Empleado(nombre, telefono, mail, puesto));
		}
		
		public List<VistaEmpleado> obtenerEmpleados() {
			List<VistaEmpleado> listaVistasEmpleados = new ArrayList<VistaEmpleado>();
			for (Empleado s : empleados.getAllEmpleados()) {
				listaVistasEmpleados.add(s.getView());
			}
			return listaVistasEmpleados;
		}

		public void modificarEmpleado(int codigo, String nombre,
				String telefono, String mail, String puesto) throws Exception {
			// TODO Auto-generated method stub
			Empleado s = null;
			for (Empleado currentEmpelado : empleados.getAllEmpleados()) {
				if (currentEmpelado.getCodigo() == codigo) {
					s = currentEmpelado;
					break;
				}
			}
			s.setNombre(nombre);
			s.setTelefono(telefono);
			s.setMail(mail);
			s.setPuesto(puesto);
			empleados.editEmpleado(codigo, s);
		}

		public void eliminarEmpleado(int codigo) {
			empleados.deleteEmpleado(codigo);
		}

	public List<Deporte> obtenerDeportes() {
		List<Deporte> deportes = new ArrayList();

		for (Deporte d : deportes) {
		}

		return deportes;

	}

	public void eliminarDeporte(Deporte s) {

		for (Deporte item : deportes) {
			if (s.getId_deporte() == item.getId_deporte()) {
				//socios.remove(item);
			}
		}

	}

	public void agregarDeporte(Deporte entidad) {

		entidad.setId_deporte(deportes.size());
		entidad.setTitulo(entidad.getTitulo());
		entidad.setDescripcion(entidad.getDescripcion());
		deportes.add(entidad);
		// TODO Auto-generated method stub

	}

	public void modificarDeporte(Deporte entidad) {
		// TODO Auto-generated method stub
		for (Deporte s : deportes) {
			if (s.getId_deporte() == entidad.getId_deporte()) {
				s.setTitulo(entidad.getTitulo());
				s.setDescripcion(entidad.getDescripcion());

			}

		}

	}

}
