package Vistas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Ejemplo de uso de JComboBox.
 * 
 * @author chuidiang
 */
public class jComboBox {

	private JTextField tf;
	private JComboBox combo;
	private JFrame v;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new jComboBox();
	}

	public jComboBox() {
		// Creacion del JTextField
		tf = new JTextField(20);

		// Creacion del JComboBox y a�adir los items.
		combo = new JComboBox();
		combo.addItem("uno");
		combo.addItem("dos");
		combo.addItem("tres");

		// Accion a realizar cuando el JComboBox cambia de item seleccionado.
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.setText(combo.getSelectedItem().toString());
			}
		});

		// Creacion de la ventana con los componentes
		v = new JFrame();
		v.getContentPane().setLayout(new FlowLayout());
		v.getContentPane().add(combo);
		v.getContentPane().add(tf);
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
