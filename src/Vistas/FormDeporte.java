package Vistas;

	import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.AreaAdministracion;
import Negocio.Deporte;
import Negocio.Socio;

//import controlador.ClienteControlador;

//import dao.ClienteDAO;
//import excepciones.ClienteException;


	public class FormDeporte extends JFrame {
		private JPanel pnlContenedor;
		private JPanel pnlCentro;
		private JButton btnGuardar;
		private JLabel lblTitulo;
		private JLabel lblNombre;
		private JLabel lblDomicilio;
		private JLabel lblTelefono;
		private JLabel lblMail;
		private JTextField txtNombre;
		Deporte entidad;
		private JTextField txtDomicilio;
		private JTextField txtTelefono;
		private JTextField txtMail;
		private int id;
		private ListadoDeporte lst;
		//private ClienteDAO dao;

		public FormDeporte(String frameTitle, int id, ListadoDeporte me) {
			this.id = id;
			this.lst = me;
			this.entidad = new Deporte();
			//		this.dao = new ClienteDAODBImpl();
			// Establecer el titulo de la ventana
			this.setTitle(frameTitle);
			// Establecer la dimension de la ventana (ancho, alto)
			this.setSize(400, 250);
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
			pnlContenedor.setLayout(new BorderLayout());
			if(this.id == -1) 
				lblTitulo = new JLabel("Alta Cliente");
			else
				lblTitulo = new JLabel("Edición Cliente");
			lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
			lblTitulo.setHorizontalAlignment(JLabel.CENTER);
			pnlContenedor.add(lblTitulo, BorderLayout.PAGE_START);
			pnlContenedor.add(getPanelCentro(), BorderLayout.CENTER);
			return pnlContenedor;
		}

		private JPanel getPanelCentro() {
			pnlCentro = new JPanel();
			pnlCentro.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();

			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 0; // número fila
			gbc.gridwidth = 1; // numero de columnas de ancho
			gbc.gridheight = 1; // numero de filas de ancho
			gbc.weightx = 0.1;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.HORIZONTAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
			gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
			pnlCentro.add(lblNombre, gbc); // agregar el label al panel contenedor

			txtNombre = new JTextField();
			gbc.gridx = 1; // número columna
			gbc.gridy = 0; // número fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtNombre, gbc); // agregar el textField al panel contenedor

			lblDomicilio = new JLabel("Domicilio:");
			lblDomicilio.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 1; // número fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblDomicilio, gbc); // agregar el label al panel contenedor

			txtDomicilio = new JTextField();
			gbc.gridx = 1; // número columna
			gbc.gridy = 1; // número fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtDomicilio, gbc); // agregar el textField al panel contenedor

			lblTelefono = new JLabel("Teléfono:");
			lblTelefono.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 2; // número fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblTelefono, gbc); // agregar el label al panel contenedor

			txtTelefono = new JTextField();
			gbc.gridx = 1; // número columna
			gbc.gridy = 2; // número fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtTelefono, gbc); // agregar el textField al panel contenedor

			lblMail = new JLabel("Mail:");
			lblMail.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 3; // número fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblMail, gbc); // agregar el label al panel contenedor

			txtMail = new JTextField();
			gbc.gridx = 1; // número columna
			gbc.gridy = 3; // número fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtMail, gbc); // agregar el textField al panel contenedor

			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el nombre");
						txtNombre.requestFocusInWindow();
						return;
					}
					entidad.setTitulo(txtNombre.getText());

					if(txtDomicilio.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el domicilio");
						txtDomicilio.requestFocusInWindow();
						return;
					}
					entidad.setDescripcion(txtDomicilio.getText());

					if(id == -1)
						try {
							AreaAdministracion.getInstancia().agregarDeporte(entidad);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					else
//						try {
							AreaAdministracion.getInstancia().modificarDeporte(entidad);
//						} catch (ClienteException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					FormDeporte.this.lst.fillTable("");
					closeWin();
				}
			});

			gbc.gridx = 0; // número columna
			gbc.gridy = 4; // número fila
			gbc.gridwidth = 2; // numero de columnas de ancho
			gbc.fill = GridBagConstraints.NONE; // rellenar la celda en ambos sentidos (horizontal y vertical)
			pnlCentro.add(btnGuardar, gbc); // agregar el textField al panel contenedor

			return pnlCentro;
		}

		private void closeWin() {
			this.setVisible(false);
			this.dispose();
		}
	}


