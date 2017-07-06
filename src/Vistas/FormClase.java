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

import javax.swing.*;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePickerImpl;

import Controlador.AreaAdministracion;
import Negocio.Socio;
import ViewModels.VistaClase;
import ViewModels.VistaProfesor;
import ViewModels.VistaSocio;

public class FormClase extends JFrame{
	private JPanel pnlContenedor;
	private JPanel pnlCentro;
	private JButton btnGuardar;
	private JLabel lblTitulo;
	private JLabel lblDia;
	private JLabel lblHorario;
	private JTextField txtDía;
	private JTextField txtHora;
	VistaClase entidad;
	//private JComboBox<VistaProfesor> cmbProfesor;
	private int id;
	private ListadoClase lst;
	FormClase that = this;

	public FormClase(String frameTitle, int codigo, ListadoClase lst) {
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
			VistaSocio claseAEditar = null;
			for(VistaClase currentVistaClase: lst.items){
				if(currentVistaClase.getCodigo() == id){
					this.entidad = currentVistaClase;
					break;
				}
			}
			bindView();
		}
		
		// Mostrar la ventana
		this.setVisible(true);
	}
	
	private void bindView(){
		txtDía.setText(entidad.getDia());
		txtHora.setText(entidad.getHora());
	}

	private JPanel getPanelContenedor() {
		pnlContenedor = new JPanel();
		pnlContenedor.setLayout(new BorderLayout());
		if(this.id == -1) 
			lblTitulo = new JLabel("Alta Clase");
		else
			lblTitulo = new JLabel("Editar Clase");
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

		lblDia = new JLabel("Día:");
		lblDia.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // n�mero columna
		gbc.gridy = 0; // n�mero fila
		gbc.gridwidth = 1; // numero de columnas de ancho
		gbc.gridheight = 1; // numero de filas de ancho
		gbc.weightx = 0.1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
		gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
		pnlCentro.add(lblDia, gbc); // agregar el label al panel contenedor

		txtDía = new JTextField();
		gbc.gridx = 1; // n�mero columna
		gbc.gridy = 0; // n�mero fila
		gbc.weightx = 0.9;
		pnlCentro.add(txtDía, gbc); // agregar el textField al panel contenedor

		lblHorario = new JLabel("Hora:");
		lblHorario.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // n�mero columna
		gbc.gridy = 1; // n�mero fila
		gbc.weightx = 0.1;
		pnlCentro.add(lblHorario, gbc); // agregar el label al panel contenedor

		txtHora = new JTextField();
		gbc.gridx = 1; // n�mero columna
		gbc.gridy = 1; // n�mero fila
		gbc.weightx = 0.9;
		pnlCentro.add(txtHora, gbc); // agregar el textField al panel contenedor

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDía.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese el día");
					txtDía.requestFocusInWindow();
					return;
				}

				if(txtHora.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese la hora");
					txtHora.requestFocusInWindow();
					return;
				}

				if(id == -1)
					AreaAdministracion.getInstancia().agregarClase(txtDía.getText(), txtHora.getText());
				else {
					try {
						AreaAdministracion.getInstancia().modificarClase(entidad.getCodigo(), txtDía.getText(), txtHora.getText());
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