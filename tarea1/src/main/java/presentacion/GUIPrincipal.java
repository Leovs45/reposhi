package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.*;
import presentacionAltas.*;
import presentacionConsultas.*;
import presentacionModificacion.*;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import publicadores.publicadorActividadDeportiva;
import publicadores.publicadorConsultaUsuario;

public class GUIPrincipal {

	private JFrame frame;
	private GUIAltaUsuario altaUsuarioInternalFrame;
	private GUIAltaInstitucion altaInstitucionInternalFrame;
	private GUIAltaActividad altaActividadInternalFrame;
	private GUIAltaDictadoClase altaClaseInternalFrame;
	private GUIConsultaUsuario consultaUsuarioInternalFrame;
	private GUIConsultaActividadDeportiva consultaActividadInternalFrame;
	private GUIConsultaDictadoClase consultaDictadoClaseInternalFrame;
	private GUIRegistroDictadoClase registroDictadoClaseInternalFrame;
	private GUIModificarUsuario modificarUsuarioInternalFrame;
	private GUIModificarInstitucion modificarInstitucionInternalFrame;
	private GUIModificarActividad modificarActividadInternalFrame;
	private GUIRankingActividadDeportiva rankingActividadInternalFrame;
	private GUIRankingDictadoClase rankingClaseInternalFrame;
	

	public static void main(String[] args) {
		
	//===================== agregado para tarea 3 =====================//
		publicadorActividadDeportiva pad = new publicadorActividadDeportiva();
		publicadorConsultaUsuario pcu= new publicadorConsultaUsuario();
	    pad.publicar();
	    pcu.publicar();
	//===================== agregado para tarea 3 =====================//      
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Tirando_datos td= new Tirando_datos();
					//td.rellenarDatos();
					GUIPrincipal window = new GUIPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIPrincipal() {
		initialize();
		
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		IRegistro iRegistro = f.getIRegistro();
		IClase iClase = f.getIClase();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		// Crea frame de alta Usuario
		altaUsuarioInternalFrame = new GUIAltaUsuario(iUsuario, iInstitucion);
		jInternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioInternalFrame);
		altaUsuarioInternalFrame.getContentPane().setLayout(null);
		
		// Crea frame de alta institucion
		altaInstitucionInternalFrame = new GUIAltaInstitucion(iInstitucion); 
		jInternalFrameSize = altaInstitucionInternalFrame.getSize();
		altaInstitucionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaInstitucionInternalFrame.setVisible(false);
		frame.getContentPane().add(altaInstitucionInternalFrame);
		
		// Crea frame de alta actividad
		altaActividadInternalFrame = new GUIAltaActividad(iActividad, iInstitucion); 
		jInternalFrameSize = altaActividadInternalFrame.getSize();
		altaActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaActividadInternalFrame.setVisible(false);
		frame.getContentPane().add(altaActividadInternalFrame);
		
		// Crea frame de alta clase
		altaClaseInternalFrame = new GUIAltaDictadoClase(iClase, iInstitucion, iActividad, iUsuario); 
		jInternalFrameSize = altaClaseInternalFrame.getSize();
		altaClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaClaseInternalFrame.setVisible(false);
		frame.getContentPane().add(altaClaseInternalFrame);
		
		// Crea frame de Consulta Usuario
		consultaUsuarioInternalFrame = new GUIConsultaUsuario(iUsuario);
		jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		consultaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		
		//Crea frame de Consulta Actividad Deportiva
		consultaActividadInternalFrame = new GUIConsultaActividadDeportiva(iActividad, iInstitucion);
		jInternalFrameSize = consultaActividadInternalFrame.getSize();
		consultaActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		consultaActividadInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaActividadInternalFrame);
		
		//Crea frame de Registro Dictado de Clase
		registroDictadoClaseInternalFrame = new GUIRegistroDictadoClase(iRegistro, iUsuario, iInstitucion);
		jInternalFrameSize = registroDictadoClaseInternalFrame.getSize();
		registroDictadoClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		registroDictadoClaseInternalFrame.setVisible(false);
		frame.getContentPane().add(registroDictadoClaseInternalFrame);
		
		//Crea frame de modificar usuario
		modificarUsuarioInternalFrame = new GUIModificarUsuario(iUsuario);
		jInternalFrameSize = modificarUsuarioInternalFrame.getSize();
		modificarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		modificarUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(modificarUsuarioInternalFrame);
		
		//Crea frame de modificar institucion
		modificarInstitucionInternalFrame = new GUIModificarInstitucion(iInstitucion);
		jInternalFrameSize = modificarInstitucionInternalFrame.getSize();
		modificarInstitucionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		modificarInstitucionInternalFrame.setVisible(false);
		modificarInstitucionInternalFrame.getContentPane().setLayout(null);
		frame.getContentPane().add(modificarInstitucionInternalFrame);
		
		//Crea frame modificar actividad
		modificarActividadInternalFrame = new GUIModificarActividad(iActividad);
		jInternalFrameSize = modificarActividadInternalFrame.getSize();
		modificarActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		modificarActividadInternalFrame.setVisible(false);
		frame.getContentPane().add(modificarActividadInternalFrame);
		modificarActividadInternalFrame.getContentPane().setLayout(null);
		
