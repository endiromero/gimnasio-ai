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
import ViewModels.VistaDeporte;
import ViewModels.VistaSocio;

	public class ListadoDeporte extends JFrame {
		private JPanel pnlContenedor;
		private JPanel pnlInferior;
		private JTable tblItems;
		private DefaultTableModel dataModel;
		private JLabel lblTitulo;
		private ButtonColumn buttonColumn;
		private JButton btnAlta;
		private ListadoDeporte listadoDeportes;
		
		List<VistaDeporte> items;

		public ListadoDeporte() {
			this.listadoDeportes = this;
			// Establecer el titulo de la ventana
			this.setTitle("ABM de Deportes");
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

			lblTitulo = new JLabel("Listado de Deportes");
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
					new FormDeporte("Alta Deportes", -1, ListadoDeporte.this.listadoDeportes);
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
			fillTable();
			return scrollPane;
		}

		public void fillTable() {
			items = getItems();
			Vector<String> aux;
			String[] cabecera = { "Id", "Titulo", "Descripcion",
					"", "" };

			dataModel = new DefaultTableModel();
			dataModel.setColumnCount(5);
			dataModel.setColumnIdentifiers(cabecera);
			tblItems.setModel(dataModel);
			tblItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			
			//List<Socio> items = AreaAdministracion.getInstancia().obtenerSocios();
			for(VistaDeporte item : items) {
				aux = new Vector<String>();
				aux.add(Integer.toString(item.getIdDeporte()));
				aux.add(item.getTitulo());
				aux.add(item.getDescripcion());
				dataModel.addRow(aux);
			}

			if(tblItems == null)
				tblItems = new JTable();

			Action a = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					int row = tblItems.getSelectedRow();
					int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
					FormDeporte editWindow = new FormDeporte("Edici�n Deporte", id, ListadoDeporte.this.listadoDeportes);
				}
			};
			buttonColumn = new ButtonColumn(tblItems, a, 3, "Editar");

			a = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					int row = tblItems.getSelectedRow();
					int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
					AreaAdministracion.getInstancia().eliminarDeporte(id);
					ListadoDeporte.this.listadoDeportes.fillTable();
				}
			};
			buttonColumn = new ButtonColumn(tblItems, a, 4, "Eliminar");
		}

		private List<VistaDeporte> getItems() {
			return AreaAdministracion.getInstancia().obtenerDeportes();
		}
	}


