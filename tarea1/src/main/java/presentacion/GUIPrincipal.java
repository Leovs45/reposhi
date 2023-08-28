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

public class GUIPrincipal {

	private JFrame frame;
	private GUIAltaUsuario altaUsuarioInternalFrame;
	private GUIAltaInstitucion altaInstitucionInternalFrame;
	private GUIAltaActividad altaActividadInternalFrame;
	private GUIAltaDictadoClase altaClaseInternalFrame;
	private GUIConsultaUsuario consultaUsuarioInternalFrame;
	private GUIConsultaInstitucion consultaInstitucionInternalFrame;
	private GUIConsultaActividadDeportiva consultaActividadInternalFrame;
	private GUIAltaRegistroDictadoClase registroDictadoClaseInternalFrame;
	private GUIModificarUsuario modificarUsuarioInternalFrame;
	private GUIModificarInstitucion modificarInstitucionInternalFrame;
	private GUIModificarActividad modificarActividadInternalFrame;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		altaClaseInternalFrame = new GUIAltaDictadoClase(iClase); 
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
		consultaActividadInternalFrame = new GUIConsultaActividadDeportiva(iActividad);
		jInternalFrameSize = consultaActividadInternalFrame.getSize();
		consultaActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		consultaActividadInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaActividadInternalFrame);
		
		//Crea frame de Registro Dictado de Clase
		registroDictadoClaseInternalFrame = new GUIAltaRegistroDictadoClase(iRegistro);
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
			}
		});
		menuConsultas.add(menuItemConsultaActividad);
		
		// CONSULTA DICTADO DE CLASE
		JMenuItem menuItemConsultaDictadoClase = new JMenuItem("Consultar Dictado de Clase");
		menuConsultas.add(menuItemConsultaDictadoClase);
		
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
			}
		});
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		menuBar.add(mntmSalir);
	}
}
