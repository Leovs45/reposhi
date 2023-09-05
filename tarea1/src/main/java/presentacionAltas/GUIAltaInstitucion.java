package presentacionAltas;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.InstitucionRepetidaException;

import javax.swing.JButton;
import javax.swing.JLabel;
import interfaces.IInstitucionDeportiva;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class GUIAltaInstitucion extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldURL;

	/* Create the frame. */
	public GUIAltaInstitucion(IInstitucionDeportiva iInstitucion) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblAltaInstitucion = new JLabel("Alta Institucion");
		lblAltaInstitucion.setBounds(160, 12, 136, 15);
		getContentPane().add(lblAltaInstitucion);
		
		JLabel lblNombre = new JLabel("*Nombre: ");
		lblNombre.setBounds(35, 48, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(170, 46, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("*Descripcion: ");
		lblDescripcion.setBounds(35, 80, 105, 15);
		getContentPane().add(lblDescripcion);
		
		JLabel lblUrl = new JLabel("*URL: ");
		lblUrl.setBounds(35, 112, 70, 15);
		getContentPane().add(lblUrl);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(170, 78, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(170, 110, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				String descripcion = textFieldDescripcion.getText();
				String url = textFieldURL.getText();
				if(nombre.isEmpty() || descripcion.isEmpty() || url.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingrese los campos vacios", "Campos Vacios", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						iInstitucion.altaInstitucionDeportiva(nombre, descripcion, url);
						JOptionPane.showMessageDialog(null, "Institucion creada", "Institucion Creada", JOptionPane.INFORMATION_MESSAGE);

					}catch(InstitucionRepetidaException exc) {
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Institucion Repetida", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnAgregar.setBounds(160, 213, 117, 25);
		getContentPane().add(btnAgregar);
	}
	
}
