package Datos;

import java.util.ArrayList;
import java.util.List;

import Negocio.Clase;

public class TestClasesManager implements ClasesManager {

	private static TestClasesManager instance = new TestClasesManager();

	public static TestClasesManager getInstance() {
		return instance;
	}

	private ArrayList<Clase> clasesBackingList = new ArrayList<Clase>();

	private TestClasesManager() {
		try {
			clasesBackingList.add(new Clase(0, "LUNES", "18:00", TestDeportesManager.getInstance().getDeporteById(1)));
			clasesBackingList.add(new Clase(1, "SÁBADO", "14:00", TestDeportesManager.getInstance().getDeporteById(2)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Clase> getAllClases() {
		List<Clase> result = new ArrayList<Clase>();
		// Copiamos cada uno de los socios para simular traída de DB.
		for (Clase currentClase : clasesBackingList) {
			result.add(new Clase(currentClase.getCodigo(), currentClase.getDia(), currentClase.getHora(), currentClase.getDeporte()));
		}
		return result;
	}

	@Override
	public void addClase(Clase newClase) {
		newClase.setCodigo(getMaxId() + 1);
		clasesBackingList.add(new Clase(newClase.getCodigo(), newClase.getDia(), newClase.getHora(), newClase.getDeporte()));
	}

	private int getMaxId() {
		int maxId = 0;
		for (Clase currentClase : clasesBackingList)
			if (currentClase.getCodigo() > maxId)
				maxId = currentClase.getCodigo();
		return maxId;
	}

	@Override
	public void editClase(int codigo, Clase modifiedClase) throws Exception {
		if (codigo != modifiedClase.getCodigo())
			throw new Exception();
		Clase s = null;
		for (Clase currentClase : clasesBackingList)
			if (currentClase.getCodigo() == codigo) {
				s = currentClase;
				break;
			}
		s.setDia(modifiedClase.getDia());
		s.setHora(modifiedClase.getHora());
		s.setDeporte(modifiedClase.getDeporte());
	}

	@Override
	public void deleteClase(int codigo) {
		Clase s = null;
		for (Clase currentClase : clasesBackingList)
			if (currentClase.getCodigo() == codigo) {
				s = currentClase;
				break;
			}
		clasesBackingList.remove(s);
	}

}