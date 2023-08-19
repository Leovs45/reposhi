package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import presentacionAltas.*;
import presentacionConsultas.*;
import presentacionModificacion.*;

public class GUIPrincipal {

	private JFrame frame;
	private GUIAltaSocio agregarSocioInternalFrame;
	private GUIAltaProfesor altaProfesorInternalFrame;
	private GUIAltaInstitucionDeportiva altaInstitucionInternalFrame;
	private GUIAltaActividadDeportiva altaActividadInternalFrame;
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