		//Crea fram consulta dictado clase
		consultaDictadoClaseInternalFrame = new GUIConsultaDictadoClase(iInstitucion);
		jInternalFrameSize = consultaDictadoClaseInternalFrame.getSize();
		consultaDictadoClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		consultaDictadoClaseInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaDictadoClaseInternalFrame);
		consultaDictadoClaseInternalFrame.getContentPane().setLayout(null);
		
		//Crea fram ranking Actividad
		
		rankingActividadInternalFrame = new GUIRankingActividadDeportiva(iActividad);
		jInternalFrameSize = rankingActividadInternalFrame.getSize();
		rankingActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		rankingActividadInternalFrame.setVisible(false);
		frame.getContentPane().add(rankingActividadInternalFrame);
		rankingActividadInternalFrame.getContentPane().setLayout(null);	
			
		//Crea fram ranking Clase
		rankingClaseInternalFrame = new GUIRankingDictadoClase(iClase);
		jInternalFrameSize = rankingClaseInternalFrame.getSize();
		rankingClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		rankingClaseInternalFrame.setVisible(false);
		frame.getContentPane().add(rankingClaseInternalFrame);
		rankingClaseInternalFrame.getContentPane().setLayout(null);	
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuAltas = new JMenu("Altas");
		menuBar.add(menuAltas);
		
		
		// ALTA USUARIO
		JMenuItem menuAltaUsuario = new JMenuItem("Alta usuario");
		menuAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.setVisible(true);
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			
			}
		});
		menuAltas.add(menuAltaUsuario);
		
		// ALTA INSTITUCION
		JMenuItem menuItemAltaItDeportiva = new JMenuItem("Alta institucion deportiva");
		menuItemAltaItDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.setVisible(true);
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		menuAltas.add(menuItemAltaItDeportiva);
		
		// ALTA ACTIVIDAD
		JMenuItem menuItemAltaActDeportiva = new JMenuItem("Alta actividad deportiva");
		menuItemAltaActDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.setVisible(true);
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		menuAltas.add(menuItemAltaActDeportiva);
		
		// ALTA CLASE
		JMenuItem menuItemAltaClase = new JMenuItem("Alta dictado de clase");
		menuItemAltaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(true);
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		menuAltas.add(menuItemAltaClase);
		
		// ALTA DICTADO CLASE
		JMenuItem mntmRegistroDeDictado = new JMenuItem("Registro dictado de clase");
		mntmRegistroDeDictado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.setVisible(true);
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
				
			}
		});
		menuAltas.add(mntmRegistroDeDictado);
		
		JMenu menuConsultas = new JMenu("Consultas");
		menuBar.add(menuConsultas);
		
		// CONSULTA USUARIO
		JMenuItem menuItemConsultaUsuario = new JMenuItem("Consultar Usuario");
		menuItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.setVisible(true);
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		menuConsultas.add(menuItemConsultaUsuario);
		
		// CONSULTA ACTIVIDAD
		JMenuItem menuItemConsultaActividad = new JMenuItem("Consultar Actividad Deportiva");
		menuItemConsultaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.setVisible(true);
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		menuConsultas.add(menuItemConsultaActividad);
		
		// CONSULTA DICTADO DE CLASE
		JMenuItem menuItemConsultaDictadoClase = new JMenuItem("Consultar Dictado de Clase");
		menuConsultas.add(menuItemConsultaDictadoClase);
		menuItemConsultaDictadoClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.setVisible(true);
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		
		// RANKING CLASE
		
		JMenuItem menuConsultarRankingClase = new JMenuItem("Ranking de Dictados de Clase");
		menuConsultas.add(menuConsultarRankingClase);
		menuConsultarRankingClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.setVisible(true);
			}
		});
		
		//RANKING ACTIVIDADES
		
		JMenuItem menuConsultarRankingAct = new JMenuItem("Ranking de Actividades Deportivas");
		menuConsultas.add(menuConsultarRankingAct);
		menuConsultarRankingAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.setVisible(true);
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
		
		
		JMenu menuModificaciones = new JMenu("Modificaciones");
		menuBar.add(menuModificaciones);
		
		// MODIFICAR USUARIO
		JMenuItem menuItemModificarUsuario = new JMenuItem("Modificar Usuario");
		menuModificaciones.add(menuItemModificarUsuario);
		menuItemModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.setVisible(true);
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
				
				
			}
		});
		
		// MODIFICAR ACTIVIDAD
		JMenuItem menuItemModificarActividad = new JMenuItem("Modificar Actividad Deportiva");
		menuModificaciones.add(menuItemModificarActividad);
		menuItemModificarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.doDefaultCloseAction();
				modificarActividadInternalFrame.setVisible(true);
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
			
		// MODIFICAR INSTITUCION
		JMenuItem menuItemModificarInstitucion = new JMenuItem("Modificar Institución Deportiva");
		menuModificaciones.add(menuItemModificarInstitucion);
		menuItemModificarInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.doDefaultCloseAction();
				altaActividadInternalFrame.doDefaultCloseAction();
				altaInstitucionInternalFrame.doDefaultCloseAction();
				altaUsuarioInternalFrame.doDefaultCloseAction();
				consultaUsuarioInternalFrame.doDefaultCloseAction();
				consultaActividadInternalFrame.doDefaultCloseAction();
				registroDictadoClaseInternalFrame.doDefaultCloseAction();
				modificarUsuarioInternalFrame.doDefaultCloseAction();
				modificarInstitucionInternalFrame.setVisible(true);
				modificarActividadInternalFrame.doDefaultCloseAction();
				consultaDictadoClaseInternalFrame.doDefaultCloseAction();
				rankingActividadInternalFrame.doDefaultCloseAction();
				rankingClaseInternalFrame.doDefaultCloseAction();
			}
		});
	}
}
