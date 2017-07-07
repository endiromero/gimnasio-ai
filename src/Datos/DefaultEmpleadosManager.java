package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Negocio.Administrativo;
import Negocio.Empleado;
import Negocio.Profesor;

public class DefaultEmpleadosManager {

	private static DefaultEmpleadosManager instance = new DefaultEmpleadosManager();

	public static DefaultEmpleadosManager getInstance() {
		return instance;
	}

	public Vector<Empleado> getAllEmpleados() throws Exception {
		Vector<Empleado> empleados = new Vector<Empleado>();

		Statement stm;
		try {
			stm = PoolConnection.getPoolConnection().getConnection().createStatement();
			ResultSet rs = stm.executeQuery(
					"Select [EmpleadoID],[Nombre],[Telefono],[Email],[Puesto],[Sueldo],[ObraSocial],[Retenciones],[Matricula],[Tipo] FROM [ADMGym].[dbo].[Empleado]");
			while (rs.next()) {
				Empleado emp;
				switch (rs.getString("Tipo")) {
				case "ADM":
					emp = new Administrativo(rs.getInt("EmpleadoID"), rs.getString("Nombre"), rs.getString("Telefono"),
							rs.getString("Email"), rs.getString("Puesto"), rs.getFloat("Sueldo"),
							rs.getFloat("ObraSocial"), rs.getFloat("Retenciones"));
					break;
				case "PRO":
					emp = new Profesor(rs.getInt("EmpleadoID"), rs.getString("Nombre"), rs.getString("Telefono"),
							rs.getString("Email"), rs.getInt("Matricula"));
				default:
					throw new Exception("Tipo de empleado no reconocido por el sistema.");
				}
				empleados.addElement(emp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empleados;
	}
}
