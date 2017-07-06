package Vistas;


	import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.AreaAdministracion;
import Excepciones.SocioException;
import Negocio.Socio;
import ViewModels.VistaAbono;
import ViewModels.VistaSocio;

	public class ListadoAbono extends JFrame {
		private JPanel pnlContenedor;
		private JPanel pnlInferior;
		private JTable tblItems;
		private DefaultTableModel dataModel;
		private JLabel lblTitulo;
		private ButtonColumn buttonColumn;
		private JButton btnAlta;
		private ListadoAbono listadoAbono;
		
		List<VistaAbono> items;

		public ListadoAbono() {
			this.listadoAbono = this;
			// Establecer el titulo de la ventana
			this.setTitle("ABM de Abono");
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

			lblTitulo = new JLabel("Listado de Abono");
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
					new FormAbono("Alta Abono", -1, ListadoAbono.this.listadoAbono);
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
			String[] cabecera = { "Id", "Nombre", "Precio", "Vigencia",
					"", "" };

			dataModel = new DefaultTableModel();
			dataModel.setColumnCount(7);
			dataModel.setColumnIdentifiers(cabecera);
			tblItems.setModel(dataModel);
			tblItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			
			//List<Socio> items = AreaAdministracion.getInstancia().obtenerSocios();
			for(VistaAbono item : items) {
				aux = new Vector<String>();
				aux.add(Integer.toString(item.getIdAbono()));
				aux.add(item.getNombre());
				aux.add(Float.toString(item.getPrecio()));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = new Date();
				String fechaCadena = sdf.format(item.getVigencia());
				aux.add(fechaCadena);
				
				dataModel.addRow(aux);
			}

			if(tblItems == null)
				tblItems = new JTable();

			Action a = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					int row = tblItems.getSelectedRow();
					int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
					FormAbono editWindow = new FormAbono("Editar Abono", id, ListadoAbono.this.listadoAbono);
				}
			};
			buttonColumn = new ButtonColumn(tblItems, a, 5, "Editar");

			a = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					int row = tblItems.getSelectedRow();
					int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
					AreaAdministracion.getInstancia().eliminarSocio(id);
					ListadoAbono.this.listadoAbono.fillTable("");
				}
			};
			buttonColumn = new ButtonColumn(tblItems, a, 6, "Eliminar");
		}

		private List<VistaAbono> getItems() {
			return AreaAdministracion.getInstancia().obtenerAbono();
		}
	}


