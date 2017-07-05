package Datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Negocio.Clase;

public class TestClasesManager implements ClasesManager {
	
	private static TestClasesManager instance = new TestClasesManager();
	
	public static TestClasesManager getInstance() {
		return instance;
	}
	
	private ArrayList<Clase> clasesBackingList = new ArrayList<Clase>();
	
	private TestClasesManager() {
		clasesBackingList.add(new Clase(0, new Date()));
		clasesBackingList.add(new Clase(1, new Date()));
	}

	@Override
	public List<Clase> getAllClases() {
		List<Clase> result = new ArrayList<Clase>();
		// Copiamos cada uno de los socios para simular traída de DB.
		for (Clase currentSocio : clasesBackingList) {
			result.add(new Clase(
				currentSocio.getCodigo(),
				currentSocio.getFecha()
			));
		}
		return result;
	}

	@Override
	public void addClase(Clase newClase) {
		newClase.setCodigo(getMaxId() + 1);
		clasesBackingList.add(new Clase(
				newClase.getCodigo(),
				newClase.getFecha()
			));
	}
	
	private int getMaxId() {
		int maxId = 0;
		for(Clase currentClase: clasesBackingList)
			if(currentClase.getCodigo() > maxId)
				maxId = currentClase.getCodigo();
		return maxId;
	}

	@Override
	public void editClase(int codigo, Clase modifiedClase) throws Exception {
		if(codigo != modifiedClase.getCodigo())
			throw new Exception();
		Clase s = null;
		for (Clase currentClase : clasesBackingList)
			if (currentClase.getCodigo() == codigo) {
				s = currentClase;
				break;
			}
		s.setFecha(modifiedClase.getFecha());
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