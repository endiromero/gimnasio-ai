package Datos;

import java.util.List;

import Negocio.Clase;

public interface ClasesManager {
	
	List<Clase> getAllClases();
	
	void addClase(Clase newClase);
	
	void editClase(int codigo, Clase modifiedClase) throws Exception;
	
	void deleteClase(int codigo);

}
