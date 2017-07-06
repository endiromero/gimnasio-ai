package Vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.AreaAdministracion;
import Excepciones.SocioException;
import Excepciones.SueldoExcepcion;

public class Liquidador extends JFrame {

	private static final long serialVersionUID = 7566473429806604750L;
	private JPanel contentPane;
	private JTextField mes;
	private JTextField año;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Liquidador frame = new Liquidador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Liquidador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Liquidacion de Sueldos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		this.setVisible(true);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(22, 41, 46, 14);
		contentPane.add(lblMes);
		
		mes = new JTextField();
		mes.setBounds(91, 38, 86, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(22, 92, 46, 14);
		contentPane.add(lblAo);
		
		año = new JTextField();
		año.setBounds(91, 89, 86, 20);
		contentPane.add(año);
		año.setColumns(10);
		
		JButton btnLiquidarSueldos = new JButton("Liquidar Sueldos");
		btnLiquidarSueldos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				float totalSueldos;
				try {
					System.out.println("entro al action");
					totalSueldos = AreaAdministracion.getInstancia().liquidarSueldos(Integer.parseInt(mes.getText()), Integer.parseInt(año.getText()));
					JOptionPane.showMessageDialog(null,"El total de sueldos liquidados es : " + totalSueldos," Total Sueldos Liquidados ",JOptionPane.INFORMATION_MESSAGE);
					System.out.println("finaliza al action");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Alguno de los datos ingresados es incorrecto");
				} catch (SocioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLiquidarSueldos.setBounds(110, 160, 160, 23);
		contentPane.add(btnLiquidarSueldos);
	}
}


