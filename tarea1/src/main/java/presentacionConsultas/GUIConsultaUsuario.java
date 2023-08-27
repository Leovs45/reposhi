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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class GUIConsultaUsuario extends JInternalFrame {
	private JTable tablaClases;
	private JTable tablaRegistro;

	public GUIConsultaUsuario(IUsuario iUsuario) {
		setClosable(true);
		setTitle("Consultar usuario");
		setBounds(100, 100, 559, 500);
		getContentPane().setLayout(null);
		
		JLabel lblConsultarUsuario = new JLabel("Consultar usuario:");
		lblConsultarUsuario.setBounds(31, 35, 132, 15);
		getContentPane().add(lblConsultarUsuario);
		
		//TODO borrar
		Fabrica f = Fabrica.getInstancia();
		// Creo institucion
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		iInstitucion.altaInstitucionDeportiva("i1", "descripcion", "url");
		iInstitucion.altaInstitucionDeportiva("i2", "descripcion", "url");
		
		// Creo usuario
		iUsuario.altaUsuario("Mei", "Maite", "Martinez", "mail@false.com", new Date());
		InstitucionDeportiva i1 = iInstitucion.buscarInstitucionDeportiva("i1");
		InstitucionDeportiva i2 = iInstitucion.buscarInstitucionDeportiva("i2");
		iUsuario.altaUsuario("Profe", "Profesor", "Profesoro", "otro@mail.com", new Date(), i1, "Descripcion", "Bio", "sitio web");
		iUsuario.altaUsuario("Profa", "Profesora", "Profesorara", "otro@mail.com", new Date(), i2, "Descripcion", "Bio", "sitio web");
		
		Usuario user1 = iUsuario.buscarUsuario("Profe");
		Usuario user2 = iUsuario.buscarUsuario("Profa");
		
		Profesor profe1 = (Profesor) user1;
		Profesor profe2 = (Profesor) user2;
		
		// Creo actividades
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		iActividad.altaActividadDeportiva(i1, "a1", "Descripcion", 120, 120, new Date());
		iActividad.altaActividadDeportiva(i1, "a3", "Descripcion", 120, 120, new Date());
		iActividad.altaActividadDeportiva(i2, "a2", "Descripcion", 120, 120, new Date());
		iActividad.altaActividadDeportiva(i2, "a4", "Descripcion", 120, 120, new Date());

		ActividadDeportiva a1 = i1.buscarActividadDeportiva("a1");
		ActividadDeportiva a3 = i1.buscarActividadDeportiva("a3");
		ActividadDeportiva a2 = i2.buscarActividadDeportiva("a2");
		ActividadDeportiva a4 = i2.buscarActividadDeportiva("a4");
	
		// Creo clases
		IClase iClase = f.getIClase();
		iClase.altaDictadoClase("c1", a1, new Date(), profe1.getNickname(), "12:00", "url", new Date());
		iClase.altaDictadoClase("c3", a1, new Date(), profe1.getNickname(), "12:00", "url", new Date());
		iClase.altaDictadoClase("c5", a3, new Date(), profe1.getNickname(), "12:00", "url", new Date());
		iClase.altaDictadoClase("c2", a2, new Date(), profe2.getNickname(), "12:00", "url", new Date());
		iClase.altaDictadoClase("c4", a4, new Date(), profe2.getNickname(), "12:00", "url", new Date());
		
		DefaultListModel<String> lista = new DefaultListModel<String>();
		
		JComboBox cmbUsuarios = new JComboBox();

		cmbUsuarios.setBounds(141, 32, 176, 21);
		List<Usuario> usuarios = iUsuario.getUsuarios();
		try {
			for(Usuario u: usuarios) {
				cmbUsuarios.addItem(u.getNickname());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los usuarios", "Error", JOptionPane.ERROR_MESSAGE);
		}
		cmbUsuarios.setSelectedIndex(-1);
		getContentPane().add(cmbUsuarios);
		
		JLabel labelNickname = new JLabel("Nickname:");
		labelNickname.setBounds(31, 78, 105, 13);
		getContentPane().add(labelNickname);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(31, 101, 105, 13);
		getContentPane().add(labelNombre);
		
		JLabel labelApellido = new JLabel("Apellido:");
		labelApellido.setBounds(31, 124, 105, 13);
		getContentPane().add(labelApellido);
		
		JLabel labelEmail = new JLabel("Email: ");
		labelEmail.setBounds(31, 147, 105, 13);
		getContentPane().add(labelEmail);
		
		JLabel labelFechaNac = new JLabel("Fecha Nacimiento:");
		labelFechaNac.setBounds(31, 170, 105, 15);
		getContentPane().add(labelFechaNac);
		
		JLabel labelDescripcion = new JLabel("Descripcion:");
		labelDescripcion.setBounds(31, 195, 105, 13);
		labelDescripcion.setVisible(false);
		getContentPane().add(labelDescripcion);
		
		JLabel labelBiografia = new JLabel("Biografia:");
		labelBiografia.setBounds(31, 218, 105, 13);
		labelBiografia.setVisible(false);
		getContentPane().add(labelBiografia);
		
		JLabel labelSitioWeb = new JLabel("Sitio Web:");
		labelSitioWeb.setBounds(31, 241, 105, 13);
		labelSitioWeb.setVisible(false);
		getContentPane().add(labelSitioWeb);
		
		JLabel labelClases = new JLabel("Clases:");
		labelClases.setBounds(31, 264, 105, 13);
		labelClases.setVisible(false);
		getContentPane().add(labelClases);
		
		JLabel nickname = new JLabel("");
		nickname.setBounds(147, 78, 308, 13);
		getContentPane().add(nickname);
		
		JLabel nombre = new JLabel("");
		nombre.setBounds(147, 101, 308, 13);
		getContentPane().add(nombre);
		
		JLabel apellido = new JLabel("");
		apellido.setBounds(147, 124, 308, 13);
		getContentPane().add(apellido);
		
		JLabel email = new JLabel("");
		email.setBounds(147, 147, 308, 13);
		getContentPane().add(email);
		
		JLabel fechaNac = new JLabel("");
		fechaNac.setBounds(147, 171, 308, 13);
		getContentPane().add(fechaNac);
		
		JLabel descripcion = new JLabel("");
		descripcion.setBounds(147, 195, 308, 13);
		getContentPane().add(descripcion);
		
		JLabel biografia = new JLabel("");
		biografia.setBounds(147, 218, 308, 13);
		getContentPane().add(biografia);
		
		JLabel sitioWeb = new JLabel("");
		sitioWeb.setBounds(147, 241, 308, 13);
		getContentPane().add(sitioWeb);
		
		JLabel labelRegistros = new JLabel("Registros:");
		labelRegistros.setBounds(31, 195, 73, 13);
		labelRegistros.setVisible(false);
		getContentPane().add(labelRegistros);
		
		DefaultTableModel modelRegistro = new DefaultTableModel();
		modelRegistro.addColumn("Clase");
		modelRegistro.addColumn("Fecha de Registro");

		DefaultTableModel modelClases = new DefaultTableModel();
		modelClases.addColumn("Nombre");
		modelClases.addColumn("Fecha");
		modelClases.addColumn("Hora de Inicio");
		
		JScrollPane scrollPaneClases = new JScrollPane();
		scrollPaneClases.setBounds(31, 287, 491, 174);
		getContentPane().add(scrollPaneClases);
		
		tablaClases = new JTable();
		scrollPaneClases.setViewportView(tablaClases);
		scrollPaneClases.setVisible(false);
		tablaClases.setVisible(false);
		tablaClases.setModel(modelClases);
		
		JScrollPane scrollPaneRegistros = new JScrollPane();
		scrollPaneRegistros.setBounds(29, 218, 493, 243);
		getContentPane().add(scrollPaneRegistros);
		
		tablaRegistro = new JTable();
		scrollPaneRegistros.setViewportView(tablaRegistro);
		tablaRegistro.setVisible(false);
		scrollPaneRegistros.setVisible(false);
		tablaRegistro.setModel(modelRegistro);
		
		cmbUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = (String) cmbUsuarios.getSelectedItem();
				Usuario usuario = iUsuario.buscarUsuario(nombreUsuario);
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
			}
		});

	}
}
