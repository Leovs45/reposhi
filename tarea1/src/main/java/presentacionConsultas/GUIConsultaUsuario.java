package presentacionConsultas;

import java.awt.EventQueue;

import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import interfaces.IUsuario;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Profesor;
import logica.Registro;
import logica.Socio;
import logica.Usuario;

import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import datatypes.DtActividad;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class GUIConsultaUsuario extends JInternalFrame {
	private JTable tablaClases;
	private JTable tablaRegistro;
	JComboBox cmbUsuarios = new JComboBox();
	List<Usuario> usuarios = new ArrayList<>();
	JLabel labelNickname = new JLabel("Nickname:");
	JLabel labelNombre = new JLabel("Nombre:");
	JLabel labelApellido = new JLabel("Apellido:");
	JLabel labelEmail = new JLabel("Email: ");
	JLabel labelFechaNac = new JLabel("Fecha Nacimiento:");
	JLabel labelDescripcion = new JLabel("Descripcion:");
	JLabel labelBiografia = new JLabel("Biografia:");
	JLabel labelSitioWeb = new JLabel("Sitio Web:");
	JLabel labelClases = new JLabel("Clases:");
	JLabel nickname = new JLabel("");
	JLabel nombre = new JLabel("");
	JLabel apellido = new JLabel("");
	JLabel email = new JLabel("");
	JLabel fechaNac = new JLabel("");
	JLabel descripcion = new JLabel("");
	JLabel biografia = new JLabel("");
	JLabel sitioWeb = new JLabel("");
	JLabel labelRegistros = new JLabel("Registros:");
	JScrollPane scrollPaneRegistros = new JScrollPane();
	
	private void setupActions(IUsuario iUsuario) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmbUsuarios.removeAllItems();
				List<Usuario> usuariosNuevos = new ArrayList<>();
				usuariosNuevos = iUsuario.getUsuarios();
				usuarios = usuariosNuevos;
					
				for(Usuario u: usuarios) {
					cmbUsuarios.addItem(u.getNickname());
				}
				
				cmbUsuarios.setSelectedIndex(-1);	
			}
		});
	}

	public GUIConsultaUsuario(IUsuario iUsuario) {
		setupActions(iUsuario);
		setClosable(true);
		setTitle("Consultar usuario");
		setBounds(100, 100, 559, 500);
		getContentPane().setLayout(null);
		
		JLabel lblConsultarUsuario = new JLabel("Consultar usuario:");
		lblConsultarUsuario.setBounds(31, 35, 132, 15);
		getContentPane().add(lblConsultarUsuario);

		cmbUsuarios.setBounds(141, 32, 176, 21);
		getContentPane().add(cmbUsuarios);
		
		labelNickname.setBounds(31, 78, 105, 13);
		getContentPane().add(labelNickname);
		
		labelNombre.setBounds(31, 101, 105, 13);
		getContentPane().add(labelNombre);
		
		labelApellido.setBounds(31, 124, 105, 13);
		getContentPane().add(labelApellido);
		
		labelEmail.setBounds(31, 147, 105, 13);
		getContentPane().add(labelEmail);
		
		labelFechaNac.setBounds(31, 170, 105, 15);
		getContentPane().add(labelFechaNac);
		
		labelDescripcion.setBounds(31, 195, 105, 13);
		labelDescripcion.setVisible(false);
		getContentPane().add(labelDescripcion);
		
		labelBiografia.setBounds(31, 218, 105, 13);
		labelBiografia.setVisible(false);
		getContentPane().add(labelBiografia);
		
		labelSitioWeb.setBounds(31, 241, 105, 13);
		labelSitioWeb.setVisible(false);
		getContentPane().add(labelSitioWeb);
		
		labelClases.setBounds(31, 264, 105, 13);
		labelClases.setVisible(false);
		getContentPane().add(labelClases);
		
		nickname.setBounds(147, 78, 308, 13);
		getContentPane().add(nickname);
		
		nombre.setBounds(147, 101, 308, 13);
		getContentPane().add(nombre);
		
		apellido.setBounds(147, 124, 308, 13);
		getContentPane().add(apellido);
		
		email.setBounds(147, 147, 308, 13);
		getContentPane().add(email);
		
		fechaNac.setBounds(147, 171, 308, 13);
		getContentPane().add(fechaNac);
		
		descripcion.setBounds(147, 195, 308, 13);
		getContentPane().add(descripcion);
		
		biografia.setBounds(147, 218, 308, 13);
		getContentPane().add(biografia);
		
		sitioWeb.setBounds(147, 241, 308, 13);
		getContentPane().add(sitioWeb);
		
		labelRegistros.setBounds(31, 195, 73, 13);
		labelRegistros.setVisible(false);
		getContentPane().add(labelRegistros);
		
		tablaRegistro = new JTable();
		tablaClases = new JTable();
		DefaultTableModel modelRegistro = new DefaultTableModel();
		DefaultTableModel modelClases = new DefaultTableModel();
		
		modelRegistro.addColumn("Clase");
		modelRegistro.addColumn("Fecha de Registro");

		JScrollPane scrollPaneClases = new JScrollPane();
		modelClases.addColumn("Nombre");
		modelClases.addColumn("Fecha");
		modelClases.addColumn("Hora de Inicio");
		scrollPaneClases.setBounds(31, 287, 491, 174);
		getContentPane().add(scrollPaneClases);
	
		scrollPaneClases.setViewportView(tablaClases);
		scrollPaneClases.setVisible(false);
		tablaClases.setVisible(false);
		tablaClases.setModel(modelClases);
		
		scrollPaneRegistros.setBounds(29, 218, 493, 243);
		getContentPane().add(scrollPaneRegistros);
		
		scrollPaneRegistros.setViewportView(tablaRegistro);
		tablaRegistro.setVisible(false);
		scrollPaneRegistros.setVisible(false);
		tablaRegistro.setModel(modelRegistro);
		
		cmbUsuarios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreUsuario = (String) cmbUsuarios.getSelectedItem();
				Usuario usuario = iUsuario.buscarUsuario(nombreUsuario);
				if(usuario != null) {
					nickname.setText(usuario.getNickname());
					nombre.setText(usuario.getNombre());
					apellido.setText(usuario.getApellido());
					email.setText(usuario.getCorreoElectronico());
					fechaNac.setText(usuario.getFechaNacimiento().toString());
					
					if(usuario instanceof Socio) {
						Socio socio = (Socio) usuario;
						labelRegistros.setVisible(true);
						labelDescripcion.setVisible(false);
						labelBiografia.setVisible(false);
						labelSitioWeb.setVisible(false);
						labelClases.setVisible(false);
						tablaClases.setVisible(false);
						scrollPaneClases.setVisible(false);
						descripcion.setText("");
						biografia.setText("");
						sitioWeb.setText("");

						modelRegistro.setRowCount(0);
						List<Registro> registros = socio.getArrayRegistro();
						for (Registro r: registros) {
							modelRegistro.addRow(new Object[] {r.getclase().getNombreClase(), r.getfechaRegistro().toString()});
						}

						tablaRegistro.setVisible(true);
						scrollPaneRegistros.setVisible(true);
					} else {
						Profesor profesor = (Profesor) usuario;
						labelRegistros.setVisible(false);
						labelDescripcion.setVisible(true);
						labelBiografia.setVisible(true);
						labelSitioWeb.setVisible(true);
						labelClases.setVisible(true);
						tablaRegistro.setVisible(false);
						scrollPaneRegistros.setVisible(false);
						descripcion.setText(profesor.getDescripcionGeneral());
						biografia.setText(profesor.getBiografia());
						sitioWeb.setText(profesor.getSitioWeb());
						
						modelClases.setRowCount(0);
						List<Clase> clases = profesor.getArrayClases();
						for(Clase c: clases) {
							modelClases.addRow(new Object[] {c.getNombreClase(), c.getFechaClase().toString(), c.getHoraInicio()});
						}

						tablaClases.setVisible(true);
						scrollPaneClases.setVisible(true);
					}
				} else {
					nickname.setText("");
					nombre.setText("");
					apellido.setText("");
					email.setText("");
					fechaNac.setText("");
					labelDescripcion.setVisible(false);
					labelBiografia.setVisible(false);
					labelSitioWeb.setVisible(false);
					labelClases.setVisible(false);
					tablaClases.setVisible(false);
					scrollPaneClases.setVisible(false);
					tablaRegistro.setVisible(false);
					scrollPaneRegistros.setVisible(false);
					labelRegistros.setVisible(false);
				}
			}
		});

	}
}
