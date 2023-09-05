package presentacionAltas;

import javax.swing.JInternalFrame;

import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import excepciones.ExisteActividadDepException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;

public class GUIAltaActividad extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	JComboBox cmbInstituciones = new JComboBox();
	List<String> instituciones;
	
	private void setupActions(IInstitucionDeportiva iInstitucion) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmbInstituciones.removeAllItems();
				instituciones = iInstitucion.getListaNombreInstituciones();
					
				for (String i: instituciones) {
	                cmbInstituciones.addItem(i);
	            }
				
				cmbInstituciones.setSelectedIndex(-1);	
			}
		});
	}

	
	public GUIAltaActividad(IActividadDeportiva iActividad, IInstitucionDeportiva iInstitucion) {
		setupActions(iInstitucion);
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
		
		cmbInstituciones.setBounds(137, 52, 130, 24);
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
				if (textFieldNombre.getText().isEmpty()
			            || textFieldDescripcion.getText().isEmpty()
			            || textFieldDuracion.getText().isEmpty()
			            || textFieldCosto.getText().isEmpty()
			            || cmbInstituciones.getSelectedIndex() == -1) {
			            
			            JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			        } else {
			            String nombreInstitucion = (String) cmbInstituciones.getSelectedItem();
			            String nombre = textFieldNombre.getText();
			            try {
			                String descripcion = textFieldDescripcion.getText();
			                int duracion = Integer.parseInt(textFieldDuracion.getText());
			                double costo = Double.parseDouble(textFieldCosto.getText());
			                
			                iActividad.altaActividadDeportiva(iInstitucion.buscarInstitucionDeportiva(nombreInstitucion), nombre, descripcion, duracion, costo, new Date());
			                
			                JOptionPane.showMessageDialog(null, "La actividad fue creada correctamente", "Success", JOptionPane.INFORMATION_MESSAGE);
			                
			            } catch (NumberFormatException numExc) {
			                JOptionPane.showMessageDialog(null, "Duracion y costo debe ser un valores numéricos", "Error", JOptionPane.ERROR_MESSAGE);
			            } catch (ExisteActividadDepException ayExc) {
			                JOptionPane.showMessageDialog(null, "La actividad deportiva ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
			            } catch (Exception exc) {
			                JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			    }
			});

		btnAgregar.setBounds(283, 302, 117, 25);
		getContentPane().add(btnAgregar);
		
		}
		}

