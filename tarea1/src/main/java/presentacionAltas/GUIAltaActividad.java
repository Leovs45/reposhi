package presentacionAltas;

import javax.swing.JInternalFrame;

import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import java.util.Date;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;

public class GUIAltaActividad extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;

	/*  Create the frame. */
	public GUIAltaActividad(IActividadDeportiva iActividad, IInstitucionDeportiva iInstitucion) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		
		JLabel lblAltaActividadDeportiva = new JLabel("Alta Actividad Deportiva");
		lblAltaActividadDeportiva.setBounds(122, 12, 181, 15);
		getContentPane().add(lblAltaActividadDeportiva);
		
		JLabel lblInstitucion = new JLabel("Institucion: ");
		lblInstitucion.setBounds(28, 59, 84, 15);
		getContentPane().add(lblInstitucion);
		
		JComboBox cmbInstituciones = new JComboBox();
		cmbInstituciones.setBounds(137, 52, 130, 24);
		
        List<String> ins = iInstitucion.getListaNombreInstituciones();
        try {
        	for (String i : ins) {
                cmbInstituciones.addItem(i);
            }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error al cargar las etc", "Error", JOptionPane.ERROR_MESSAGE);
        }
        getContentPane().add(cmbInstituciones);
        
        
        
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(28, 104, 84, 15);
		getContentPane().add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(137, 100, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setBounds(28, 149, 91, 15);
		getContentPane().add(lblDescripcion);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(28, 194, 84, 15);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo: ");
		lblCosto.setBounds(28, 239, 84, 15);
		getContentPane().add(lblCosto);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(137, 145, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(137, 190, 114, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(137, 235, 114, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblError1 = new JLabel("Ingrese los campos");
		lblError1.setForeground(Color.RED);
		lblError1.setBounds(283, 250, 145, 15);
		lblError1.setVisible(false);
		getContentPane().add(lblError1);
		
		JLabel lblError2 = new JLabel("que tienen un *");
		lblError2.setForeground(Color.RED);
		lblError2.setBounds(293, 275, 135, 15);
		lblError2.setVisible(false);
		getContentPane().add(lblError2);

		
		JLabel lblActividadIngresada = new JLabel("Actividad Ingresada");
		lblActividadIngresada.setForeground(Color.GREEN);
		lblActividadIngresada.setBounds(277, 261, 151, 15);
		lblActividadIngresada.setVisible(false);
		getContentPane().add(lblActividadIngresada);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNombre.getText().isEmpty()
						|| textFieldDescripcion.getText().isEmpty() 
						|| textFieldDuracion.getText().isEmpty() 
						|| textFieldCosto.getText().isEmpty()
						|| cmbInstituciones.getSelectedIndex() == -1){
					lblError1.setVisible(true);
					lblError2.setVisible(true);
					lblActividadIngresada.setVisible(false);
				}
				else {
					String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
					String nombre = textFieldNombre.getText();
					String descripcion = textFieldDescripcion.getText();
					//TO DO: Exception para los int
					int duracion = Integer.parseInt(textFieldDuracion.getText());
					double costo = Double.parseDouble(textFieldCosto.getText());
					lblError1.setVisible(false);
					lblError2.setVisible(false);
					lblActividadIngresada.setVisible(true);
					
					iActividad.altaActividadDeportiva(iInstitucion.buscarInstitucionDeportiva(nombreInstitucion), nombre, descripcion, duracion, costo, new Date());
				}
				
			}
		});
		btnAgregar.setBounds(283, 302, 117, 25);
		getContentPane().add(btnAgregar);

	}
}

