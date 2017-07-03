package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import Negocio.Abono;
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
		
		Connection con = PoolConnection.getPoolConnection().getConnection();
		PreparedStatement s;
		PreparedStatement a;
		String SQL_INSERT_SOCIO;
		String SQL_INSERT_ABONO;
		
		try {
			
			SQL_INSERT_SOCIO = "INSERT INTO [Socio] ([Nombre],[Domicilio],[Telefono],[Email]) VALUES (?,?,?,?)";
			s = con.prepareStatement(SQL_INSERT_SOCIO, Statement.RETURN_GENERATED_KEYS);
			s.setString(1, newSocio.getNombre());
			s.setString(2, newSocio.getDomicilio());
			s.setString(3, newSocio.getTelefono());
			s.setString(4, newSocio.getMail());			
								
			int affectedRows = s.executeUpdate();
		    if (affectedRows == 0) {
		            throw new SQLException("La creación del Socio ha fallado, ningun dato ha sido modificado.");
		    }
		    
		    try (ResultSet generatedKeys = s.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	
	            	//Podiamos agregar un combo con los nombres de los abonos y otro para los precios asociados.
	            		              	
	            	Abono abono = new Abono("Platinum", 1200, new Timestamp(Calendar.getInstance().getTimeInMillis()));
	            	SQL_INSERT_ABONO = "INSERT INTO [dbo].[Abono] ([Nombre],[Precio], [PeriodoVigencia], [SocioID]) VALUES (?,?,?,?)";
	            	a = con.prepareStatement(SQL_INSERT_ABONO);
	     			a.setString(1, abono.getNombre());
	     			a.setFloat(2, abono.getPrecio());
	     			a.setTimestamp(3, abono.getPeriodoVigencia());
	     			a.setInt(4, generatedKeys.getInt(1));		
	     			a.execute();
	            }
	            else {
	                throw new SQLException("La creación del Abono ha fallado.");
	            }
	        }		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		PoolConnection.getPoolConnection().realeaseConnection(con);
			
	}
	
	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception {
		
		String SQL_UPDATE_SOCIO;
		Socio a = (Socio)modifiedSocio;
		
		SQL_UPDATE_SOCIO = "UPDATE [Socio] SET [Nombre] = ?,[Domicilio] = ?,[Telefono] = ?,[Email] = ?";
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		PreparedStatement s = con.prepareStatement(SQL_UPDATE_SOCIO);	  		
		s.setString(1, a.getNombre());
		s.setString(2, a.getDomicilio());
		s.setString(3, a.getTelefono());		
		s.setString(4, a.getMail());
				
		s.execute();
		PoolConnection.getPoolConnection().realeaseConnection(con);
		
	}
	
	public void deleteSocio(int idSocio) {
		//Realizamos una baja fisica del socio, 
		//De otro modo habria que agregar un campo para la fecha de baja y realizar un update en este metodo.
		
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			//Eliminamos los Abonos asociados
			
			PreparedStatement a = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[Abono] WHERE [SocioID] = ?");
			a.setLong(1, idSocio);
			a.execute();		
			
			PreparedStatement s = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[Socio] WHERE [SocioID] = ?");
			s.setLong(1, idSocio);
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println();
		}
		
		
	}

}
