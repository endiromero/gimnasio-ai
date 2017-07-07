package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Negocio.Abono;
import Negocio.Socio;

public interface SociosManager {
	
	public List<Socio> getAllSocios();
	
	public void addSocio(Socio newSocio);
	
	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception;
	
	public void deleteSocio(int idSocio);

	public List<String>  getAllSociosEmails();

}
