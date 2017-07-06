package Datos;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.List;
	import java.util.Vector;

	import Excepciones.EmpleadoException;
	import Negocio.Administrativo;
	import Negocio.Empleado;
	import ViewModels.VistaEmpleado;

	public class EmpleadosManager {
		
		private static EmpleadosManager instance = new EmpleadosManager();	
		
		public static EmpleadosManager getInstance() {
			return instance;
		}
			
		/*public Empleado findByPK(int IdEmpleado) throws EmpleadoException
		{
			Empleado emp = null;
			try {
				PreparedStatement pstm = PoolConnection.getPoolConnection().getConnection().prepareStatement("Select * from Empleado where IdEmpleado = ?");
				pstm.setInt(1, IdEmpleado);
				ResultSet rs = pstm.executeQuery();
				if(rs.next())
				{
					Administrativo adm;
					if (rs.getString("Tipo") == "Administrativo")
						 adm = new Administrativo(rs.getString("Nombre"), rs.getString("Telefono"), rs.getString("EMail"),rs.getString("Puesto"), rs.getFloat("Sueldo"));
							return adm;
					adm = new Profesor(rs.getString("Nombre"), rs.getString("Telefono"), rs.getString("EMail"),rs.getString("Puesto"), rs.getFloat("Sueldo"));
					return adm;
					
						
						
						}
					}
		
			} catch (SQLException e) {
				throw new EmpleadoException("No existe el empleado");
			} catch (ConexionException e) {
				throw new EmpleadoException(e.getMessage());
			}
			
		}
		*/
		public Vector<VistaEmpleado> findAll(){
			Vector<VistaEmpleado> empleados = new Vector<VistaEmpleado>();
			VistaEmpleado emp;
			
				Statement stm;
				try {
					stm = PoolConnection.getPoolConnection().getConnection().createStatement();
					ResultSet rs = stm.executeQuery("Select [EmpleadoID], [Nombre],[Telefono],[Email],[Tipo] FROM [ADMGym].[dbo].[Empleado]");
					while(rs.next())
					{
						emp = new VistaEmpleado(rs.getInt("EmpleadoID"),rs.getString("Nombre"),rs.getString("Telefono"),rs.getString("Email"),rs.getString("Tipo"));
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
	



