package presentacionModificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JInternalFrame;

import interfaces.IUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import datatypes.DtUsuario;

import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUIModificarUsuario extends JInternalFrame {
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	List<DtUsuario> usuarios = new ArrayList<>();
	JLabel labelUsuario = new JLabel("Usuario:");
	JLabel labelModificar1 = new JLabel("¿Qué deseas");
	JLabel labelModificar2 = new JLabel("modificar?");
	JRadioButton rdbtnNombre = new JRadioButton("Nombre");
	JRadioButton rdbtnApellido = new JRadioButton("Apellido");
	JRadioButton rdbtnFecha = new JRadioButton("Fecha de Nacimiento");
	JLabel labelNombre = new JLabel("Nombre:");
	JLabel labelApellido = new JLabel("Apellido:");
	JLabel labelFecha = new JLabel("Fecha de Nacimiento:");
	JLabel nombre = new JLabel("");
	JLabel apellido = new JLabel("");
	JLabel fecha = new JLabel("");
	JLabel labelModificar = new JLabel("");
	JDateChooser dateFecha = new JDateChooser();
	JButton btnAceptar = new JButton("Aceptar");
	JComboBox cmbUsuarios = new JComboBox();
	
	private void setupActions(IUsuario iUsuario) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmbUsuarios.removeAllItems();
				usuarios = iUsuario.getUsuarios();
					
				for(DtUsuario u: usuarios) {
					cmbUsuarios.addItem(u.getNickname());
				}
				
				cmbUsuarios.setSelectedIndex(-1);	
			}
		});
	}

	public GUIModificarUsuario(IUsuario iUsuario) {
		setupActions(iUsuario);
		
		setClosable(true);
		setTitle("Modificar Usuario");
		setBounds(100, 100, 559, 500);
		getContentPane().setLayout(null);

		labelUsuario.setBounds(36, 51, 108, 13);
		getContentPane().add(labelUsuario);
		
		cmbUsuarios.setBounds(171, 51, 141, 21);
		
		getContentPane().add(cmbUsuarios);
		
		labelModificar1.setBounds(36, 244, 173, 21);
		getContentPane().add(labelModificar1);
		labelModificar2.setBounds(36, 269, 71, 13);
		labelModificar1.setVisible(false);
		labelModificar2.setVisible(false);
		getContentPane().add(labelModificar2);
		
		rdbtnNombre.setBounds(171, 251, 141, 21);
		rdbtnNombre.setVisible(false);
		buttonGroup.add(rdbtnNombre);
		getContentPane().add(rdbtnNombre);
		
		rdbtnApellido.setBounds(171, 274, 141, 21);
		rdbtnApellido.setVisible(false);
		buttonGroup.add(rdbtnApellido);
		getContentPane().add(rdbtnApellido);
		
		rdbtnFecha.setBounds(171, 297, 173, 21);
		rdbtnFecha.setVisible(false);
		buttonGroup.add(rdbtnFecha);
		getContentPane().add(rdbtnFecha);
		
		labelNombre.setBounds(36, 114, 108, 13);
		getContentPane().add(labelNombre);
		
		labelApellido.setBounds(36, 149, 108, 13);
		getContentPane().add(labelApellido);
		
		labelFecha.setBounds(36, 181, 125, 13);
		getContentPane().add(labelFecha);
		
		nombre.setBounds(171, 118, 141, 13);
		getContentPane().add(nombre);
		
		apellido.setBounds(171, 153, 141, 13);
		getContentPane().add(apellido);
		
		fecha.setBounds(171, 185, 198, 13);
		getContentPane().add(fecha);
		
		labelModificar.setBounds(36, 374, 108, 13);
		labelModificar.setVisible(false);
		getContentPane().add(labelModificar);
		
		textField = new JTextField();
		textField.setBounds(171, 374, 132, 19);
		getContentPane().add(textField);
		textField.setVisible(false);
		textField.setColumns(10);
		
		dateFecha.setBounds(171, 374, 137, 19);
		dateFecha.setVisible(false);
		getContentPane().add(dateFecha);
		
		btnAceptar.setBounds(414, 421, 85, 21);
		btnAceptar.setVisible(false);
		getContentPane().add(btnAceptar);
		
		// ACTIONS
		
		cmbUsuarios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String opcion = (String) cmbUsuarios.getSelectedItem();
				String nicknameUsuario = (String) cmbUsuarios.getSelectedItem();
				
				if(nicknameUsuario == null || opcion == null) {
					nombre.setText("");
					apellido.setText("");
					fecha.setText("");
					rdbtnNombre.setVisible(false);
					rdbtnApellido.setVisible(false);
					rdbtnFecha.setVisible(false);
					labelModificar1.setVisible(false);
					labelModificar2.setVisible(false);
					textField.setVisible(false);
					textField.setText("");
					labelModificar.setVisible(false);
					btnAceptar.setVisible(false);
					dateFecha.setVisible(false);
				} else {
					boolean existeUsuario = iUsuario.existeUsuario(nicknameUsuario);
					
					if(!existeUsuario) {
						nombre.setText("");
						apellido.setText("");
						fecha.setText("");
						rdbtnNombre.setVisible(false);
						rdbtnApellido.setVisible(false);
						rdbtnFecha.setVisible(false);
						labelModificar1.setVisible(false);
						labelModificar2.setVisible(false);
						textField.setVisible(false);
						textField.setText("");
						labelModificar.setVisible(false);
						btnAceptar.setVisible(false);
						dateFecha.setVisible(false);
					} else {
						DtUsuario usuario = iUsuario.getDtUsuario(nicknameUsuario);
						nombre.setText(usuario.getNombre());
						apellido.setText(usuario.getApellido());
						fecha.setText(usuario.getFechaNacimiento().toString());
						rdbtnNombre.setVisible(true);
						rdbtnApellido.setVisible(true);
						rdbtnFecha.setVisible(true);
						labelModificar1.setVisible(true);
						labelModificar2.setVisible(true);
					}
				}
			}
		});
		
		rdbtnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNombre.isSelected()) {
					dateFecha.setVisible(false);
					labelModificar.setText("Nuevo Nombre: ");
					labelModificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		rdbtnApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnApellido.isSelected()) {
					dateFecha.setVisible(false);
					labelModificar.setText("Nuevo Apellido: ");
					labelModificar.setVisible(true);
					textField.setVisible(true);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		rdbtnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFecha.isSelected()) {
					dateFecha.setVisible(true);
					labelModificar.setText("Nueva Fecha: ");
					labelModificar.setVisible(true);
					textField.setVisible(false);
					btnAceptar.setVisible(true);
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNombre.isSelected()) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String nicknameUsuario = (String) cmbUsuarios.getSelectedItem();
						String nuevoNombre = textField.getText();
						iUsuario.modificarNombre(nicknameUsuario, nuevoNombre);
						nombre.setText(nuevoNombre);
						JOptionPane.showMessageDialog(null, "El nombre fue modificado exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (rdbtnApellido.isSelected()) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						String nickname = (String) cmbUsuarios.getSelectedItem();
						String nuevoApellido = textField.getText();
						iUsuario.modificarApellido(nickname, nuevoApellido);
						apellido.setText(nuevoApellido);
						JOptionPane.showMessageDialog(null, "El apellido fue modificado exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (rdbtnFecha.isSelected()) {
					if(dateFecha.getDate() == null) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						String nickname = (String) cmbUsuarios.getSelectedItem();
						Date nuevaFecha = dateFecha.getDate();
						iUsuario.modificarFechaNacimiento(nickname, nuevaFecha);
						fecha.setText(nuevaFecha.toString());
						JOptionPane.showMessageDialog(null, "La fecha de nacimiento fue modificada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

	}
}
