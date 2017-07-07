package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Negocio.Socio;

public class DefaultSociosManager implements SociosManager {

	private static DefaultSociosManager instance = new DefaultSociosManager();

	public static DefaultSociosManager getInstance() {
		return instance;
	}

	public List<Socio> getAllSocios() {

		Vector<Socio> rta = new Vector<Socio>();
		PoolConnection.getPoolConnection();
		Connection c = null;
		try {
			c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery(
					"SELECT [SocioID], [Nombre],[Domicilio],[Telefono],[Email] FROM [ADMGym].[dbo].[Socio]");
			while (result.next()) {
				int idSocio = result.getInt(1);
				String nombre = result.getString(2);
				String domicilio = result.getString(3);
				String telefono = result.getString(4);
				String mail = result.getString(5);
				Socio socio = new Socio(idSocio, nombre, domicilio, telefono, mail);
				rta.add(socio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (c != null)
				PoolConnection.getPoolConnection().realeaseConnection(c);
		}

		return rta;
	}

	public void addSocio(Socio newSocio) {

		Connection c = null;
		try {
			c = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s;
			//PreparedStatement a;
			String SQL_INSERT_SOCIO;
			//String SQL_INSERT_ABONO;

			SQL_INSERT_SOCIO = "INSERT INTO [Socio] ([Nombre],[Domicilio],[Telefono],[Email]) VALUES (?,?,?,?)";
			s = c.prepareStatement(SQL_INSERT_SOCIO, Statement.RETURN_GENERATED_KEYS);
			s.setString(1, newSocio.getNombre());
			s.setString(2, newSocio.getDomicilio());
			s.setString(3, newSocio.getTelefono());
			s.setString(4, newSocio.getMail());

			int affectedRows = s.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("La creaci�n del Socio ha fallado, ningun dato ha sido modificado.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (c != null)
				PoolConnection.getPoolConnection().realeaseConnection(c);
		}

	}

	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception {

		String SQL_UPDATE_SOCIO;
		Socio a = (Socio) modifiedSocio;

		SQL_UPDATE_SOCIO = "UPDATE [Socio] SET [Nombre] = ?,[Domicilio] = ?,[Telefono] = ?,[Email] = ? WHERE [SocioID]=?";
		PoolConnection.getPoolConnection();
		Connection con = PoolConnection.getPoolConnection().getConnection();

		PreparedStatement s = con.prepareStatement(SQL_UPDATE_SOCIO);
		s.setString(1, a.getNombre());
		s.setString(2, a.getDomicilio());
		s.setString(3, a.getTelefono());
		s.setString(4, a.getMail());
		s.setInt(5, idSocio);

		s.execute();
		PoolConnection.getPoolConnection().realeaseConnection(con);

	}

	public void deleteSocio(int idSocio) {

		Connection con;
		try {
			con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement a = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[AptoMedico] WHERE [SocioID] = ?");
			a.setInt(1, idSocio);
			a.execute();

			PreparedStatement b = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[Abono] WHERE [SocioID] = ?");
			b.setInt(1, idSocio);
			b.execute();

			PreparedStatement c = con
					.prepareStatement("DELETE FROM [ADMGym].[dbo].[Inscripciones] WHERE [SocioID] = ?");
			c.setInt(1, idSocio);
			c.execute();

			PreparedStatement d = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[Socio] WHERE [SocioID] = ?");
			d.setInt(1, idSocio);
			d.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// PoolConnection.getPoolConnection().realeaseConnection(con);

	}

	public List<String> getAllSociosEmails() {
		try {
			List<String> emails = new ArrayList<>();

			PoolConnection.getPoolConnection();
			Connection c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery("SELECT [Email] FROM [ADMGym].[dbo].[Socio]");
			while (result.next()) {
				String mail = result.getString(1);
				emails.add(mail);
			}
			// PoolConnection.getPoolConnection().realeaseConnection(c);
			return emails;
		} catch (Exception e) {

		}
		return null;

	}

}
