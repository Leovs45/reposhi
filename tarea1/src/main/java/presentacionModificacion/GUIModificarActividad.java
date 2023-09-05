package presentacionModificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import interfaces.IActividadDeportiva;

import javax.swing.JComboBox;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import datatypes.DtActividad;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GUIModificarActividad extends JInternalFrame {
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	List<DtActividad> actividades = new ArrayList<>();
	JComboBox cmbActividades = new JComboBox();
	JLabel labelActividades = new JLabel("Actividades: ");
	JLabel labelNombre = new JLabel("Nombre:");
	JLabel labelDescripcion = new JLabel("Descripcion:");
	JLabel labelDuracion = new JLabel("Duracion:");
	JLabel labelCosto = new JLabel("Costo:");
	JLabel labelFecha = new JLabel("Fecha de Registro:");
	JLabel nombre = new JLabel("");
	JLabel duracion = new JLabel("");
	JLabel descripcion = new JLabel("");
	JLabel costo = new JLabel("");
	JLabel fecha = new JLabel("");
	JLabel labelModificar1 = new JLabel("¿Qué campo");
	JLabel labelModificar2 = new JLabel("deseas modificar?"); 
	JRadioButton radiobtnDescripcion = new JRadioButton("Descripción");
	JRadioButton radiobtnDuracion = new JRadioButton("Duración");
	JRadioButton radiobtnCosto = new JRadioButton("Costo");
	JLabel labelModificar = new JLabel("");
	JButton btnAceptar = new JButton("Aceptar");
	
	private void setupActions(IActividadDeportiva iActividad) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmbActividades.removeAllItems();
				actividades = iActividad.getActividades();
					
				for(DtActividad a: actividades) {
					cmbActividades.addItem(a.getNombre());
				}
				
				cmbActividades.setSelectedIndex(-1);	
			}
		});
	}

	public GUIModificarActividad(IActividadDeportiva iActividad) {
		setupActions(iActividad);
		setBounds(100, 100, 450, 500);
		setClosable(true);
		getContentPane().setLayout(null);

		labelActividades.setBounds(31, 40, 114, 13);
		getContentPane().add(labelActividades);
		
		cmbActividades.setBounds(185, 36, 141, 21);
		getContentPane().add(cmbActividades);
		
		labelNombre.setBounds(31, 73, 114, 13);
		getContentPane().add(labelNombre);
		
		labelDescripcion.setBounds(31, 96, 114, 13);
		getContentPane().add(labelDescripcion);
		
		labelDuracion.setBounds(31, 119, 114, 13);
		getContentPane().add(labelDuracion);
		
		labelCosto.setBounds(31, 142, 114, 13);
		getContentPane().add(labelCosto);
		
		labelFecha.setBounds(31, 165, 114, 13);
		getContentPane().add(labelFecha);
		
		nombre.setBounds(185, 73, 141, 13);
		getContentPane().add(nombre);
		
		duracion.setBounds(185, 119, 141, 13);
		getContentPane().add(duracion);
		
		descripcion.setBounds(185, 96, 141, 13);
		getContentPane().add(descripcion);
		
		costo.setBounds(185, 142, 141, 13);
		getContentPane().add(costo);
		
		fecha.setBounds(185, 165, 202, 13);
		getContentPane().add(fecha);
		
		labelModificar1.setBounds(31, 198, 114, 13);
		labelModificar1.setVisible(false);
		getContentPane().add(labelModificar1);
		
		labelModificar2.setBounds(31, 213, 114, 13);
		labelModificar2.setVisible(false);
		getContentPane().add(labelModificar2);
		
		radiobtnDescripcion.setBounds(185, 198, 141, 21);
		buttonGroup.add(radiobtnDescripcion);
		radiobtnDescripcion.setVisible(false);
		getContentPane().add(radiobtnDescripcion);
		
		radiobtnDuracion.setBounds(185, 219, 141, 21);
		buttonGroup.add(radiobtnDuracion);
		radiobtnDuracion.setVisible(false);
		getContentPane().add(radiobtnDuracion);
		
		radiobtnCosto.setBounds(185, 240, 141, 21);
		buttonGroup.add(radiobtnCosto);
		radiobtnCosto.setVisible(false);
		getContentPane().add(radiobtnCosto);
		
		labelModificar.setBounds(31, 307, 114, 13);
		labelModificar.setVisible(false);
		getContentPane().add(labelModificar);
		
		textField = new JTextField();
		textField.setBounds(185, 307, 141, 19);
		textField.setVisible(false);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAceptar.setBounds(313, 409, 85, 21);
		btnAceptar.setVisible(false);
		getContentPane().add(btnAceptar);
		
		cmbActividades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreActividad = (String) cmbActividades.getSelectedItem();
				if(nombreActividad == null) {
					nombre.setText("");
					duracion.setText("");
					descripcion.setText("");
					costo.setText("");
					fecha.setText("");
					labelModificar.setText("");
					labelModificar1.setVisible(false);
					labelModificar2.setVisible(false);
					radiobtnDescripcion.setVisible(false);
					radiobtnCosto.setVisible(false);
					radiobtnDuracion.setVisible(false);
					btnAceptar.setVisible(false);
				} else {
					boolean existeActividad = iActividad.existeActividad(nombreActividad);

					if(!existeActividad) {
						nombre.setText("");
						duracion.setText("");
						descripcion.setText("");
						costo.setText("");
						fecha.setText("");
						labelModificar.setText("");
						labelModificar1.setVisible(false);
						labelModificar2.setVisible(false);
						radiobtnDescripcion.setVisible(false);
						radiobtnCosto.setVisible(false);
						radiobtnDuracion.setVisible(false);
						btnAceptar.setVisible(false);
					} else {
						DtActividad actividad = iActividad.getDtActividad(nombreActividad);
						nombre.setText(actividad.getNombre());
						descripcion.setText(actividad.getDescripcion());
						duracion.setText(String.valueOf(actividad.getDuracionMinutos()));
						costo.setText(String.valueOf(actividad.getCosto()));
						fecha.setText(actividad.getFechaRegistro().toString());
						labelModificar1.setVisible(true);
						labelModificar2.setVisible(true);
						radiobtnDescripcion.setVisible(true);
						radiobtnCosto.setVisible(true);
						radiobtnDuracion.setVisible(true);
					}
				}
			}
		});
		
		radiobtnDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobtnDescripcion.isSelected()) {
					labelModificar.setText("Nueva Descripcion: ");
					labelModificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		radiobtnDuracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobtnDuracion.isSelected()) {
					labelModificar.setText("Nueva Duracion: ");
					labelModificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		radiobtnCosto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobtnCosto.isSelected()) {
					labelModificar.setText("Nuevo Costo: ");
					labelModificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreActividad = (String) cmbActividades.getSelectedItem();
				
				if(radiobtnDescripcion.isSelected()) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String nuevaDescripcion = textField.getText();
						iActividad.modificarDescripcion(nombreActividad, nuevaDescripcion);
						descripcion.setText(nuevaDescripcion);
						JOptionPane.showMessageDialog(null, "La descripción fue modificada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (radiobtnCosto.isSelected()) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							int nuevoCosto = Integer.parseInt(textField.getText());
							iActividad.modificarCosto(nombreActividad, nuevoCosto);
							costo.setText(String.valueOf(nuevoCosto));
							JOptionPane.showMessageDialog(null, "El costo fue modificada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception exc) {
							JOptionPane.showMessageDialog(null, "Duracion debe ser un valor numerico", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else if(radiobtnDuracion.isSelected()) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							int nuevaDuracion = Integer.parseInt(textField.getText());
							iActividad.modificarDuracion(nombreActividad, nuevaDuracion);
							duracion.setText(String.valueOf(nuevaDuracion));
							JOptionPane.showMessageDialog(null, "La duracion fue modificada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception exc) {
							JOptionPane.showMessageDialog(null, "Duracion debe ser un valor numerico", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
	}
}
