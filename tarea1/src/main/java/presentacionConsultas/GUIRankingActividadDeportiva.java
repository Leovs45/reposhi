package presentacionConsultas;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datatypes.DtActividad;
import interfaces.IActividadDeportiva;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.awt.event.ActionEvent;



public class GUIRankingActividadDeportiva extends JInternalFrame {
	private JTable tablaRankingActividad = new JTable();
	List<DtActividad> actividadesOrdenadas;

	private void setupActions(IActividadDeportiva iActividad) {
		addComponentListener(new ComponentAdapter() {
		@Override
			public void componentShown(ComponentEvent e) {
				DefaultTableModel tableModel = new DefaultTableModel();
				tableModel.addColumn("Nombre actividad");
				tableModel.addColumn("Cantidad de inscriptos");
		        tableModel.addColumn("Costo");
		        tableModel.addColumn("Descripción");
		        
		        JScrollPane scrollPane = new JScrollPane(tablaRankingActividad);
		        scrollPane.setBounds(23, 108, 550, 312);
		        getContentPane().add(scrollPane);
		        
		        tablaRankingActividad.setModel(tableModel);
		        
				actividadesOrdenadas = iActividad.getRankingActividades();
				
				if (actividadesOrdenadas.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Error: No hay actividades para mostrar en el ranking.", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{	
		         	 tableModel.setRowCount(0); // Limpiar las filas existentes	
		         	   for (DtActividad ac : actividadesOrdenadas) {
		         		   tableModel.addRow(new Object[]{ac.getCantidadDeClases() ,ac.getNombre(), ac.getCosto(), ac.getDescripcion()});
				            
		         	   	}
				}
			}
		});
	}
	

	public GUIRankingActividadDeportiva(IActividadDeportiva iActividad) {
		setupActions(iActividad);
		
		JLabel lblRankingActividades = new JLabel("Ranking actividades");
		lblRankingActividades.setBounds(217, 32, 164, 15);
		getContentPane().add(lblRankingActividades);
		
		setClosable(true);
		setTitle("Ranking Actividades ");
		setBounds(100, 100, 610, 500);
		getContentPane().setLayout(null);	

	}

}
