package Vistas;

	import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

	import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Controlador.AreaAdministracion;
import Negocio.Socio;
import ViewModels.VistaEmpleado;
import ViewModels.VistaSocio;

	public class FormEmpleado extends JFrame{
		private JPanel pnlContenedor;
		private JPanel pnlCentro;
		private JButton btnGuardar;
		private JLabel lblTitulo;
		private JLabel lblNombre;
		private JLabel lblDomicilio;
		private JLabel lblTelefono;
		private JLabel lblMail;
		private JLabel lblPuesto;
		private JTextField txtNombre;
		VistaEmpleado entidad;
		private JTextField txtDomicilio;
		private JTextField txtTelefono;
		private JTextField txtMail;
		private JTextField txtPuesto;
		private int id;
		private ListadoEmpleado lst;
		FormEmpleado that = this;

		public FormEmpleado(String frameTitle, int codigo, ListadoEmpleado lst) {
			this.id = codigo;
			this.lst = lst;
			this.entidad = null;
			
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
			
			if(codigo != -1){
				VistaEmpleado empleadoAEditar = null;
				for(VistaEmpleado currentVistaEmpleado: lst.items){
					if(currentVistaEmpleado.getCodigo() == id){
						this.entidad = currentVistaEmpleado;
						break;
					}
				}
				bindView();
			}
			
			// Mostrar la ventana
			this.setVisible(true);
		}
		
		private void bindView(){
			txtNombre.setText(entidad.getNombre());
			txtTelefono.setText(entidad.getTelefono());
			txtMail.setText(entidad.getMail());
			txtPuesto.setText(entidad.getPuesto());
		}

		private JPanel getPanelContenedor() {
			pnlContenedor = new JPanel();
			pnlContenedor.setLayout(new BorderLayout());
			if(this.id == -1) 
				lblTitulo = new JLabel("Alta Empleado");
			else
				lblTitulo = new JLabel("Edici�n Empleado");
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
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 0; // n�mero fila
			gbc.gridwidth = 1; // numero de columnas de ancho
			gbc.gridheight = 1; // numero de filas de ancho
			gbc.weightx = 0.1;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.HORIZONTAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
			gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
			pnlCentro.add(lblNombre, gbc); // agregar el label al panel contenedor

			txtNombre = new JTextField();
			gbc.gridx = 1; // n�mero columna
			gbc.gridy = 0; // n�mero fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtNombre, gbc); // agregar el textField al panel contenedor

			lblTelefono = new JLabel("Tel�fono:");
			lblTelefono.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 1; // n�mero fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblTelefono, gbc); // agregar el label al panel contenedor

			txtTelefono = new JTextField();
			gbc.gridx = 1; // n�mero columna
			gbc.gridy = 1; // n�mero fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtTelefono, gbc); // agregar el textField al panel contenedor

			lblMail = new JLabel("Mail:");
			lblMail.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 2; // n�mero fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblMail, gbc); // agregar el label al panel contenedor

			txtMail = new JTextField();
			gbc.gridx = 1; // n�mero columna
			gbc.gridy = 2; // n�mero fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtMail, gbc); // agregar el textField al panel contenedor

			lblPuesto = new JLabel("Puesto");
			lblPuesto.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 3; // n�mero fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblPuesto, gbc); // agregar el label al panel contenedor

			txtPuesto = new JTextField();
			gbc.gridx = 1; // n�mero columna
			gbc.gridy = 3; // n�mero fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtPuesto, gbc); // agregar el textField al panel contenedor

			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el nombre");
						txtNombre.requestFocusInWindow();
						return;
					}

					if(txtTelefono.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el tel�fono");
						txtTelefono.requestFocusInWindow();
						return;
					}

					if(txtMail.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el mail");
						txtMail.requestFocusInWindow();
						return;
					}
					
					if(txtPuesto.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el puesto");
						txtPuesto.requestFocusInWindow();
						return;
					}

					if(id == -1)
						AreaAdministracion.getInstancia().agregarEmpleado(txtNombre.getText(), txtTelefono.getText(), txtMail.getText(), txtPuesto.getText());
					else {
						try {
							AreaAdministracion.getInstancia().modificarEmpleado(entidad.getCodigo(), txtNombre.getText(), txtTelefono.getText(), txtMail.getText(), txtPuesto.getText());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					closeWin();
				}
			});

			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 4; // n�mero fila
			gbc.gridwidth = 2; // numero de columnas de ancho
			gbc.fill = GridBagConstraints.NONE; // rellenar la celda en ambos sentidos (horizontal y vertical)
			pnlCentro.add(btnGuardar, gbc); // agregar el textField al panel contenedor

			return pnlCentro;
		}

		private void closeWin() {
			this.setVisible(false);
			lst.fillTable();
			this.dispose();
		}
	}


