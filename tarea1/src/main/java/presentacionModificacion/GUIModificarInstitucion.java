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

import interfaces.IInstitucionDeportiva;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtInstitucion;

public class GUIModificarInstitucion extends JInternalFrame {
	JComboBox cmbInstituciones = new JComboBox();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	List<DtInstitucion> instituciones = new ArrayList<>();
	
	private void setupActions(IInstitucionDeportiva iInstitucion) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmbInstituciones.removeAllItems();
				instituciones = iInstitucion.getInstituciones();
				
				for (DtInstitucion i: instituciones) {
					cmbInstituciones.addItem(i.getNombre());
				}
				
				cmbInstituciones.setSelectedIndex(-1);
			}
		});
	}

	public GUIModificarInstitucion(IInstitucionDeportiva iInstitucion) {
		setupActions(iInstitucion);
		setTitle("Modificar institucion");
		setClosable(true);
		setBounds(100, 100, 400, 350);
		getContentPane().setLayout(null);
		
		JLabel labelInstitucion = new JLabel("Institucion:");
		labelInstitucion.setBounds(41, 31, 106, 13);
		getContentPane().add(labelInstitucion);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(41, 68, 106, 13);
		getContentPane().add(labelNombre);
		
		JLabel labelDescripcion = new JLabel("Descripción:");
		labelDescripcion.setBounds(41, 91, 106, 13);
		getContentPane().add(labelDescripcion);
		
		JLabel labelUrl = new JLabel("URL:");
		labelUrl.setBounds(41, 114, 106, 13);
		getContentPane().add(labelUrl);
		
		JLabel labelModificar1 = new JLabel("¿Qué campo");
		labelModificar1.setBounds(41, 161, 106, 13);
		labelModificar1.setVisible(false);
		getContentPane().add(labelModificar1);
		
		JLabel labelModificar2 = new JLabel("deseas modificar?");
		labelModificar2.setBounds(41, 173, 106, 13);
		labelModificar2.setVisible(false);
		getContentPane().add(labelModificar2);
		
		cmbInstituciones.setBounds(187, 27, 128, 21);
		getContentPane().add(cmbInstituciones);
		
		JLabel nombre = new JLabel("");
		nombre.setBounds(187, 68, 180, 13);
		getContentPane().add(nombre);
		
		JLabel descripcion = new JLabel("");
		descripcion.setBounds(187, 91, 180, 13);
		getContentPane().add(descripcion);
		
		JLabel url = new JLabel("");
		url.setBounds(187, 114, 180, 13);
		getContentPane().add(url);
		
		JRadioButton radioBtnDescripcion = new JRadioButton("Descripción");
		radioBtnDescripcion.setBounds(187, 161, 128, 21);
		buttonGroup.add(radioBtnDescripcion);
		radioBtnDescripcion.setVisible(false);
		getContentPane().add(radioBtnDescripcion);
		
		JRadioButton radioBtnUrl = new JRadioButton("URL");
		radioBtnUrl.setBounds(187, 184, 128, 21);
		buttonGroup.add(radioBtnUrl);
		radioBtnUrl.setVisible(false);
		getContentPane().add(radioBtnUrl);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(282, 284, 85, 21);
		btnAceptar.setVisible(false);
		getContentPane().add(btnAceptar);
		
		JLabel modificar = new JLabel("");
		modificar.setBounds(41, 232, 136, 13);
		getContentPane().add(modificar);
		
		textField = new JTextField();
		textField.setBounds(187, 232, 128, 19);
		textField.setVisible(false);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		// ACTIONS
		
		cmbInstituciones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
				
				if(nombreInstitucion == null) {
					labelModificar1.setVisible(false);
					labelModificar2.setVisible(false);
					radioBtnDescripcion.setVisible(false);
					radioBtnUrl.setVisible(false);
					textField.setVisible(false);
					nombre.setText("");
					descripcion.setText("");
					url.setText("");
					modificar.setText("");
				} else {
					boolean existeInstitucion = iInstitucion.existeInstitucion(nombreInstitucion);
					
					if(!existeInstitucion) {
						labelModificar1.setVisible(false);
						labelModificar2.setVisible(false);
						radioBtnDescripcion.setVisible(false);
						radioBtnUrl.setVisible(false);
						textField.setVisible(false);
						nombre.setText("");
						descripcion.setText("");
						url.setText("");
						modificar.setText("");
					} else {
						DtInstitucion institucion = iInstitucion.getDtInstitucion(nombreInstitucion);
						nombre.setText(institucion.getNombre());
						descripcion.setText(institucion.getDescripcion());
						url.setText(institucion.getUrl());
						labelModificar1.setVisible(true);
						labelModificar2.setVisible(true);
						radioBtnDescripcion.setVisible(true);
						radioBtnUrl.setVisible(true);
					}
				}
			}
		});
		
		radioBtnDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioBtnDescripcion.isSelected()) {
					modificar.setText("Nueva Descripcion: ");
					modificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		radioBtnUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioBtnUrl.isSelected()) {
					modificar.setText("Nueva URL: ");
					modificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
				
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if(radioBtnDescripcion.isSelected()) {
						String nuevaDescripcion = textField.getText();
						iInstitucion.modificarDescripcion(nombreInstitucion, nuevaDescripcion);
						descripcion.setText(nuevaDescripcion);
						JOptionPane.showMessageDialog(null, "La descripcion fue modificada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
					}else if (radioBtnUrl.isSelected()) {
						String nuevaUrl = textField.getText();
						iInstitucion.modificarUrl(nombreInstitucion, nuevaUrl);
						descripcion.setText(nuevaUrl);
						JOptionPane.showMessageDialog(null, "La URL fue modificada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});


	}
}
