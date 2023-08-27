package presentacionAltas;

import java.util.Date;
import java.util.List;

import javax.swing.JInternalFrame;

import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class GUIAltaDictadoClase extends JInternalFrame {

    private JComboBox<String> cmbInstituciones;
    private JComboBox<String> cmbActividades;
    private JPanel activityPanel;
    private JTextField textNombre;
    private JTextField textHora;
    private JTextField textProfesor;
    private JTextField textUrl;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;

    public GUIAltaDictadoClase(IClase iClase,IInstitucionDeportiva iInstitucion) {
        setTitle("Alta Dictado de Clases");
        setResizable(true);
        setClosable(true);
        setBounds(100, 100, 450, 400);
        getContentPane().setLayout(null);
        //=============================================
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        Fabrica f = Fabrica.getInstancia();
        //IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
       // IActividadDeportiva iActividad= f.getIActividadDeportiva();
        IClase iClases= f.getIClase();
        
        //==============================================

        cmbInstituciones = new JComboBox<>();
        cmbInstituciones.setBounds(140, 36, 212, 22);
        getContentPane().add(cmbInstituciones);

        JLabel lblNewLabel = new JLabel("Instituciones: ");
        lblNewLabel.setBounds(25, 40, 84, 14);
        getContentPane().add(lblNewLabel);

        cmbActividades = new JComboBox<>();
        cmbActividades.setBounds(140, 93, 212, 22);
        getContentPane().add(cmbActividades);

        JLabel lblNewLabel_1 = new JLabel("Actividades: ");
        lblNewLabel_1.setBounds(25, 97, 84, 14);
        getContentPane().add(lblNewLabel_1);

        activityPanel = new JPanel();
        activityPanel.setBounds(25, 140, 400, 220);
        activityPanel.setLayout(null);
        activityPanel.setVisible(false);
        getContentPane().add(activityPanel);

        textNombre = new JTextField();
        textNombre.setBounds(120, 10, 200, 20);
        activityPanel.add(textNombre);

        textHora = new JTextField();
        textHora.setBounds(120, 40, 200, 20);
        activityPanel.add(textHora);

        textProfesor = new JTextField();
        textProfesor.setBounds(120, 70, 200, 20);
        activityPanel.add(textProfesor);

        textUrl = new JTextField();
        textUrl.setBounds(120, 100, 200, 20);
        activityPanel.add(textUrl);

        JButton btnCrear = new JButton("Crear");
        
        
        btnCrear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	    if (textNombre.getText().isEmpty() || textProfesor.getText().isEmpty() || textHora.getText().isEmpty() || textUrl.getText().isEmpty()) {
        	        // Mostrar un mensaje de error o tomar alguna acción en caso de campos vacíos.
        	        JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
        	        return; // Detener la ejecución debido a campos vacíos.
        	    }
        		//alta dictado de clases..
        	    
        	    String str =(String)cmbInstituciones.getSelectedItem();
        	    
        	    String str2=(String)cmbActividades.getSelectedItem();
        	    InstitucionDeportiva id = iInstitucion.buscarInstitucionDeportiva(str);
        		System.out.println(id.getNombre());
        		System.out.println(str2);
        		ActividadDeportiva ad = id.buscarActividadDeportiva(str2);
        	  
        	    if (ad.buscarClase(textNombre.getText().toString())== null) {
                   
        	    	iClase.altaDictadoClase(textNombre.getText().toString(), ad, fechaActual , textProfesor.getText(), textHora.getText(), textUrl.getText(),fechaActual);
                    JOptionPane.showMessageDialog(null, "Se creó la clase.", textNombre.getText(), JOptionPane.INFORMATION_MESSAGE);
                    dispose();
        	    } else {
                	
                	int result = JOptionPane.showConfirmDialog(null, "\"Ya existe una clase con ese nombre en la actividad seleccionada, ¿Desea Modificarla?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
                    
                    if (result == JOptionPane.OK_OPTION) {
                    	
                    	btnCrear.setText("Editar");
                    	
                    	textNombre.setText("Modificar Clase");
                    	textHora.setText("Modificar hora");
                    	textProfesor.setText("Modificar Profesor");
                        textUrl.setText("Modiicar Url");
                        
                    } else if (result == JOptionPane.CANCEL_OPTION) {
                    	dispose();
                    }
                	
                }
            }
        	
        });
        btnCrear.setBounds(160, 184, 80, 25);
        activityPanel.add(btnCrear);
        
        lblNewLabel_2 = new JLabel("Nombre  Clase:");
        lblNewLabel_2.setBounds(10, 13, 100, 14);
        activityPanel.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Hora Inicio:");
        lblNewLabel_3.setBounds(10, 43, 82, 14);
        activityPanel.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Profesor:");
        lblNewLabel_4.setBounds(10, 73, 82, 14);
        activityPanel.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Url Clase: ");
        lblNewLabel_5.setBounds(10, 103, 82, 14);
        activityPanel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Fecha :");
        lblNewLabel_6.setBounds(10, 140, 115, 15);
        activityPanel.add(lblNewLabel_6);
        
       
        
        JLabel Lblfecha = new JLabel(fechaFormateada);
        Lblfecha.setBounds(120, 140, 120, 15);
        activityPanel.add(Lblfecha);

       
//
        try {
            List<InstitucionDeportiva> ins = iInstitucion.getListaInstituciones();
            for (InstitucionDeportiva i : ins) {
                cmbInstituciones.addItem(i.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//TODO Instituciones
        cmbInstituciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String institucion = (String) cmbInstituciones.getSelectedItem();
                InstitucionDeportiva iD = iInstitucion.buscarInstitucionDeportiva(institucion);
                cmbActividades.removeAllItems();
                try {
                	//TODO Actividades
                    List<ActividadDeportiva> actividades = iD.getArrayActividadDeportiva();
                    for (ActividadDeportiva a : actividades) {
                        cmbActividades.addItem(a.getNombre());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        cmbActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activityPanel.setVisible(true);
            }
        });
    }
}
