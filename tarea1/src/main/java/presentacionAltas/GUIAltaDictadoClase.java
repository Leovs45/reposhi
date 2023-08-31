package presentacionAltas;

import java.util.Date;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import interfaces.IUsuario;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;



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
    //======================================================================================================
    public void pegarLimpieza() {//TODO funcion para limiar componetes
        //cmbInstituciones.setSelectedIndex(0); // Esto restablece el JComboBox a su primer ítem (si lo deseas)
       // cmbActividades.setSelectedIndex(0); // Esto restablece el JComboBox a su primer ítem (si lo deseas)
        //activityPanel.removeAll(); // Esto elimina todos los componentes dentro del JPanel
        
        // Borra el contenido de los JTextFields
        textNombre.setText("");
        textHora.setText("");
        textProfesor.setText("");
        textUrl.setText("");
    }
//======================================================================================
    public GUIAltaDictadoClase(IClase iClase,IInstitucionDeportiva iInstitucion, IActividadDeportiva iActividad, IUsuario iUsuario) {
        setTitle("Alta Dictado de Clases");
        setResizable(true);
        setClosable(true);
        setBounds(100, 100, 450, 400);
        getContentPane().setLayout(null);
        //=============================================
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        
        
        
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
        btnCrear.setBounds(160, 184, 80, 25);
        activityPanel.add(btnCrear);
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textNombre.getText().isEmpty() || textProfesor.getText().isEmpty() || textHora.getText().isEmpty() || textUrl.getText().isEmpty()) {
                    // Mostrar un mensaje de error o tomar alguna acción en caso de campos vacíos.
                    JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
                    return; // Detener la ejecución debido a campos vacíos.
                }
                System.out.println("test1");
                // Alta dictado de clases...
                String str = (String) cmbInstituciones.getSelectedItem();
                String str2 = (String) cmbActividades.getSelectedItem();

                if (!iActividad.existeClaseEnActividad(str2, textNombre.getText())) {
                	if(iUsuario.existeUsuario(textProfesor.getText())) {
                		if(iUsuario.esProfesor(textProfesor.getText())) {
		                    iClase.altaDictadoClase(textNombre.getText().toString(), iInstitucion.obtenerActividadDeUnaInstitucion(str, str2), fechaActual, textProfesor.getText(), textHora.getText(), textUrl.getText(), fechaActual);
		                    JOptionPane.showMessageDialog(null, "Se creó la clase.", textNombre.getText(), JOptionPane.INFORMATION_MESSAGE);
		                    pegarLimpieza();
                		}
                	}
                	 //^^Agregar una excepcion si no existe o si no es profesor
                } else {
                    int result = JOptionPane.showConfirmDialog(null, "¿Desea Modificarla?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        // Realizar la edición ???
                        
                        JOptionPane.showMessageDialog(null, "Se Editó la clase.", textNombre.getText(), JOptionPane.INFORMATION_MESSAGE);
                        pegarLimpieza();
                    
                    } else if (result == JOptionPane.CANCEL_OPTION) {
                        // Cancelar la operación o realizar alguna otra acción.
                    	//pegarLimpieza();
                    	dispose();
                    }
                }
            }
        });

       

        
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
            List<String> ins = iInstitucion.getListaNombreInstituciones();
            for (String i : ins) {
                cmbInstituciones.addItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//TODO Instituciones
        cmbInstituciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String institucion = (String) cmbInstituciones.getSelectedItem();
                //InstitucionDeportiva iD = iInstitucion.buscarInstitucionDeportiva(institucion);
                cmbActividades.removeAllItems();
                try {
                	//TODO Actividades
                    List<String> actividades = iInstitucion.obtenerActividadesDeUnaInstitucion(institucion);
                    for (String a : actividades) {
                        cmbActividades.addItem(a);
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
    