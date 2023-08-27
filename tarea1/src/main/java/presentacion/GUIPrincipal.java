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
	private GUIRegistroDictadoClase registroDictadoClaseInternalFrame;
	private GUIModificarUsuarioNombre modificarUsuarioNombre;
	private GUIModificarUsuarioApellido modificarUsuarioApellido;
	private GUIModificarUsuarioFechaNacimiento modificarUsuarioFechaNacimiento;
	private GUIModificarInstitucionDescripcion modificarInstitucionDescripcion;
	private GUIModificarInstitucionURL modificarInstitucionURL;
	private GUIModificarActividadDescripcion modificarActividadDescripcion;
	private GUIModificarActividadDuracion modificarUsuarioNombActividadDuracion;
	private GUIModificarActividadCosto modificarActividadCosto;
	

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
		registroDictadoClaseInternalFrame = new GUIRegistroDictadoClase(iRegistro);
		jInternalFrameSize = registroDictadoClaseInternalFrame.getSize();
		registroDictadoClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		registroDictadoClaseInternalFrame.setVisible(false);
		frame.getContentPane().add(registroDictadoClaseInternalFrame);
		
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuAltas = new JMenu("Altas");
		menuBar.add(menuAltas);
		
		//JMenu menuAltaUsuario = new JMenu("Alta usuario");
		//menuAltas.add(menuAltaUsuario);
		JMenuItem menuAltaUsuario = new JMenuItem("Alta usuario");
		menuAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(false);
				altaActividadInternalFrame.setVisible(false);
				altaInstitucionInternalFrame.setVisible(false);
				altaUsuarioInternalFrame.setVisible(true);
				consultaUsuarioInternalFrame.setVisible(false);
				consultaActividadInternalFrame.setVisible(false);
				registroDictadoClaseInternalFrame.setVisible(false);
			}
		});
		menuAltas.add(menuAltaUsuario);
		
		JMenuItem menuItemAltaItDeportiva = new JMenuItem("Alta institucion deportiva");
		menuItemAltaItDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(false);
				altaActividadInternalFrame.setVisible(false);
				altaInstitucionInternalFrame.setVisible(true);
				altaUsuarioInternalFrame.setVisible(false);
				consultaUsuarioInternalFrame.setVisible(false);
				consultaActividadInternalFrame.setVisible(false);
				registroDictadoClaseInternalFrame.setVisible(false);
			}
		});
		menuAltas.add(menuItemAltaItDeportiva);
		
		JMenuItem menuItemAltaActDeportiva = new JMenuItem("Alta actividad deportiva");
		menuItemAltaActDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(false);
				altaActividadInternalFrame.setVisible(true);
				altaInstitucionInternalFrame.setVisible(false);
				altaUsuarioInternalFrame.setVisible(false);
				consultaUsuarioInternalFrame.setVisible(false);
				consultaActividadInternalFrame.setVisible(false);
				registroDictadoClaseInternalFrame.setVisible(false);
			}
		});
		menuAltas.add(menuItemAltaActDeportiva);
		
		JMenuItem menuItemAltaClase = new JMenuItem("Alta dictado de clase");
		menuItemAltaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(true);
				altaActividadInternalFrame.setVisible(false);
				altaInstitucionInternalFrame.setVisible(false);
				altaUsuarioInternalFrame.setVisible(false);
				consultaUsuarioInternalFrame.setVisible(false);
				consultaActividadInternalFrame.setVisible(false);
				registroDictadoClaseInternalFrame.setVisible(false);
			}
		});
		menuAltas.add(menuItemAltaClase);
		
		JMenuItem mntmRegistroDeDictado = new JMenuItem("Registro dictado de clase");
		mntmRegistroDeDictado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(false);
				altaActividadInternalFrame.setVisible(false);
				altaInstitucionInternalFrame.setVisible(false);
				altaUsuarioInternalFrame.setVisible(false);
				consultaUsuarioInternalFrame.setVisible(false);
				consultaActividadInternalFrame.setVisible(false);
				registroDictadoClaseInternalFrame.setVisible(true);
			}
		});
		menuAltas.add(mntmRegistroDeDictado);
		
		JMenu menuConsultas = new JMenu("Consultas");
		menuBar.add(menuConsultas);
		
		JMenuItem menuItemConsultaUsuario = new JMenuItem("Consultar Usuario");
		menuItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(false);
				altaActividadInternalFrame.setVisible(false);
				altaInstitucionInternalFrame.setVisible(false);
				altaUsuarioInternalFrame.setVisible(false);
				consultaUsuarioInternalFrame.setVisible(true);
				consultaActividadInternalFrame.setVisible(false);
				registroDictadoClaseInternalFrame.setVisible(false);
			}
		});
		menuConsultas.add(menuItemConsultaUsuario);
		
		JMenuItem menuItemConsultaActividad = new JMenuItem("Consultar Actividad Deportiva");
		menuItemConsultaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseInternalFrame.setVisible(false);
				altaActividadInternalFrame.setVisible(false);
				altaInstitucionInternalFrame.setVisible(false);
				altaUsuarioInternalFrame.setVisible(false);
				consultaUsuarioInternalFrame.setVisible(false);
				consultaActividadInternalFrame.setVisible(true);
				registroDictadoClaseInternalFrame.setVisible(false);
			}
		});
		menuConsultas.add(menuItemConsultaActividad);
		
		JMenuItem menuItemConsultaDictadoClase = new JMenuItem("Consultar Dictado de Clase");
		menuConsultas.add(menuItemConsultaDictadoClase);
		
		JMenu menuModificaciones = new JMenu("Modificaciones");
		menuBar.add(menuModificaciones);
		
		JMenu menuModificarUsuario = new JMenu("Usuario");
		menuModificaciones.add(menuModificarUsuario);
		
		JMenuItem menuItemModificarUsuarioNombre = new JMenuItem("Modificar nombre");
		menuModificarUsuario.add(menuItemModificarUsuarioNombre);
		
		JMenuItem menuItemModificarUsuarioApellido = new JMenuItem("Modificar apellido");
		menuModificarUsuario.add(menuItemModificarUsuarioApellido);
		
		JMenuItem menuItemModificarUsuarioFechaNacimiento = new JMenuItem("Modificar fecha de nacimiento");
		menuModificarUsuario.add(menuItemModificarUsuarioFechaNacimiento);
		
		JMenu menuModificarInstitucion = new JMenu("Institucion Deportiva");
		menuModificaciones.add(menuModificarInstitucion);
		
		JMenuItem menuItemModificarInstitucionDescripcion = new JMenuItem("Modificar descripcion");
		menuModificarInstitucion.add(menuItemModificarInstitucionDescripcion);
		
		JMenuItem menuItemModificarInstitucionURL = new JMenuItem("Modificar url");
		menuModificarInstitucion.add(menuItemModificarInstitucionURL);
		
		JMenu menuModificarActividadDeportiva = new JMenu("Actividad Deportiva");
		menuModificaciones.add(menuModificarActividadDeportiva);
		
		JMenuItem menuItemModificarActividadDescripcion = new JMenuItem("Modificar descripción");
		menuModificarActividadDeportiva.add(menuItemModificarActividadDescripcion);
		
		JMenuItem menuItemModificarActividadDuracion = new JMenuItem("Modificar duración");
		menuModificarActividadDeportiva.add(menuItemModificarActividadDuracion);
		
		JMenuItem menuItemModificarActividadCosto = new JMenuItem("Modificar costo");
		menuModificarActividadDeportiva.add(menuItemModificarActividadCosto);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		menuBar.add(mntmSalir);
	}
}
