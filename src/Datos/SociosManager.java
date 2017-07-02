package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Negocio.Socio;

public interface SociosManager {	

	List<Socio> getAllSocios();
	
	void addSocio(Socio newSocio);
	
	void editSocio(int idSocio, Socio modifiedSocio) throws Exception;
	
	void deleteSocio(int idSocio);


}
