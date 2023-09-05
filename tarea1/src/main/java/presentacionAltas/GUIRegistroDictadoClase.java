package presentacionAltas;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.IRegistro;
import interfaces.IInstitucionDeportiva;
import interfaces.IUsuario;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import datatypes.DtUsuario;
import excepciones.RegistroClaseRepetidoException;
import datatypes.DtActividad;
import datatypes.DtClase;
import datatypes.DtInstitucion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;

public class GUIRegistroDictadoClase extends JInternalFrame {
	/**
	 * Create the frame.
	 * @return 
	 */
	JLabel lblTitulo = new JLabel("ALTA DE REGISTRO A DICTADO DE CLASE");
	JLabel lblInstitucion = new JLabel("Institucion:");
	JComboBox cmb_instituciones = new JComboBox();
	JLabel lblActDep = new JLabel("Actividad Deportiva:");
	JComboBox cmb_actsdeps = new JComboBox();
	JLabel lblClases = new JLabel("Clases:");
	JComboBox cmb_clases = new JComboBox();
	JLabel lbl_socios = new JLabel("Socio/a a inscribir:");
	JComboBox cmb_socios = new JComboBox();
	JButton btnAceptar = new JButton("Aceptar");
    JButton btnCancelar = new JButton("Cancelar");
	public void limpiarCampos() {
		cmb_socios.setEnabled(false);
		cmb_socios.setSelectedIndex(-1);
		cmb_socios.removeAllItems();
		cmb_clases.setEnabled(false);
		cmb_clases.setSelectedIndex(-1);
		cmb_clases.removeAllItems();
		cmb_actsdeps.setEnabled(false);
		cmb_actsdeps.setSelectedIndex(-1);
		cmb_actsdeps.removeAllItems();
		cmb_instituciones.setSelectedIndex(-1);
    }

