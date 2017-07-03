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
import ViewModels.VistaDeporte;
import ViewModels.VistaSocio;

	public class FormDeporte extends JFrame{
		private JPanel pnlContenedor;
		private JPanel pnlCentro;
		private JButton btnGuardar;
		private JLabel lblTitulo;
		private JLabel lblTituloDeporte;
		private JLabel lblDescripcion;
		VistaDeporte entidad;
		private JTextField txtTituloDeporte;
		private JTextField txtDescripcion;
		private int id;
		private ListadoDeporte lst;
		FormDeporte that = this;

		public FormDeporte(String frameTitle, int idDeporte, ListadoDeporte lst) {
			this.id = idDeporte;
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
			
			if(idDeporte != -1){
				VistaDeporte deporteAEditar = null;
				for(VistaDeporte currentVistaDeporte: lst.items){
					if(currentVistaDeporte.getIdDeporte() == id){
						this.entidad = currentVistaDeporte;
						break;
					}
				}
				bindView();
			}
			
			// Mostrar la ventana
			this.setVisible(true);
		}
		
		private void bindView(){
			txtTituloDeporte.setText(entidad.getTitulo());
			txtDescripcion.setText(entidad.getDescripcion());
		}

		private JPanel getPanelContenedor() {
			pnlContenedor = new JPanel();
			pnlContenedor.setLayout(new BorderLayout());
			if(this.id == -1) 
				lblTitulo = new JLabel("Alta Deporte");
			else
				lblTitulo = new JLabel("Edicion Deporte");
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

			lblTituloDeporte = new JLabel("Titulo:");
			lblTituloDeporte.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 0; // n�mero fila
			gbc.gridwidth = 1; // numero de columnas de ancho
			gbc.gridheight = 1; // numero de filas de ancho
			gbc.weightx = 0.1;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.HORIZONTAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
			gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
			pnlCentro.add(lblTituloDeporte, gbc); // agregar el label al panel contenedor

			txtTituloDeporte = new JTextField();
			gbc.gridx = 1; // n�mero columna
			gbc.gridy = 0; // n�mero fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtTituloDeporte, gbc); // agregar el textField al panel contenedor

			lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // n�mero columna
			gbc.gridy = 1; // n�mero fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblDescripcion, gbc); // agregar el label al panel contenedor

			txtDescripcion = new JTextField();
			gbc.gridx = 1; // n�mero columna
			gbc.gridy = 1; // n�mero fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtDescripcion, gbc); // agregar el textField al panel contenedor

			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtTituloDeporte.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el titulo");
						txtTituloDeporte.requestFocusInWindow();
						return;
					}

					if(txtDescripcion.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese la descripcion");
						txtDescripcion.requestFocusInWindow();
						return;
					}

					if(id == -1)
						AreaAdministracion.getInstancia().agregarDeporte(txtTituloDeporte.getText(), txtDescripcion.getText());
					else {
						try {
							AreaAdministracion.getInstancia().modificarDeporte(entidad.getIdDeporte(), txtTituloDeporte.getText(), txtDescripcion.getText());
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


