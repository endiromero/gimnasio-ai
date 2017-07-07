package Datos;

import java.util.List;

import Negocio.Deporte;

public interface DeportesManager {
	
	Deporte getDeporteById(int idDeporte) throws Exception;

	List<Deporte> getAllDeportes();

	void addDeporte(Deporte newDeporte);

	void editDeporte(int idDeporte, Deporte modifiedDeporte) throws Exception;

	void deleteDeporte(int idDeporte);

}
