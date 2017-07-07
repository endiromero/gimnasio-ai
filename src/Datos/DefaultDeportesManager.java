package Datos;

import java.util.List;

import Negocio.Deporte;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DefaultDeportesManager implements DeportesManager {

	private static DefaultDeportesManager instance = new DefaultDeportesManager();

	public static DefaultDeportesManager getInstance() {
		return instance;
	}

	public Deporte getDeporteById(int idDeporte) {

		throw new NotImplementedException();

	}

	public List<Deporte> getAllDeportes() {

		throw new NotImplementedException();

	}

	public void addDeporte(Deporte newDeporte) {

		throw new NotImplementedException();

	}

	public void editDeporte(int idDeporte, Deporte modifiedDeporte) throws Exception {

		throw new NotImplementedException();

	}

	public void deleteDeporte(int idDeporte) {

		throw new NotImplementedException();

	}

}
