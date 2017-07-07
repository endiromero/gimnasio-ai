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
import ViewModels.VistaClase;
import ViewModels.VistaSocio;

public class ListadoClase extends JFrame {
	private JPanel pnlContenedor;
	private JPanel pnlInferior;
	private JTable tblItems;
	private DefaultTableModel dataModel;
	private JLabel lblTitulo;
	private ButtonColumn buttonColumn;
	private JButton btnAlta;
	private ListadoClase listadoClases;

	List<VistaClase> items;

	public ListadoClase() {
		this.listadoClases = this;
		// Establecer el titulo de la ventana
		this.setTitle("ABM de Clases");
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

		lblTitulo = new JLabel("Listado de Clases");
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
		btnAlta = new JButton("Nueva");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormClase("Alta Clase", -1, ListadoClase.this.listadoClases);
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
		String[] cabecera = { "Codigo", "Día", "Hora", "", "" };

		dataModel = new DefaultTableModel();
		dataModel.setColumnCount(5);
		dataModel.setColumnIdentifiers(cabecera);
		tblItems.setModel(dataModel);
		tblItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// List<Socio> items = AreaAdministracion.getInstancia().obtenerSocios();
		for (VistaClase item : items) {
			aux = new Vector<String>();
			aux.add(Integer.toString(item.getCodigo()));
			aux.add(item.getDia().toString());
			aux.add(item.getHora().toString());
			dataModel.addRow(aux);
		}

		if (tblItems == null)
			tblItems = new JTable();

		Action a = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = tblItems.getSelectedRow();
				int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
				FormClase editWindow = new FormClase("Editar Clase", id, ListadoClase.this.listadoClases);
			}
		};
		buttonColumn = new ButtonColumn(tblItems, a, 3, "Editar");

		a = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = tblItems.getSelectedRow();
				int id = Integer.parseInt(tblItems.getValueAt(row, 0).toString());
				AreaAdministracion.getInstancia().eliminarClase(id);
				ListadoClase.this.listadoClases.fillTable();
			}
		};
		buttonColumn = new ButtonColumn(tblItems, a, 4, "Eliminar");
	}

	private List<VistaClase> getItems() {
		return AreaAdministracion.getInstancia().obtenerClases();
	}
}