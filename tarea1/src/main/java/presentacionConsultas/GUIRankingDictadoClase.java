package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IActividadDeportiva;
import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datatypes.DtActividad;
import datatypes.DtClase;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class GUIRankingDictadoClase extends JInternalFrame {
	private JTable tablaRankingClaseDictado = new JTable();
	List<DtClase> claseOrdenadas;
	
	private void setupActions(IClase iClase) {
		addComponentListener(new ComponentAdapter() {
		@Override
		public void componentShown(ComponentEvent e) {
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.addColumn("Nombre de Clase");
			tableModel.addColumn("Cantidad de Clases");
	        tableModel.addColumn("Fecha de la clase");
	        tableModel.addColumn("URL de Clase");
	        
	        JScrollPane scrollPane = new JScrollPane(tablaRankingClaseDictado);
	        scrollPane.setBounds(23, 108, 550, 312);
	        getContentPane().add(scrollPane);
	        
	        tablaRankingClaseDictado.setModel(tableModel);
	        
			claseOrdenadas = iClase.getRankingClases();
			
			if (claseOrdenadas.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error: No hay actividades para mostrar en el ranking.", "Error", JOptionPane.ERROR_MESSAGE);
			}else{	
	         	tableModel.setRowCount(0); // Limpiar las filas existentes	
	         	for (DtClase cl : claseOrdenadas) {
          		   tableModel.addRow(new Object[]{cl.getCantidadClases() ,cl.getNombre(), cl.getFechaClase(), cl.getUrl()});
			            
          	   	}
			}
		}
	});
	}


	public GUIRankingDictadoClase(IClase iClase) {
		setupActions(iClase);
		setClosable(true);
		setTitle("Ranking Dictado Clase");
		setBounds(100, 100, 610, 411);
		getContentPane().setLayout(null);
		
		JLabel lblRankingDictadoClase = new JLabel("Ranking dictado clase");
		lblRankingDictadoClase.setBounds(210, 33, 164, 15);
		getContentPane().add(lblRankingDictadoClase);

	}
}
