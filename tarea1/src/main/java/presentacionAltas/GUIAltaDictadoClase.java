package presentacionAltas;

import java.util.Date;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import interfaces.IUsuario;
import datatypes.DtProfesor;
import excepciones.ClaseRepetidaException;
import datatypes.DtActividad;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;



public class GUIAltaDictadoClase extends JInternalFrame {
	private JComboBox cmbInstituciones = new JComboBox();
    private JComboBox cmbActividades = new JComboBox();
    private JComboBox cmbProfesor = new JComboBox();
    private JPanel activityPanel;
    private JTextField textNombre;
    private JTextField textHora;
    private JTextField textUrl;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
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

    public void pegarLimpieza() {
        textNombre.setText("");
        textHora.setText("");
        cmbProfesor.setSelectedIndex(-1);
        textUrl.setText("");
    }

    public GUIAltaDictadoClase(IClase iClase,IInstitucionDeportiva iInstitucion, IActividadDeportiva iActividad, IUsuario iUsuario) {
        setupActions(iInstitucion);
    	setTitle("Alta Dictado de Clases");
        setResizable(true);
        setClosable(true);
        setBounds(100, 100, 450, 400);
        getContentPane().setLayout(null);
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
        String fechaFormateada = formatoFecha.format(fechaActual);


        cmbInstituciones.setBounds(145, 36, 200, 22);
        getContentPane().add(cmbInstituciones);

        JLabel lblNewLabel = new JLabel("Instituciones: ");
        lblNewLabel.setBounds(25, 40, 84, 14);
        getContentPane().add(lblNewLabel);

        cmbActividades = new JComboBox<>();
        cmbActividades.setBounds(145, 93, 200, 22);
        getContentPane().add(cmbActividades);

        JLabel lblNewLabel_1 = new JLabel("Actividades: ");
        lblNewLabel_1.setBounds(25, 97, 84, 14);
        getContentPane().add(lblNewLabel_1);

        activityPanel = new JPanel();
        activityPanel.setBounds(25, 140, 368, 220);
        activityPanel.setLayout(null);
        activityPanel.setVisible(false);
        getContentPane().add(activityPanel);

        textNombre = new JTextField();
        textNombre.setBounds(120, 10, 200, 20);
        activityPanel.add(textNombre);

        textHora = new JTextField();
        textHora.setBounds(120, 40, 200, 20);
        activityPanel.add(textHora);

        textUrl = new JTextField();
        textUrl.setBounds(120, 100, 200, 20);
        activityPanel.add(textUrl);
        
        cmbProfesor.setBounds(120, 70, 200, 21);
        cmbProfesor.setSelectedIndex(-1);
        activityPanel.add(cmbProfesor);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(160, 184, 80, 25);
        activityPanel.add(btnCrear);
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textNombre.getText().isEmpty() || cmbProfesor.getSelectedIndex() == -1 || textHora.getText().isEmpty() || textUrl.getText().isEmpty()) {
                    // Mostrar un mensaje de error o tomar alguna acción en caso de campos vacíos.
                    JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
                    return; // Detener la ejecución debido a campos vacíos.
                }
                // Alta dictado de clases...
                String str = (String) cmbInstituciones.getSelectedItem();
                String str2 = (String) cmbActividades.getSelectedItem();
            	try {
            		String profesor = (String) cmbProfesor.getSelectedItem();
                    iClase.altaDictadoClase(textNombre.getText().toString(), iInstitucion.obtenerActividadDeUnaInstitucion(str, str2), fechaActual, profesor, textHora.getText(), textUrl.getText(), fechaActual);
                    JOptionPane.showMessageDialog(null, "Se creó la clase.", textNombre.getText(), JOptionPane.INFORMATION_MESSAGE);
                    pegarLimpieza();
            	}catch(ClaseRepetidaException claseRep) {
            		JOptionPane.showMessageDialog(null, claseRep.getMessage(), "CLASE EXISTENTE", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });

       

        
        lblNewLabel_2 = new JLabel("Nombre Clase:");
        lblNewLabel_2.setBounds(0, 13, 100, 14);
        activityPanel.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Hora Inicio:");
        lblNewLabel_3.setBounds(0, 43, 82, 14);
        activityPanel.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Profesor:");
        lblNewLabel_4.setBounds(0, 73, 82, 14);
        activityPanel.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Url Clase: ");
        lblNewLabel_5.setBounds(0, 103, 82, 14);
        activityPanel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Fecha :");
        lblNewLabel_6.setBounds(0, 140, 115, 15);
        activityPanel.add(lblNewLabel_6);
        
       
        
        JLabel Lblfecha = new JLabel(fechaFormateada);
        Lblfecha.setBounds(120, 140, 120, 15);
        activityPanel.add(Lblfecha);


        cmbInstituciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cmbActividades.setSelectedIndex(-1);
                String institucion = (String) cmbInstituciones.getSelectedItem();
                cmbActividades.removeAllItems();
                if(institucion != null) {
                	List<String> actividades = iInstitucion.obtenerActividadesDeUnaInstitucion(institucion);
                    for (String a : actividades) {
                        cmbActividades.addItem(a);
                    }
                }
            }
        });

        cmbActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cmbProfesor.setSelectedIndex(-1);
                activityPanel.setVisible(true);
                cmbProfesor.removeAllItems();
                	
                List<DtProfesor> profesores = iUsuario.getListaProfesores();
                
                for(DtProfesor p: profesores) {
                	cmbProfesor.addItem(p.getNickname());
                }
            }
        });
        
        
        
	  
    }
}
    