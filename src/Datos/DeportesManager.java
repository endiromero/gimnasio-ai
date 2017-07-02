package Datos;

import java.util.List;

import Negocio.Deporte;
import Negocio.Socio;

public interface DeportesManager {
	
	List<Deporte> getAllDeportes();
	
	void addDeporte(Deporte newDeporte);
	
	void editDeporte(int idDeporte, Deporte modifiedDeporte) throws Exception;
	
	void deleteDeporte(int idDeporte);

}
