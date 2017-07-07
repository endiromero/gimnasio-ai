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
import ViewModels.VistaAbono;
import ViewModels.VistaSocio;

	public class FormAbono extends JFrame{
		private JPanel pnlContenedor;
		private JPanel pnlCentro;
		private JButton btnGuardar;
		private JLabel lblTitulo;
		private JLabel lblNombre;
		private JLabel lblPrecio;
		private JLabel lblVigencia;
		private JTextField txtNombre;
		VistaAbono entidad;
		private JTextField txtPrecio;
		private JTextField txtVigencia;
		private int id;
		private ListadoAbono lst;
		FormAbono that = this;

		public FormAbono(String frameTitle, int idAbono, ListadoAbono listadoAbono) {
			this.id = idAbono;
			this.lst = listadoAbono;
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
			
			if(idAbono != -1){
				VistaAbono abonoAEditar = null;
				for(VistaAbono currentVistaAbono: listadoAbono.items){
					if(currentVistaAbono.getIdAbono() == id){
						this.entidad = currentVistaAbono;
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
		}

		private JPanel getPanelContenedor() {
			pnlContenedor = new JPanel();
			pnlContenedor.setLayout(new BorderLayout());
			if(this.id == -1) 
				lblTitulo = new JLabel("Alta Cliente");
			else
				lblTitulo = new JLabel("Editar Socio");
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

			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Por favor ingrese el nombre");
						txtNombre.requestFocusInWindow();
						return;
					}

					if(id == -1)
						;//AreaAdministracion.getInstancia().agregarAbono(txtNombre.getText());
					else {
						try {
							//AreaAdministracion.getInstancia().modificarSocio(entidad.getIdSocio(), txtNombre.getText(), txtDomicilio.getText(), txtTelefono.getText(), txtMail.getText());
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
			lst.fillTable("");
			this.dispose();
		}
	}


