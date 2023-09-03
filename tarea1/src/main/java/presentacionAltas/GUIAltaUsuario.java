package presentacionAltas;

import java.awt.EventQueue;
import interfaces.IUsuario;
import interfaces.IInstitucionDeportiva;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;


public class GUIAltaUsuario extends JInternalFrame {
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreoElectronico;
	private JTextField textFieldDescripcion;
	private JTextField textFieldBiografia;
	private JTextField textFieldSitioWeb;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	List<String> instituciones;
	DefaultListModel<String> milista = new DefaultListModel<String>();
	
	private void setupActions(IInstitucionDeportiva iInstitucion) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				instituciones = iInstitucion.getListaNombreInstituciones();
				
				for(String id: instituciones) {
					milista.addElement(id);
				}
			}
		});
	}
	
	public GUIAltaUsuario(IUsuario iUsuario, IInstitucionDeportiva iInstitucion) {
		setClosable(true);
		setResizable(true);
		setupActions(iInstitucion);
		setBounds(100, 100, 550, 500);
		getContentPane().setLayout(null);
		
		JLabel lblEstoEsAlta = new JLabel("Alta Usuario");
		lblEstoEsAlta.setBounds(159, 12, 184, 15);
		lblEstoEsAlta.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(lblEstoEsAlta);
		
		JLabel lblNombre = new JLabel("*Nickname: ");
		lblNombre.setBounds(32, 54, 87, 15);
		getContentPane().add(lblNombre);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(206, 52, 137, 19);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("*Nombre: ");
		lblNombre_1.setBounds(32, 85, 70, 15);
		getContentPane().add(lblNombre_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(206, 83, 137, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("*Apellido: ");
		lblApellido.setBounds(32, 116, 87, 15);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(206, 114, 137, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("*E-Mail");
		lblNewLabel.setBounds(32, 148, 70, 15);
		getContentPane().add(lblNewLabel);
		
		textFieldCorreoElectronico = new JTextField();
		textFieldCorreoElectronico.setBounds(206, 146, 137, 19);
		getContentPane().add(textFieldCorreoElectronico);
		textFieldCorreoElectronico.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("*Fecha de Nacimiento: ");
		lblNewLabel_1.setBounds(32, 180, 169, 15);
		getContentPane().add(lblNewLabel_1);
		
		JDateChooser dateFechaNac = new JDateChooser();
		dateFechaNac.setBounds(206, 176, 137, 19);
		getContentPane().add(dateFechaNac);
		
		JLabel lblInstitucion = new JLabel("Institucion: ");
		lblInstitucion.setEnabled(false);
		lblInstitucion.setBounds(32, 212, 87, 15);
		getContentPane().add(lblInstitucion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(206, 210, 137, 103);
		getContentPane().add(scrollPane);
		JList listaInstitucion = new JList();
		scrollPane.setViewportView(listaInstitucion);
		listaInstitucion.setEnabled(false);

		listaInstitucion.setModel(milista);
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setEnabled(false);
		lblDescripcion.setBounds(32, 332, 104, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEnabled(false);
		textFieldDescripcion.setBounds(206, 330, 137, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblBiografia = new JLabel("Biografia: ");
		lblBiografia.setEnabled(false);
		lblBiografia.setBounds(32, 364, 87, 15);
		getContentPane().add(lblBiografia);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setEnabled(false);
		textFieldBiografia.setBounds(206, 361, 137, 19);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		JLabel lblSitioWeb = new JLabel("Sitio Web: ");
		lblSitioWeb.setEnabled(false);
		lblSitioWeb.setBounds(32, 396, 87, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setEnabled(false);
		textFieldSitioWeb.setBounds(206, 394, 137, 19);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		JRadioButton rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSocio.isSelected())
					lblInstitucion.setEnabled(false);
					listaInstitucion.setEnabled(false);
					lblDescripcion.setEnabled(false);
					textFieldDescripcion.setEnabled(false);
					lblBiografia.setEnabled(false);
					textFieldBiografia.setEnabled(false);
					lblSitioWeb.setEnabled(false);
					textFieldSitioWeb.setEnabled(false);
			}
		});
		rdbtnSocio.setSize(87, 23);
		rdbtnSocio.setLocation(395, 96);
		rdbtnSocio.setSelected(true);
		buttonGroup.add(rdbtnSocio);
		getContentPane().add(rdbtnSocio);
		
		JRadioButton rdbtnProfesor = new JRadioButton("Profesor");
		buttonGroup.add(rdbtnProfesor);
		rdbtnProfesor.setBounds(395, 144, 87, 23);
		getContentPane().add(rdbtnProfesor);
		
		JLabel lblError1 = new JLabel("Ingrese los campos");
		lblError1.setForeground(Color.RED);
		lblError1.setBounds(377, 375, 151, 20);
		getContentPane().add(lblError1);
		lblError1.setVisible(false);
		
		JLabel lblError2 = new JLabel("que tienen un *");
		lblError2.setForeground(Color.RED);
		lblError2.setBounds(377, 396, 135, 15);
		getContentPane().add(lblError2);
		lblError2.setVisible(false);
		
		JLabel lblUsuarioIngresado = new JLabel("Usuario ingresado");
		lblUsuarioIngresado.setForeground(Color.GREEN);
		lblUsuarioIngresado.setBounds(377, 429, 135, 15);
		getContentPane().add(lblUsuarioIngresado);
		lblUsuarioIngresado.setVisible(false);
		
		JLabel lblUsuarioExistente = new JLabel("Usuario existente");
		lblUsuarioExistente.setForeground(Color.RED);
		lblUsuarioExistente.setBounds(377, 378, 137, 15);
		getContentPane().add(lblUsuarioExistente);
		lblUsuarioExistente.setVisible(false);
		
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnProfesor.isSelected())
					lblInstitucion.setEnabled(true);
					listaInstitucion.setEnabled(true);
					lblDescripcion.setEnabled(true);
					textFieldDescripcion.setEnabled(true);
					lblBiografia.setEnabled(true);
					textFieldBiografia.setEnabled(true);
					lblSitioWeb.setEnabled(true);
					textFieldSitioWeb.setEnabled(true);
			}
		});

	

		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        try {
			            String nickname = textFieldNickname.getText();

			            if (iUsuario.buscarUsuario(nickname) != null) {
			                lblError1.setVisible(false);
			                lblError2.setVisible(false);
			                lblUsuarioIngresado.setVisible(false);
			                lblUsuarioExistente.setVisible(true);
			            } else {
			                String nombre = textFieldNombre.getText();
			                String apellido = textFieldApellido.getText();
			                String email = textFieldCorreoElectronico.getText();
			                Date fechaNac = dateFechaNac.getDate();

			                if (rdbtnSocio.isSelected()) {
			                    if (textFieldNickname.getText().isEmpty()
			                            || textFieldNombre.getText().isEmpty()
			                            || textFieldApellido.getText().isEmpty()
			                            || textFieldCorreoElectronico.getText().isEmpty()
			                            || dateFechaNac.getDate() == null) {
			                        lblError1.setVisible(true);
			                        lblError2.setVisible(true);
			                        lblUsuarioIngresado.setVisible(false);
			                    } else {
			                        lblError1.setVisible(false);
			                        lblError2.setVisible(false);
			                        lblUsuarioIngresado.setVisible(true);
			                        iUsuario.altaUsuario(nickname, nombre, apellido, email, fechaNac);
			                    }

			                } else if (rdbtnProfesor.isSelected()) {
			                    if (textFieldNickname.getText().isEmpty()
			                            || textFieldNombre.getText().isEmpty()
			                            || textFieldApellido.getText().isEmpty()
			                            || textFieldCorreoElectronico.getText().isEmpty()
			                            || listaInstitucion.getSelectedIndex() == -1
			                            || dateFechaNac.getDate() == null
			                            || textFieldDescripcion.getText().isEmpty()
			                            || textFieldBiografia.getText().isEmpty()
			                            || textFieldSitioWeb.getText().isEmpty()) {
			                        lblError1.setVisible(true);
			                        lblError2.setVisible(true);
			                        lblUsuarioIngresado.setVisible(false);
			                    } else {
			                        String nombreInstitucion = listaInstitucion.getSelectedValue().toString();
			                        String descripcion = textFieldDescripcion.getText();
			                        String biografia = textFieldBiografia.getText();
			                        String sitioweb = textFieldSitioWeb.getText();

			                        lblError1.setVisible(false);
			                        lblError2.setVisible(false);
			                        lblUsuarioIngresado.setVisible(true);
			                        iUsuario.altaUsuario(nickname, nombre, apellido, email, fechaNac, iInstitucion.buscarInstitucionDeportiva(nombreInstitucion), descripcion, biografia, sitioweb);
			                    }
			                }
			            }
			        } catch (NicknameRepetidoException ex) {
			            lblError1.setVisible(false);
			            lblError2.setVisible(false);
			            lblUsuarioIngresado.setVisible(false);
			            lblUsuarioExistente.setVisible(true);
			            lblUsuarioExistente.setText("Error: Nickname ya registrado");
			        } catch (EmailRepetidoException ex) {
			            lblError1.setVisible(false);
			            lblError2.setVisible(false);
			            lblUsuarioIngresado.setVisible(false);
			            lblUsuarioExistente.setVisible(true);
			            lblUsuarioExistente.setText("Error: Email ya registrado");
			        }
			    }
			});
		
		btnAgregar.setBounds(395, 327, 117, 25);
		getContentPane().add(btnAgregar);
	}
			
			
			/*
			public void actionPerformed(ActionEvent e) {
				String nickname = textFieldNickname.getText();
				if (iUsuario.buscarUsuario(nickname) != null) {
					lblError1.setVisible(false);
					lblError2.setVisible(false);
					lblUsuarioIngresado.setVisible(false);
					lblUsuarioExistente.setVisible(true);
				}else {
					String nombre = textFieldNombre.getText();
					String apellido = textFieldApellido.getText();
					String email = textFieldCorreoElectronico.getText();
					Date fechaNac = dateFechaNac.getDate();
					
					if(rdbtnSocio.isSelected()) {
						if(textFieldNickname.getText().isEmpty()
								|| textFieldNombre.getText().isEmpty() 
								|| textFieldApellido.getText().isEmpty() 
								|| textFieldCorreoElectronico.getText().isEmpty()
								|| dateFechaNac.getDate() == null ) {
								lblError1.setVisible(true);
								lblError2.setVisible(true);
								lblUsuarioIngresado.setVisible(false);
						}else {
							lblError1.setVisible(false);
							lblError2.setVisible(false);					
							lblUsuarioIngresado.setVisible(true);
							iUsuario.altaUsuario(nickname, nombre, apellido, email, fechaNac);
						}
						
					}
					else if(rdbtnProfesor.isSelected()) {
						if(textFieldNickname.getText().isEmpty() 
								|| textFieldNombre.getText().isEmpty() 
								|| textFieldApellido.getText().isEmpty() 
								|| textFieldCorreoElectronico.getText().isEmpty()
								|| listaInstitucion.getSelectedIndex() == -1
								|| dateFechaNac.getDate() == null 
								|| textFieldDescripcion.getText().isEmpty()
								|| textFieldBiografia.getText().isEmpty()
								|| textFieldSitioWeb.getText().isEmpty()) {
							lblError1.setVisible(true);
							lblError2.setVisible(true);
							lblUsuarioIngresado.setVisible(false);
						}
						else {
							String nombreInstitucion = listaInstitucion.getSelectedValue().toString();							
							String descripcion = textFieldDescripcion.getText();
							String biografia = textFieldBiografia.getText();
							String sitioweb = textFieldSitioWeb.getText();
							lblError1.setVisible(false);
							lblError2.setVisible(false);
							lblUsuarioIngresado.setVisible(true);
							iUsuario.altaUsuario( nickname, nombre, apellido, email, fechaNac , iInstitucion.buscarInstitucionDeportiva(nombreInstitucion), descripcion, biografia, sitioweb);
	
						}
					}
				}
			}	
		});*/
		
}

