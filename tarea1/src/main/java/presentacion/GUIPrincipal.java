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
	private GUIAltaSocio altaSocioInternalFrame;
	private GUIAltaProfesor altaProfesorInternalFrame;
	private GUIAltaInstitucion altaInstitucionInternalFrame;
	private GUIAltaActividad altaActividadInternalFrame;
	private GUIAltaDictadoClase altaClaseInternalFrame;
	private GUIConsultaUsuario consultaUsuarioInternalFrame;
	private GUIConsultaInstitucion consultaInstitucionInternalFrame;
	private GUIConsultaActividadDeportiva consultaActividadInternalFrame;
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
		IClase iClase = f.getIClase();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		// Crea frame de alta profesor
		altaProfesorInternalFrame = new GUIAltaProfesor(iUsuario); 
		jInternalFrameSize = altaProfesorInternalFrame.getSize();
		altaProfesorInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaProfesorInternalFrame.setVisible(false);
		frame.getContentPane().add(altaProfesorInternalFrame);
		altaProfesorInternalFrame.getContentPane().setLayout(null);
		
		// Crea frame de alta socio
		altaSocioInternalFrame = new GUIAltaSocio(iUsuario); 
		jInternalFrameSize = altaSocioInternalFrame.getSize();
		altaSocioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaSocioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaSocioInternalFrame);
		
		// Crea frame de alta institucion
		altaInstitucionInternalFrame = new GUIAltaInstitucion(iInstitucion); 
		jInternalFrameSize = altaInstitucionInternalFrame.getSize();
		altaInstitucionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2
				,(desktopSize.height - jInternalFrameSize.height)/2);
		altaInstitucionInternalFrame.setVisible(false);
		frame.getContentPane().add(altaInstitucionInternalFrame);
		
		// Crea frame de alta actividad
		altaActividadInternalFrame = new GUIAltaActividad(iActividad); 
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
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuAltas = new JMenu("Altas");
		menuBar.add(menuAltas);
		
		JMenu menuAltaUsuario = new JMenu("Alta usuario");
		menuAltas.add(menuAltaUsuario);
		
		JMenuItem menuItemAlta = new JMenuItem("Alta Socio");
		menuAltaUsuario.add(menuItemAlta);
		
		JMenuItem menuItemAltaSocio = new JMenuItem("Alta Socio");
		menuAltaUsuario.add(menuItemAltaSocio);
		
		JMenuItem menuItemAltaItDeportiva = new JMenuItem("Alta institucion deportiva");
		menuAltas.add(menuItemAltaItDeportiva);
		
		JMenuItem menuItemAltaActDeportiva = new JMenuItem("Alta actividad deportiva");
		menuAltas.add(menuItemAltaActDeportiva);
		
		JMenuItem menuItemAltaClase = new JMenuItem("Alta dictado de clase");
		menuAltas.add(menuItemAltaClase);
		
		JMenu menuConsultas = new JMenu("Consultas");
		menuBar.add(menuConsultas);
		
		JMenuItem menuItemConsultaUsuario = new JMenuItem("Consultar Usuario");
		menuConsultas.add(menuItemConsultaUsuario);
		
		JMenuItem menuItemConsultaActividad = new JMenuItem("Consultar Actividad Deportiva");
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
	}
}
