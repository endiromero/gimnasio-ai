package Datos;

import java.util.ArrayList;
import java.util.List;

import Negocio.Deporte;

public class TestDeportesManager implements DeportesManager {

	private static TestDeportesManager instance = new TestDeportesManager();

	public static TestDeportesManager getInstance() {
		return instance;
	}

	private ArrayList<Deporte> deportesBackingList = new ArrayList<Deporte>();

	private TestDeportesManager() {
		deportesBackingList.add(new Deporte(1, "FÚLBO", "11 vs 11"));
		deportesBackingList.add(new Deporte(2, "TÉNIS", "Pelota amarilla + raqueta + red"));
	}

	@Override
	public List<Deporte> getAllDeportes() {
		List<Deporte> result = new ArrayList<Deporte>();
		// Copiamos cada uno de los socios para simular traída de DB.
		for (Deporte currentDeporte : deportesBackingList) {
			result.add(new Deporte(currentDeporte.getIdDeporte(), currentDeporte.getTitulo(),
					currentDeporte.getDescripcion()));
		}
		return result;
	}

	@Override
	public void addDeporte(Deporte newDeporte) {
		newDeporte.setIdDeporte(getMaxId() + 1);
		deportesBackingList
				.add(new Deporte(newDeporte.getIdDeporte(), newDeporte.getTitulo(), newDeporte.getDescripcion()));
	}

	private int getMaxId() {
		int maxId = 0;
		for (Deporte currentDeporte : deportesBackingList)
			if (currentDeporte.getIdDeporte() > maxId)
				maxId = currentDeporte.getIdDeporte();
		return maxId;
	}

	@Override
	public void editDeporte(int idDeporte, Deporte modifiedDeporte) throws Exception {
		if (idDeporte != modifiedDeporte.getIdDeporte())
			throw new Exception();
		Deporte s = null;
		for (Deporte currentDeporte : deportesBackingList)
			if (currentDeporte.getIdDeporte() == idDeporte) {
				s = currentDeporte;
				break;
			}
		s.setTitulo(modifiedDeporte.getTitulo());
		s.setDescripcion(modifiedDeporte.getDescripcion());
	}

	@Override
	public void deleteDeporte(int idDeporte) {
		Deporte s = null;
		for (Deporte currentDeporte : deportesBackingList)
			if (currentDeporte.getIdDeporte() == idDeporte) {
				s = currentDeporte;
				break;
			}
		deportesBackingList.remove(s);
	}

}