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
import Negocio.Abono;
import Negocio.Particular;
import Negocio.Profesor;
import Negocio.Socio;

public class ProfesoresManager {
	private static ProfesoresManager instance = new ProfesoresManager();

	public static ProfesoresManager getInstance() {
		return instance;
	}

	public List<Profesor> getAllProfesores() {

		try {

			List<Profesor> rta = new ArrayList<Profesor>();
			Connection c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery(
					"SELECT [ProfesorID],[ProfesorID],[Matricula],[ValorHora],[Sueldo],[Tipo] FROM [ADMGym].[dbo].[Profesor]");
			while (result.next()) {
				if (result.getString(6) == "particular") {
					int idProfesor = result.getInt(1);
					String nombre = result.getString(2);
					String telefono = result.getString(3);
					String mail = result.getString(4);
					int matricula = result.getInt(5);
					float valorHora = result.getInt(6);

					Particular particular = new Particular(idProfesor, nombre, telefono, mail, matricula, valorHora);
					rta.add(particular);
				}
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
			return rta;
		} catch (Exception e) {

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
				throw new SQLException("La creaci�n del Socio ha fallado, ningun dato ha sido modificado.");
			}

			try (ResultSet generatedKeys = s.getGeneratedKeys()) {
				if (generatedKeys.next()) {

					// Podiamos agregar un combo con los nombres de los abonos y otro para los
					// precios asociados.//

					Abono abono = new Abono("Platinum", 1200F, new Timestamp(Calendar.getInstance().getTimeInMillis()),
							new Timestamp(Calendar.getInstance().getTimeInMillis()));
					SQL_INSERT_ABONO = "INSERT INTO [dbo].[Abono] ([Nombre],[Precio], [VigenciaDesde],, [VigenciaHasta], [SocioID]) VALUES (?,?,?,?,?)";
					a = con.prepareStatement(SQL_INSERT_ABONO);
					a.setString(1, abono.getNombre());
					a.setFloat(2, abono.getPrecio());
					a.setTimestamp(3, abono.getInicioVigencia());
					a.setTimestamp(4, abono.getFinalVigencia());
					a.setInt(5, generatedKeys.getInt(1));
					a.execute();
				} else {
					throw new SQLException("La creaci�n del Abono ha fallado.");
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getPoolConnection().realeaseConnection(con);

	}

	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception {

		String SQL_UPDATE_SOCIO;
		Socio a = (Socio) modifiedSocio;

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
		// Realizamos una baja fisica del socio,
		// De otro modo habria que agregar un campo para la fecha de baja y realizar un
		// update en este metodo.

		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			// Eliminamos los Abonos asociados

			PreparedStatement a = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[Abono] WHERE [SocioID] = ?");
			a.setLong(1, idSocio);
			a.execute();

			PreparedStatement s = con.prepareStatement("DELETE FROM [ADMGym].[dbo].[Socio] WHERE [SocioID] = ?");
			s.setLong(1, idSocio);
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			System.out.println();
		}

	}

	public List<String> getAllSociosEmails() {
		try {
			List<String> emails = new ArrayList<>();

			Connection c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery("SELECT [Email] FROM [ADMGym].[dbo].[Socio]");
			while (result.next()) {
				String mail = result.getString(1);
				emails.add(mail);
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
			return emails;
		} catch (Exception e) {

		}
		return null;

	}

}
