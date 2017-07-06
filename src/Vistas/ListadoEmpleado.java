package Vistas;


	import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.AreaAdministracion;
import Excepciones.SocioException;
import Negocio.Socio;
import ViewModels.VistaEmpleado;
import ViewModels.VistaSocio;

	public class ListadoEmpleado extends JFrame {
		private JPanel pnlContenedor;
		private JPanel pnlInferior;
		private JTable tblItems;
		private DefaultTableModel dataModel;
		private JLabel lblTitulo;
		private ButtonColumn buttonColumn;
		private JButton btnAlta;
		private ListadoEmpleado listadoEmpleados;
		
		List<VistaEmpleado> items;

		public ListadoEmpleado() {
			this.listadoEmpleados = this;
			// Establecer el titulo de la ventana
			this.setTitle("ABM de Empleados");
			// Establecer la dimension de la ventana (ancho, alto)
			this.setSize(750, 400);
			// Establecer NO dimensionable la ventana
			this.setResizable(false);
			// Ubicar la ventana en el centro de la pantalla
			this.setLocationRelativeTo(null);
			// Agregar el panel al JFrame
			this.getContentPane().add(this.getPanelContenedor());
			// Mostrar la ventana
			this.setVisible(true);
		}

		private JPanel getPanelContenedor() {
			pnlContenedor = new JPanel();
			pnlInferior = new JPanel();
			pnlContenedor.setLayout(new BorderLayout());

			lblTitulo = new JLabel("Listado de Empleados");
			lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
			lblTitulo.setHorizontalAlignment(JLabel.CENTER);

			pnlContenedor.add(lblTitulo, BorderLayout.PAGE_START);
			pnlContenedor.add(getJTable(), BorderLayout.CENTER);
			pnlContenedor.add(getPanelInferior(), BorderLayout.PAGE_END);
			return pnlContenedor;
		}

		private JPanel getPanelInferior() {
			pnlInferior.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			btnAlta = new JButton("Nuevo");
			btnAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new FormEmpleado("Alta Empleado", -1, ListadoEmpleado.this.listadoEmpleados);
				}
			});
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 0; // n�mero fila
			gbc.gridwidth = 1; // numero de columnas de ancho
			gbc.gridheight = 1; // numero de filas de ancho
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.VERTICAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
			gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
			pnlInferior.add(btnAlta, gbc); // agregar el textField al panel contenedor
			return pnlInferior;
		}

		private JScrollPane getJTable() {
			tblItems = new JTable();
			JScrollPane scrollPane = new JScrollPane(tblItems);
			fillTable("");
			return scrollPane;
		}

		public void fillTable(String txt) {
			items = getItems();
			Vector<String> aux;
			String[] cabecera = { "Codigo", "Nombre", "Telefono", "Mail", "Tipo",
					"", "" };

			dataModel = new DefaultTableModel();
			dataModel.setColumnCount(7);
			dataModel.setColumnIdentifiers(cabecera);
			tblItems.setModel(dataModel);
			tblItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			
			//List<Socio> items = AreaAdministracion.getInstancia().obtenerSocios();
			for(VistaEmpleado item : items) {
				aux = new Vector<String>();
				aux.add(Integer.toString(item.getCodigo()));
				aux.add(item.getNombre());
				aux.add(item.getTelefono());
				aux.add(item.getMail());
				aux.add(item.getPuesto());
				dataModel.addRow(aux);
			}

			if(tblItems == null)
				tblItems = new JTable();

			Action a = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					int row = tblItems.getSelectedRow();
					int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
					FormEmpleado editWindow = new FormEmpleado("Edicion Empleado", id, ListadoEmpleado.this.listadoEmpleados);
				}
			};
			buttonColumn = new ButtonColumn(tblItems, a, 5, "Editar");

			a = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					int row = tblItems.getSelectedRow();
					int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
					AreaAdministracion.getInstancia().eliminarEmpleado(id);
					ListadoEmpleado.this.listadoEmpleados.fillTable("");
				}
			};
			buttonColumn = new ButtonColumn(tblItems, a, 6, "Eliminar");
		}

		private List<VistaEmpleado> getItems() {
			return AreaAdministracion.getInstancia().obtenerEmpleados();
		}
	}


