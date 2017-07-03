package Controlador;

import java.util.ArrayList;
import java.util.List;

import Datos.*;
import Negocio.*;
import ViewModels.*;

public class AreaAdministracion {

	// SINGLETON MANAGEMENT
	private static AreaAdministracion instance;

	public static AreaAdministracion getInstancia() {
		// Singleton lazy loading
		if (instance == null) {
			return instance = new AreaAdministracion();
		}
		return instance;
	}
	
	// CUANDO TENGAMOS EL MANAGER QUE LE PEGUE A LA DB, CAMBIAR EL DE TEST POR ESE NUEVO.
	//private SociosManager socios = TestSociosManager.getInstance();
	private SociosManager socios = DefaultSociosManager.getInstance();
	private EmpleadosManager empleados = TestEmpleadosManager.getInstance();
	private DeportesManager deportes = TestDeportesManager.getInstance();
	private List<Clase> clases;
	private List<Abono> abonos;

	public AreaAdministracion() {
		super();
		this.clases = clases;
		this.abonos = abonos;
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

	// CRUD Deportes
	public void agregarDeporte(String titulo, String descripcion) {
		deportes.addDeporte(new Deporte(titulo, descripcion));
	}
	
	public List<VistaDeporte> obtenerDeportes() {
		List<VistaDeporte> listaVistasDeportes = new ArrayList<VistaDeporte>();
		for (Deporte s : deportes.getAllDeportes()) {
			listaVistasDeportes.add(s.getView());
		}
		return listaVistasDeportes;
	}

	public void modificarDeporte(int idDeporte, String titulo, String descripcion) throws Exception {
		// TODO Auto-generated method stub
		Deporte s = null;
		for (Deporte currentDeporte : deportes.getAllDeportes()) {
			if (currentDeporte.getIdDeporte() == idDeporte) {
				s = currentDeporte;
				break;
			}
		}
		s.setTitulo(titulo);
		s.setDescripcion(descripcion);
		deportes.editDeporte(idDeporte, s);
	}

	public void eliminarDeporte(int idDeporte) {
		deportes.deleteDeporte(idDeporte);
	}

	public List<String> obtenerEmailSocios() {
		return socios.getAllSociosEmails();		
		
	}

}
