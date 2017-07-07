
package Vistas;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.Iterator;

import Controlador.AreaAdministracion;
import Vistas.ListadoEmpleado;

public class PanelDeControl extends JFrame {
	
		private JPanel pnlContenedor;
		private JPanel pnlCentro;
		private JLabel lblTitle;

		public static void main(String[] args) {
			new PanelDeControl();
		}

		public PanelDeControl() {
			// Establecer el titulo de la ventana
			this.setTitle("Panel de Control");
			// Establecer la dimension de la ventana (ancho, alto)
			this.setSize(450, 300);
			// Establecer NO dimensionable la ventana
			this.setResizable(false);
			// Ubicar la ventana en el centro de la pantalla
			this.setLocationRelativeTo(null);
			// Cerrar la ventana al hacer click en boton de X (cerrar)
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			// Agregar el panel al JFrame
			this.getContentPane().add(this.getPanelContenedor());
			// Mostrar la ventana
			this.setVisible(true);
		}

		private JPanel getPanelContenedor() {
			// crear panel contenedor
			pnlContenedor = new JPanel();
			// crear panel del centro
			pnlCentro = new JPanel();
			// setear el layout manager del panel contenedor
			pnlContenedor.setLayout(new BorderLayout());
			// A�adir el menu al panel contenedor
			pnlContenedor.add(getMenu(), BorderLayout.PAGE_START);
			// A�adir el panel del centro al panel contenedor
			pnlContenedor.add(getPanelCentro(), BorderLayout.CENTER);
			return pnlContenedor;
		}

		private JPanel getPanelCentro() {
			// setear el layout manager del panel del centro
			pnlCentro.setLayout(new BorderLayout());

			lblTitle = new JLabel("Administracion de Gimnasio");
			lblTitle.setFont(new Font("Serif", Font.BOLD, 30));
			lblTitle.setHorizontalAlignment(JLabel.CENTER);

			pnlCentro.add(lblTitle, BorderLayout.PAGE_START);
			pnlCentro.add(getImg(), BorderLayout.CENTER);

			return pnlCentro;
		}

		private JMenuBar getMenu() {
			JMenuBar menuBar = new JMenuBar();
			JMenu fileMenu = new JMenu("Archivo");
			JMenu abmMenu = new JMenu("ABM");
			JMenu IngresoMenu = new JMenu("Ingreso");
			JMenu notificacionesMenu = new JMenu("Notificaciones");
			JMenu cronogramaMenu = new JMenu("Cronograma");
			JMenu liquidacionMenu = new JMenu("Liquidacion");
			menuBar.add(fileMenu);
			menuBar.add(abmMenu);
			menuBar.add(notificacionesMenu);
			menuBar.add(cronogramaMenu);
			menuBar.add(IngresoMenu);
			menuBar.add(liquidacionMenu);
			
			JMenuItem close = new JMenuItem("Cerrar");
			close.addActionListener(new ActionListener() {
			

				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
					
				}
			});

			JMenuItem listadoSocios = new JMenuItem("Socios");
			listadoSocios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ListadoSocio();
				}
			});

			JMenuItem listadoEmpleados = new JMenuItem("Empleados");
			listadoEmpleados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ListadoEmpleado();
				}
			});

			JMenuItem listadoDeportes = new JMenuItem("Deportes");
			listadoDeportes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ListadoDeporte();
				}
			});

			JMenuItem listadoClases = new JMenuItem("Clases");
			listadoClases.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ListadoClase();
				}
			});

			JMenuItem listadoAbono = new JMenuItem("Abono");
			listadoAbono.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ListadoAbono();
				}
			});

			JMenuItem listadoFacturas = new JMenuItem("Facturas");
			listadoFacturas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Listado Facturas");
				}
			});

			JMenuItem liquidacionDeSueldo = new JMenuItem(
					"liquidacionDeSueldo");
			liquidacionDeSueldo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Liquidador();
				}
			});

			JMenuItem validarIngreso = new JMenuItem(
					"Validar Ingreso");
			validarIngreso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Listado Validar Ingreso");
				}
			});

			JMenuItem mailMasivoNovedades = new JMenuItem(
					"Mail Masivo de Novedades");
			mailMasivoNovedades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {				
					
					List<String> emails = AreaAdministracion.getInstancia().obtenerEmailSocios();
					String URI = "mailto:";
					String mailto = "";
					List<String> to = new LinkedList<>();
					
					for (String object: emails) {							
						to = emails;						
						mailto = String.join(";", to);						
					}			 
					
					try {
						Desktop.getDesktop().mail(new URI(URI+mailto));
					} catch (IOException e1) {						
						e1.printStackTrace();
					} catch (URISyntaxException e1) {						
						e1.printStackTrace();
					}
				}
			});

			JMenuItem mailFiltro = new JMenuItem(
					"Mail por Filtro");
			mailFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Listado Mail por Filtro");
				}
			});
			

			JMenuItem cronograma = new JMenuItem(
					"Cronograma");
			cronograma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Cronograma();
				}
			});

			fileMenu.add(close);

			abmMenu.add(listadoSocios);
			abmMenu.add(listadoEmpleados);
			abmMenu.add(listadoDeportes);
			abmMenu.add(listadoClases);
			abmMenu.add(listadoAbono);
			abmMenu.add(validarIngreso);

			notificacionesMenu.add(mailMasivoNovedades);
			notificacionesMenu.add(mailFiltro);
			
			cronogramaMenu.add(cronograma);
			
			IngresoMenu.add(validarIngreso);
			
			liquidacionMenu.add(liquidacionDeSueldo);
			
			return menuBar;
		}

		private JLabel getImg() {
			JLabel picLabel = null;
			try {
				String pathImg = "img/gym.jpg";
				BufferedImage img = ImageIO.read(new java.io.File(pathImg));
				picLabel = new JLabel(new ImageIcon(img));
			} catch(IOException e) {
				e.printStackTrace();
			}
			return picLabel;
		}
	}

