package presentacionConsultas;
import java.util.List;
import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import logica.InstitucionDeportiva;//esta mal esto no??
import logica.ActividadDeportiva;//esta mal esto no??
import logica.Clase;
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
import javax.swing.JTable;


public class GUIConsultaActividadDeportiva extends JInternalFrame {

    private JComboBox<String> cmbInstituciones;
    private JComboBox<String> cmbActividades;
    private JLabel lblNombre;
    private JLabel lblFecha;
    private JLabel lblDescrip;
    private JLabel lblCosto;
    private JLabel lblDuracion;
    private JTable tabla;

    public GUIConsultaActividadDeportiva(IActividadDeportiva iActividad) {
        initializeUI(iActividad);
    }

    private void initializeUI(IActividadDeportiva iActividad) {
        setTitle("Consulta Actividad Deportiva");
        setClosable(true);
        setSize(600, 500);
        getContentPane().setLayout(null);

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
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(23, 270, 550, 150);
        getContentPane().add(scrollPane);

        JLabel lblInstitucionDep = new JLabel("Institucion Deportiva:");
        lblInstitucionDep.setBounds(23, 36, 134, 14);
        getContentPane().add(lblInstitucionDep);
        
        JLabel lblNewLabel = new JLabel("Actividades :");
        lblNewLabel.setBounds(23, 83, 108, 14);
        getContentPane().add(lblNewLabel);

        populateComboBoxes(iActividad);

        cmbInstituciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItemInstituciones = (String) cmbInstituciones.getSelectedItem();
                populateActivityComboBox(iActividad, selectedItemInstituciones);
            }
        });

        cmbActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItemActividades = (String) cmbActividades.getSelectedItem();
                handleActivitySelection(iActividad, selectedItemActividades);
            }
        });
    }

    private void populateComboBoxes(IActividadDeportiva iActividad) {
        try {
            Fabrica f = Fabrica.getInstancia();
            IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();

            List<InstitucionDeportiva> ins = iInstitucion.getListaInstituciones();
            for (InstitucionDeportiva i : ins) {
                cmbInstituciones.addItem(i.getNombre());
            }
        } catch (Exception e) {
            showErrorDialog("Error al cargar las instituciones: " + e.getMessage());
        }
    }

    private void populateActivityComboBox(IActividadDeportiva iActividad, String institucion) {
        try {
            cmbActividades.removeAllItems();
            List<ActividadDeportiva> actividades = iActividad.consultaActividadDeportiva(institucion);
            for (ActividadDeportiva actividad : actividades) {
                cmbActividades.addItem(actividad.getNombre());
            }
            lblNombre.setText("Nombre: ");
            lblFecha.setText("Fecha: ");
            lblDescrip.setText("Descripcion: ");
            lblCosto.setText("Costo: ");
            lblDuracion.setText("Duracion: ");
            DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Clase", "URL Clase"}, 0);
            tabla.setModel(tableModel);
        } catch (Exception e) {
            showErrorDialog("Error al cargar las actividades: " + e.getMessage());
        }
    }

    private void handleActivitySelection(IActividadDeportiva iActividad, String selectedItem) {
        try {
            if (selectedItem != null) {
                ActividadDeportiva activity = iActividad.buscarActividadDeportiva(selectedItem);
                if (activity != null) {
                    lblNombre.setText("Nombre: " + activity.getNombre());
                    //formateando fecha
                    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yy"); 
                    String fecha = dt.format(activity.getFechaRegistro());
                    
                    lblFecha.setText("Fecha: " + fecha);
                    lblDescrip.setText("Descripcion: " + activity.getDescripcion());
                    //formateando un double
                    DecimalFormat decimal = new DecimalFormat("#.00");
                    String costo = decimal.format(activity.getCosto());
                    
                    lblCosto.setText("Costo: " + costo);
                    lblDuracion.setText("Duracion: " + activity.getDuracionMinutos());
                    List<Clase> clases = activity.getArrayClase();
                    DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
                    tableModel.setRowCount(0); // Clear existing rows
                    for (Clase cls : clases) {
                        tableModel.addRow(new Object[]{cls.getNombreClase(), cls.getUrlClase()});
                    }
                } else {
                    showErrorDialog("La actividad seleccionada no fue encontrada.");
                }
            }
        } catch (Exception ex) {
            showErrorDialog("Error al consultar actividades: " + ex.getMessage());
        }
    }

    private void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
