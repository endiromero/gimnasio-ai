package Vistas;
import info.clearthought.layout.TableLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AsignarClase extends javax.swing.JFrame {
	private JButton jAsignarClase;
	private JButton jVerClases;
	private JTextField jTextDeporte;
	private JScrollPane jScrollPane1;
	private JTable jTableClases;
	private JTextField jTextClase;
	private JComboBox jVerClase;
	private JComboBox jListDeportes;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		new AsignarClase();
	}
		
	public AsignarClase() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Elegir Clase");
			{
				jAsignarClase = new JButton();
				getContentPane().add(jAsignarClase);
				jAsignarClase.setText("Asignar");
				jAsignarClase.setBounds(112, 185, 78, 23);
			}
			{
				jVerClases = new JButton();
				getContentPane().add(jVerClases);
				jVerClases.setText("Ver Horarios");
				jVerClases.setBounds(297, 35, 79, 23);
			}
			{
				ComboBoxModel jListDeportesModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				jListDeportes = new JComboBox();
				getContentPane().add(jListDeportes);
				jListDeportes.setModel(jListDeportesModel);
				jListDeportes.setBounds(19, 35, 100, 23);
			}
			{
				ComboBoxModel jVerClaseModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				jVerClase = new JComboBox();
				getContentPane().add(jVerClase);
				jVerClase.setModel(jVerClaseModel);
				jVerClase.setBounds(152, 35, 92, 23);
			}
			{
				jTextDeporte = new JTextField();
				getContentPane().add(jTextDeporte);
				jTextDeporte.setText("Deporte");
				jTextDeporte.setBounds(43, 7, 55, 23);
			}
			{
				jTextClase = new JTextField();
				getContentPane().add(jTextClase);
				jTextClase.setText("Actividad");
				jTextClase.setBounds(164, 7, 63, 23);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(19, 85, 258, 88);
				jScrollPane1.setName("");
				{
					TableModel jTableClasesModel = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTableClases = new JTable();
					jScrollPane1.setViewportView(jTableClases);
					jTableClases.setModel(jTableClasesModel);
					jTableClases.setBounds(19, 85, 225, 88);
				}
			}
			pack();
			this.setSize(428, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
