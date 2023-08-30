package presentacionConsultas;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class GUIConsultaDictadoClase extends JInternalFrame {
	JComboBox cmbInstituciones = new JComboBox();
	JComboBox cmbActividades = new JComboBox();
	JComboBox cmbClases = new JComboBox();
	private void setupActions(IInstitucionDeportiva iInstitucion) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmbInstituciones.removeAllItems();
				List<String> instituciones = iInstitucion.getListaNombreInstituciones();
				
				
				for (String i: instituciones) {
					cmbInstituciones.addItem(i);
				}
				
				cmbInstituciones.setSelectedIndex(-1);
			}
		});
	}

	public GUIConsultaDictadoClase(IInstitucionDeportiva iInstitucion) {
		setBounds(100, 100, 450, 320);
		setClosable(true);
		setResizable(true);
		setTitle("Consulta clase");
		setupActions(iInstitucion);
		getContentPane().setLayout(null);
		
		JLabel labelInstitucion = new JLabel("Institucion:");
		labelInstitucion.setBounds(35, 24, 132, 13);
		getContentPane().add(labelInstitucion);
		
		cmbInstituciones.setBounds(207, 20, 132, 21);
		getContentPane().add(cmbInstituciones);
		
		JLabel labelActividades = new JLabel("Actividad Deportiva:");
		labelActividades.setBounds(35, 57, 132, 13);
		getContentPane().add(labelActividades);

		cmbActividades.setBounds(207, 53, 132, 21);
		getContentPane().add(cmbActividades);
		
		JLabel labelClases = new JLabel("Clases:");
		labelClases.setBounds(35, 92, 132, 13);
		getContentPane().add(labelClases);
		
		cmbClases.setBounds(207, 88, 132, 21);
		getContentPane().add(cmbClases);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(35, 150, 132, 13);
		getContentPane().add(labelNombre);
		
		JLabel labelFechaClase = new JLabel("Fecha de Clase:");
		labelFechaClase.setBounds(35, 173, 132, 13);
		getContentPane().add(labelFechaClase);
		
		JLabel labelHora = new JLabel("Hora de Inicio:");
		labelHora.setBounds(35, 196, 132, 13);
		getContentPane().add(labelHora);
		
		JLabel labelUrl = new JLabel("URL:");
		labelUrl.setBounds(35, 219, 132, 13);
		getContentPane().add(labelUrl);
		
		JLabel url = new JLabel("");
		url.setBounds(207, 219, 192, 13);
		getContentPane().add(url);
		
		JLabel hora = new JLabel("");
		hora.setBounds(207, 196, 192, 13);
		getContentPane().add(hora);
		
		JLabel fechaClase = new JLabel("");
		fechaClase.setBounds(207, 173, 192, 13);
		getContentPane().add(fechaClase);
		
		JLabel nombre = new JLabel("");
		nombre.setBounds(207, 150, 192, 13);
		getContentPane().add(nombre);
		
		JLabel labelFechaRegistro = new JLabel("Fecha de Registro");
		labelFechaRegistro.setBounds(35, 242, 132, 13);
		getContentPane().add(labelFechaRegistro);
		
		JLabel fechaRegistro = new JLabel("");
		fechaRegistro.setBounds(207, 242, 192, 13);
		getContentPane().add(fechaRegistro);
		
		
		cmbInstituciones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
				InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
				
				if(!iInstitucion.existeInstitucion(nombreInstitucion)) {
					labelActividades.setVisible(false);
					cmbActividades.setVisible(false);
					cmbActividades.setSelectedIndex(-1);
					labelClases.setVisible(false);
					cmbClases.setVisible(false);
					cmbClases.setSelectedIndex(-1);
					labelNombre.setVisible(false);
					nombre.setText("");
					labelFechaClase.setVisible(false);
					fechaClase.setText("");
					labelHora.setVisible(false);
					hora.setText("");
					labelUrl.setVisible(false);
					url.setText("");
					labelFechaRegistro.setVisible(false);
					fechaRegistro.setText("");
				} else {
					//List<ActividadDeportiva> actividades = institucion.getArrayActividadDeportiva();
					List<String> actividades = iInstitucion.obtenerActividadesDeUnaInstitucion(nombreInstitucion);
					cmbActividades.removeAllItems();
					
					for(String a: actividades) {
						cmbActividades.addItem(a);
					}
					
					labelActividades.setVisible(true);
					cmbActividades.setSelectedIndex(-1);
					cmbActividades.setVisible(true);
				}
			}
		});
		
		cmbActividades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
				InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
				String nombreActividad = (String) cmbActividades.getSelectedItem();
				ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);
				
				if(actividad == null) {
					labelClases.setVisible(false);
					cmbClases.setVisible(false);
					cmbClases.setSelectedIndex(-1);
					labelNombre.setVisible(false);
					nombre.setText("");
					labelFechaClase.setVisible(false);
					fechaClase.setText("");
					labelHora.setVisible(false);
					hora.setText("");
					labelUrl.setVisible(false);
					url.setText("");
					labelFechaRegistro.setVisible(false);
					fechaRegistro.setText("");
				} else {
					List<Clase> clases = actividad.getArrayClase();
					cmbClases.removeAllItems();
					
					for(Clase c: clases) {
						cmbClases.addItem(c.getNombreClase());
					}
					
					labelClases.setVisible(true);
					cmbClases.setSelectedIndex(-1);
					cmbClases.setVisible(true);
				}
			}
		});
		
		cmbClases.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
				InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
				String nombreActividad = (String) cmbActividades.getSelectedItem();
				ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);
				String nombreClase = (String) cmbClases.getSelectedItem();
				Clase clase = actividad.buscarClase(nombreClase);
				
				if(clase == null) {
					labelNombre.setVisible(false);
					nombre.setText("");
					labelFechaClase.setVisible(false);
					fechaClase.setText("");
					labelHora.setVisible(false);
					hora.setText("");
					labelUrl.setVisible(false);
					url.setText("");
					labelFechaRegistro.setVisible(false);
					fechaRegistro.setText("");
				} else {
					nombre.setText(clase.getNombreClase());
					labelNombre.setVisible(true);
					fechaClase.setText(clase.getFechaClase().toString());
					labelFechaClase.setVisible(true);
					hora.setText(clase.getHoraInicio());
					labelHora.setVisible(true);
					url.setText(clase.getUrlClase());
					labelUrl.setVisible(true);
					fechaRegistro.setText(clase.getFechaRegistro().toString());
					labelFechaRegistro.setVisible(true);
				}
			}
		});

	}
}
