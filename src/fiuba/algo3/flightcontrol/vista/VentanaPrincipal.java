package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;
import fiuba.algo3.flightcontrol.vista.ObservadorGameLoop;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;
public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;
	private Dimension tamano;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			tamano = tk.getScreenSize();
			
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
				
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(0, 0, tamano.width, tamano.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Flight Control");
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnDetener = this.addBotonDetener();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		final Nivel unNivel = new Nivel(10,tamano.height-60);
		final List<Vector> unaLista = new ArrayList<Vector>(); 
		
		this.inicializarModelo((SuperficieDeDibujo) panel, unNivel);
				
		this.addKeyListener();

		this.setComponentsFocus(btnIniciar, btnDetener);

		
				
		panel.addMouseListener(new MouseAdapter() {
				
			private ObjetoVolador unAvion;
			private List<Vector> unaLista;
			private JPanel panel;
			JFrame frame;
			
			@Override
			public void mouseClicked(MouseEvent click) {	
				
				JTextArea textArea = new JTextArea();
				textArea.setLineWrap(true);
				if (frame == null) {
					frame = new JFrame("ATENCION");
					frame.setBounds(50, 200, 200, 70);	
				}

				if (click.isAltDown()) {
					if (this.unAvion == null) {
					
						this.unAvion = this.obtenerAvion(click);
						if (this.unAvion != null) {
							unaLista = new ArrayList<Vector>();
							
							textArea.setText("Agarro un Objeto Volador");
							frame.getContentPane().add(textArea);
							frame.setVisible(true);

						}
					
					} else {
						
						Vector posicionClick = new Vector (click.getX(),click.getY());
						unaLista.add(posicionClick);
						
						textArea.setText("Seteo una Posicion");
						frame.getContentPane().add(textArea);
						frame.setVisible(true);
					}
					
				} else {
						
					if (this.unAvion != null) {
						Trayectoria unaTrayectoria = new Trayectoria(unaLista);
						this.unAvion.setTrayectoria(unaTrayectoria);
						this.unAvion = null;
						
						textArea.setText("Seteo una nueva Trayectoria");
						frame.getContentPane().add(textArea);
						frame.setVisible(true);
					}
						
				}
					
			}
		

			private ObjetoVolador obtenerAvion(MouseEvent click) {
				boolean encontrado = false;
				ObjetoVolador unAvion, avionEncontrado = null;
				Vector posicionClick = new Vector (click.getX(),click.getY());
				Vector posicionDeAvion;
				double diferencia;
				
				Iterator<ObjetoVolador> it = unNivel.getObjetosVoladores();
				while (it.hasNext() && !encontrado) {
					unAvion = it.next();
					posicionDeAvion = unAvion.getPosicion();
					diferencia =  posicionClick.distancia(posicionDeAvion);
					encontrado = (diferencia <= 20);
					
					if (encontrado){ 
						avionEncontrado = unAvion;
					}
				}
				
				return avionEncontrado;
			}});
		}

	private void inicializarModelo(SuperficieDeDibujo unPanel, Nivel unNivel) {
		
		ObservadorDeNivel observadorDeNivel = new ObservadorDeNivel(gameLoop, (SuperficieDeDibujo)unPanel, unNivel);
		unNivel.addObserver(observadorDeNivel);
		ObservadorDeGameLoop observadorGameLoop = new ObservadorGameLoop(observadorDeNivel, gameLoop, (SuperficieDeDibujo)unPanel );
		//guardo el observador del gameLoop
		this.gameLoop.agregarObservador(observadorGameLoop);
		this.gameLoop.agregar(unNivel);
	
		Iterator<Pista> it = unNivel.getPistas();
		while (it.hasNext()) {
			Pista unaPista = it.next();
			Rectangulo cuadrado = new VistaPista(unaPista);
			this.gameLoop.agregar(cuadrado);
		}		
	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
		
	}

	private void addKeyListener() {
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				//System.out.println("Key pressed");

			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				//System.out.println("Ping");
			}  
			 	
		});
	}
	
	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 150, 0));
		System.out.println(tamano.width);
		System.out.println(tamano.height);
		panel.setBounds(350, 5, tamano.height-40, tamano.height-40);
		frame.getContentPane().add(panel);
		return panel;
	}
	
	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(50, 20, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}

	private JButton addBotonDetener() {
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(50, 50, 92, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}
	
}