package Datos;

import java.util.List;
import Negocio.Socio;

public interface SociosManager {
	
	public List<Socio> getAllSocios();
	
	public void addSocio(Socio newSocio);
	
	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception;
	
	public void deleteSocio(int idSocio);

	public List<String>  getAllSociosEmails();

}
