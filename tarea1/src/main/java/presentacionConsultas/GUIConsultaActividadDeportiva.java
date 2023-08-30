package presentacionConsultas;

import java.util.List;
import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import datatypes.DtActividad;
import datatypes.DtClase;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIConsultaActividadDeportiva extends JInternalFrame {

    private JComboBox<String> cmbInstituciones;
    private JComboBox<String> cmbActividades;
    private JLabel lblNombre;
    private JLabel lblFecha;
    private JLabel lblDescrip;
    private JLabel lblCosto;
    private JLabel lblDuracion;
    private JTable tabla;

    public GUIConsultaActividadDeportiva(IActividadDeportiva iActividad, IInstitucionDeportiva iInstitucion) {
  
        setTitle("Consulta Actividad Deportiva");
        setClosable(true);
        setSize(600, 500);
        getContentPane().setLayout(null);
//======================================================================
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(23, 136, 500, 15);
        getContentPane().add(lblNombre);

        lblFecha = new JLabel("Fecha: ");
        lblFecha.setBounds(23, 162, 500, 15);
        getContentPane().add(lblFecha);

        lblDescrip = new JLabel("Descripcion: ");
        lblDescrip.setBounds(23, 188, 500, 15);
        getContentPane().add(lblDescrip);

        lblCosto = new JLabel("Costo: ");
        lblCosto.setBounds(23, 214, 500, 15);
        getContentPane().add(lblCosto);

        lblDuracion = new JLabel("Duracion: ");
        lblDuracion.setBounds(23, 240, 500, 15);
        getContentPane().add(lblDuracion);

        cmbInstituciones = new JComboBox<>();
        cmbInstituciones.setBounds(185, 32, 189, 22);
        getContentPane().add(cmbInstituciones);

        cmbActividades = new JComboBox<>();
        cmbActividades.setBounds(185, 79, 188, 22);
        getContentPane().add(cmbActividades);

        tabla = new JTable();
    
        DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
        tableModel.addColumn("Nombre de Clase");
        tableModel.addColumn("URL de Clase");
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(23, 270, 550, 150);
        
        getContentPane().add(scrollPane);

        JLabel lblInstitucionDep = new JLabel("Institucion Deportiva:");
        lblInstitucionDep.setBounds(23, 36, 134, 14);
        getContentPane().add(lblInstitucionDep);
        
        JLabel lblNewLabel = new JLabel("Actividades :");
        lblNewLabel.setBounds(23, 83, 108, 14);
        getContentPane().add(lblNewLabel);
 //==========================Cargo combo institucion deportiva ============================================
        try {
        	List<String> ins = iInstitucion.getListaNombreInstituciones();
            for (String i : ins) {
                cmbInstituciones.addItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
  
//==================================Evento para click en la tabla ==================================== 
        tabla.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        
                    int filaSeleccionada = tabla.getSelectedRow();
                    int columnaSeleccionada = tabla.getSelectedColumn();
                    
                    if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
                        Object valorCelda = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
                        JOptionPane.showMessageDialog(null, "Aca llamo a Consulta dicatado de clase y muestro datos" + valorCelda, "Celda Clickeada", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
        	}
        });
        
        
//====================================================================== 
                
        //TODO instituciones action Listener
        cmbInstituciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String institucion = (String) cmbInstituciones.getSelectedItem();
                cmbActividades.removeAllItems();
                try {
                	//TODO Cargo combo de actividades
                	List<String> act = iInstitucion.obtenerActividadesDeUnaInstitucion(institucion);
                    for (String a : act) {
                        cmbActividades.addItem(a);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
//TODO actividades action listener
        cmbActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItemActividades = (String) cmbActividades.getSelectedItem();
                try {
                   if (selectedItemActividades != null) {
                	   String institucion = (String) cmbInstituciones.getSelectedItem();                	   
                	   DtActividad actividadEncontrada = iInstitucion.obtenerActividadDeUnaInstitucion(institucion, selectedItemActividades);
                       lblNombre.setText("Nombre: " + actividadEncontrada.getNombre());
                	   // Formateando fecha
                	   SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yy"); 
                	   String fecha = dt.format(actividadEncontrada.getFechaRegistro());
                	   lblFecha.setText("Fecha: " + fecha);
                	   lblDescrip.setText("Descripción: " + actividadEncontrada.getDescripcion());
                	   // Formateando un double
                	   DecimalFormat decimal = new DecimalFormat("#.00");
                	   String costo = decimal.format(actividadEncontrada.getCosto());
                	   lblCosto.setText("Costo: " + costo);
                	   lblDuracion.setText("Duración: " + actividadEncontrada.getDuracionMinutos());

                	   List<DtClase> clases = iActividad.getarrDtClase(selectedItemActividades);
                	   DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
                	   tableModel.setRowCount(0); // Limpiar las filas existentes

                	   for (DtClase cls : clases) {
                		   tableModel.addRow(new Object[]{cls.getNombre(), cls.getUrl()});
                	   }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al consultar actividades: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
    //============================================================================================

    }
}


