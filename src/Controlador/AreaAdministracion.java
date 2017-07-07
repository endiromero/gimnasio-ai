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

	// CUANDO TENGAMOS EL MANAGER QUE LE PEGUE A LA DB, CAMBIAR EL DE TEST POR ESE
	// NUEVO.

	private SociosManager socios = TestSociosManager.getInstance();
	//private EmpleadosManager empleados; // = DefaultEmpleadosManager.getInstance();
	private DeportesManager deportes;// = DefaultDeportesManager.getInstance();
	private ClasesManager clases = TestClasesManager.getInstance();
//	private List<Abono> abonos;
//	private List<Profesor> profesores;

	public AreaAdministracion() {
		super();
//		this.abonos = new ArrayList<Abono>();
//		this.profesores = new ArrayList<Profesor>();
	}

	// CRUD Socios

	public void agregarSocio(String nombre, String domicilio, String telefono, String mail) {
		Socio s = new Socio(nombre, domicilio, telefono, mail);
		// Abono a = new Abono (abono, precio, new
		// Timestamp(Calendar.getInstance().getTimeInMillis()), new
		// Timestamp(Calendar.getInstance().getTimeInMillis()));
		// s.setAbono(a);
		socios.addSocio(s);
	}

	public List<VistaSocio> obtenerSocios() {
		List<VistaSocio> listaVistasSocios = new ArrayList<VistaSocio>();
		for (Socio s : socios.getAllSocios()) {
			listaVistasSocios.add(s.getView());
		}
		return listaVistasSocios;
	}

	public void modificarSocio(int idSocio, String nombre, String domicilio, String telefono, String mail)
			throws Exception {
		for (Socio currentSocio : socios.getAllSocios()) {
			if (currentSocio.getIdSocio() == idSocio) {
				currentSocio.setNombre(nombre);
				currentSocio.setDomicilio(domicilio);
				currentSocio.setTelefono(telefono);
				currentSocio.setMail(mail);
				socios.editSocio(idSocio, currentSocio);
				return;
			}
		}
	}

	public void eliminarSocio(int idSocio) {
		socios.deleteSocio(idSocio);
	}

	// CRUD Empleados
//	public void agregarEmpleado(String nombre, String telefono, String mail, String puesto) {
//		empleados.addEmpleado(new Empleado(nombre, telefono, mail, puesto));
//	}
//
//	public List<VistaEmpleado> obtenerEmpleados() {
//		List<VistaEmpleado> listaVistasEmpleados = new ArrayList<VistaEmpleado>();
//		empleados = new ArrayList<Empleado>();
//		for (Empleado e : empleados) {
//			VistaEmpleado ve = e.getView();
//			listaVistasEmpleados.add(ve);
//		}
//
//		if (listaVistasEmpleados.size() != 0)
//			return listaVistasEmpleados;
//
//		return EmpleadosManager.getInstance().findAll();
//
//	}
//
//	public void modificarEmpleado(int codigo, String nombre, String telefono, String mail, String puesto) {
//		// TODO Auto-generated method stub
//		Empleado s = null;
//		for (Empleado currentEmpelado : empleados.getAllEmpleados()) {
//			if (currentEmpelado.getCodigo() == codigo) {
//				s = currentEmpelado;
//				break;
//			}
//		}
//		s.setNombre(nombre);
//		s.setTelefono(telefono);
//		s.setMail(mail);
//		s.setPuesto(puesto);
//		empleados.editEmpleado(codigo, s);
//	}
//
//	public void eliminarEmpleado(int codigo) {
//		empleados.deleteEmpleado(codigo);
//	}

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

	// Liquidacion de Sueldos
//	public float liquidarSueldos(int mes, int ano) throws SocioException
//	{
//		try {
//			empleados = EmpleadosManager.getInstancia().findAll();
//			profesores = 
//		} catch (EmpleadoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		float total=0;
//		for (int i=0; i< empleados.size();i++)
//		{
//			Sueldo s = new Sueldo(mes,ano,empleados.elementAt(i),empleados.elementAt(i).liquidarSueldo());
//			total = total + s.getSueldoNeto();
//			sueldos.add(s);
//			SueldoDAO.getInstancia().save(s);
//		}
//		return total;
//	}

	// CRUD ABONO
	public List<VistaAbono> obtenerAbono() {
		// TODO Auto-generated method stub
		return null;
	}

	// CRUD Clases
	public void agregarClase(String día, String hora) {
		clases.addClase(new Clase(día, hora));
	}

	public List<VistaClase> obtenerClases() {
		List<VistaClase> listaVistasClases = new ArrayList<VistaClase>();
		for (Clase s : clases.getAllClases()) {
			listaVistasClases.add(s.getView());
		}
		return listaVistasClases;
	}

	public void modificarClase(int código, String día, String hora) throws Exception {
		// TODO Auto-generated method stub
		Clase s = null;
		for (Clase currentClase : clases.getAllClases()) {
			if (currentClase.getCodigo() == código) {
				s = currentClase;
				break;
			}
		}
		s.setDia(día);
		s.setHora(hora);
		clases.editClase(código, s);
	}

	public void eliminarClase(int codigo) {
		clases.deleteClase(codigo);
	}

}