	public GUIRegistroDictadoClase(IRegistro iRegistro, IUsuario iUsuario, IInstitucionDeportiva iInstitucion) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		List<DtInstitucion> ins = iInstitucion.getInstituciones();        
        
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 11, 414, 14);
        getContentPane().add(lblTitulo);
        
        
        lblInstitucion.setToolTipText("Seleccione la institucion a traves de la cual se ofrece la actividad deportiva");
        lblInstitucion.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInstitucion.setBounds(20, 35, 70, 25);
        getContentPane().add(lblInstitucion);
        
        
        cmb_instituciones.setName("Instituciones");
        cmb_instituciones.setBounds(150, 35, 275, 25);
        getContentPane().add(cmb_instituciones);       
        
        
        lblActDep.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblActDep.setToolTipText("Seleccione la actividad para la cual quiere hacer el registro");
        lblActDep.setBounds(20, 75, 120, 25);
        getContentPane().add(lblActDep);
        
        
        cmb_actsdeps.setEnabled(false);
        cmb_actsdeps.setBounds(150, 75, 275, 25);
        getContentPane().add(cmb_actsdeps);
        
        
        lblClases.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblClases.setToolTipText("Lista las clases con su información básica, para la actividad seleccionada en la institución seleccionada");
        lblClases.setBounds(20, 115, 120, 25);
        getContentPane().add(lblClases);
        
        
        cmb_clases.setEnabled(false);
        cmb_clases.setBounds(150, 115, 275, 25);
        getContentPane().add(cmb_clases);
        
        
        lbl_socios.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_socios.setToolTipText("Hace una lista de todas las personas asociadas");
        lbl_socios.setBounds(20, 155, 120, 25);
        getContentPane().add(lbl_socios);
        
        
        cmb_socios.setEnabled(false);
        cmb_socios.setBounds(150, 155, 275, 25);
        getContentPane().add(cmb_socios);
        
        
        btnAceptar.setBounds(335, 330, 90, 25);
        btnAceptar.setEnabled(false);
        getContentPane().add(btnAceptar);
        
        btnCancelar.setBounds(235, 330, 90, 25);
        getContentPane().add(btnCancelar);
        
        try {
        	for (DtInstitucion i : ins) {
        		cmb_instituciones.addItem(i.getNombre());
            }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error al cargar las instituciones", "Error", JOptionPane.ERROR_MESSAGE);
        }
        getContentPane().add(cmb_instituciones);
        
        limpiarCampos();
        
        cmb_instituciones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//si elijo una institucion, habilito y lleno activiades deportivas
				if(cmb_instituciones.getSelectedIndex() != -1) {
					String nombreInstitucion = (String) cmb_instituciones.getSelectedItem();
					DtInstitucion institucion = iInstitucion.getDtInstitucion(nombreInstitucion);
					//aca entraria solo si no hay institucion seleccionada, porque la institucion siempre va a existir.
					if(institucion == null || cmb_instituciones.getSelectedIndex() == -1) {
						cmb_actsdeps.setEnabled(false);
						cmb_actsdeps.setSelectedIndex(-1);
						cmb_clases.setEnabled(false);
						cmb_clases.setSelectedIndex(-1);
						cmb_socios.setEnabled(false);
						cmb_socios.setSelectedIndex(-1);
						btnAceptar.setEnabled(false);
					} 
					//si no tengo seleccionada la nada misma, busco las actividades deportivas correspondientes a la institucion seleccionada
					else {
						List<DtActividad> actividades = institucion.getActividades();
						cmb_actsdeps.removeAllItems();
						for(DtActividad a: actividades) {
							cmb_actsdeps.addItem(a.getNombre());
						}
						//Dejo en teoría el combobox seleccionando la nada misma, pero activado
						cmb_actsdeps.setSelectedIndex(-1);
						cmb_actsdeps.setEnabled(true);
											
					}
				}
			}
		});
        
        cmb_actsdeps.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
				String nombreInstitucion = (String) cmb_instituciones.getSelectedItem();
				DtInstitucion institucion = iInstitucion.getDtInstitucion(nombreInstitucion);
				String nombreActividad = (String) cmb_actsdeps.getSelectedItem();
				if(cmb_actsdeps.getSelectedIndex() != -1) {
					DtActividad actividad = institucion.buscarDtActividad(nombreActividad);
					List<DtClase> clases = actividad.getClases();
					cmb_clases.removeAllItems();
					for(DtClase c: clases) {
						cmb_clases.addItem(c.getNombre());
					}
					cmb_clases.setSelectedIndex(-1);
					cmb_clases.setEnabled(true);
				} else {
					cmb_clases.setEnabled(false);
					cmb_clases.setSelectedIndex(-1);
					cmb_socios.setEnabled(false);
					cmb_socios.setSelectedIndex(-1);
				}
			}
		});
        
        cmb_clases.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nombreInstitucion = (String) cmb_instituciones.getSelectedItem();
				DtInstitucion institucion = iInstitucion.getDtInstitucion(nombreInstitucion);
				String nombreActividad = (String) cmb_actsdeps.getSelectedItem();
				DtActividad actividad = institucion.buscarDtActividad(nombreActividad);
				String clasesel = (String) cmb_clases.getSelectedItem();
				DtClase clase = actividad.buscarDtClase(clasesel);
				if(cmb_clases.getSelectedIndex() != -1) {
					List<DtUsuario> usuarios = iUsuario.getUsuarios();
					cmb_socios.removeAllItems();
					for(DtUsuario u: usuarios) {
						if (iUsuario.esSocio(u.getNickname())) {
							cmb_socios.addItem(u.getNickname());
						}
					}
					cmb_socios.setEnabled(true);
					cmb_socios.setSelectedIndex(-1);
				} else {
					cmb_socios.setEnabled(false);
					cmb_socios.setSelectedIndex(-1);
				}
				
			}
		});
        
        cmb_socios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmb_socios.getSelectedIndex() != -1){
					btnAceptar.setEnabled(true);			
				} else {
					btnAceptar.setEnabled(false);
					}
				}
			});
        
        
        btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String clasesel = (String) cmb_clases.getSelectedItem();
				String sociosel = (String) cmb_socios.getSelectedItem();
				iRegistro.RegistroDictadoClases(new Date(), sociosel , clasesel);
				 JOptionPane.showMessageDialog(null, "Se agregó un registro nuevo", "Exito", JOptionPane.INFORMATION_MESSAGE);
				//Limpia los campos
            	limpiarCampos();
				}catch(RegistroClaseRepetidoException exc) {
            		JOptionPane.showMessageDialog(null, exc.getMessage(),"Registro repetido", JOptionPane.ERROR_MESSAGE);
            		}
			}
		});
        
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                //Limpia los campos
            	limpiarCampos();
				//Cierra el InternalFrame
                dispose();
        	}
        });
        
     // Add a window listener to handle the windowClosing event
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
            	limpiarCampos();
				dispose();
            }
            
        });
        
        
	}
}
