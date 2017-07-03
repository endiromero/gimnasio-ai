package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import Negocio.Socio;


public class DefaultSociosManager implements SociosManager{

	private static DefaultSociosManager instance = new DefaultSociosManager();	
	public static DefaultSociosManager getInstance() {
		return instance;
	}
	
	
	public List<Socio> getAllSocios() {
		
		try
		{
			
			Vector <Socio>rta = new Vector<Socio>();
			Connection c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery("SELECT [SocioID], [Nombre],[Domicilio],[Telefono],[Email] FROM [ADMGym].[dbo].[Socio]");
			while (result.next())
			{
				int idSocio = result.getInt(1);
				String nombre = result.getString(2);
				String domicilio = result.getString(3);
				String telefono = result.getString(4);
				String mail = result.getString(5);				
					
				Socio socio = new Socio(idSocio, nombre, domicilio, telefono, mail);
			    rta.add(socio);
				
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
			return rta;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	
	public void addSocio(Socio newSocio) {
		// TODO Auto-generated method stub
		
	}

	
	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteSocio(int idSocio) {
		// TODO Auto-generated method stub
		
	}

}
