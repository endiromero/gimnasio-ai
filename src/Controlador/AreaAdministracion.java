package Controlador;

import java.util.ArrayList;
import java.util.List;

import Negocio.Abono;
import Negocio.Clase;
import Negocio.Deporte;
import Negocio.Socio;
import Vistas.VistaSocio;

public class AreaAdministracion {

	private static AreaAdministracion instance;
	private List<Socio> socios;
	private List<Deporte> deportes;
	private List<Clase> clases;
	private List<Abono> abonos;

	public AreaAdministracion() {
		super();
		// this.socios = socios;

		// MOCK DB Socios
		List<Socio> items = new ArrayList<Socio>();
		items.add(new Socio(0, "COCA-COLA", "AV.CABILDO 123", "4557-7788",
				"coca@coca-cola.com"));
		items.add(new Socio(1, "GOOGLE", "AV. BELGRANO 456", "4557-7711",
				"google@gmail.com"));
		socios = items;

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

	public List<VistaSocio> obtenerSocios() {
		List<VistaSocio> listaVistasSocios = new ArrayList<VistaSocio>();

		for (Socio s : socios) {
			listaVistasSocios.add(s.getView());
		}

		return listaVistasSocios;

	}

	public void eliminarSocio(int idSocio) {

		Socio socio = null;
		for (Socio item : socios) {
			if (item.getidSocio() == idSocio) {
				socio = item;
				break;
			}
		}

		socios.remove(socio);

	}

	public void agregarSocio(String nombre, String domicilio, String telefono,
			String mail) {
		socios.add(1, new Socio(nombre, domicilio, telefono, mail));
	}

	public void modificarSocio(int idSocio, String nombre, String domicilio,
			String telefono, String mail) {
		// TODO Auto-generated method stub
		Socio s = null;
		for (Socio currentSocio : socios) {
			if (currentSocio.getidSocio() == idSocio) {
				s = currentSocio;
				break;
			}
		}
		s.setNombre(nombre);
		s.setDomicilio(domicilio);
		s.setTelefono(telefono);
		s.setMail(mail);
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
				socios.remove(item);
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
