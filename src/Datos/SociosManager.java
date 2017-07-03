package Datos;

import java.util.List;

import Negocio.Socio;

public interface SociosManager {	

	
	
	void addSocio(Socio newSocio);
	
	void editSocio(int idSocio, Socio modifiedSocio) throws Exception;
	
	void deleteSocio(int idSocio);

	List<Socio> getAllSocios();
	
	List<String> getAllSociosEmails();	
	
}
