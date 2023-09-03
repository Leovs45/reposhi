package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datatypes.DtClase;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class GUIRankingDictadoClase extends JInternalFrame {
	private JTable tablaRankingClaseDictado;


	public GUIRankingDictadoClase(IClase iClase) {
		
		setClosable(true);
		setTitle("Ranking Dictado Clase");
		setBounds(100, 100, 610, 411);
		getContentPane().setLayout(null);
		
		tablaRankingClaseDictado = new JTable();
		
		DefaultTableModel tableModel = (DefaultTableModel) tablaRankingClaseDictado.getModel();
		tableModel.addColumn("Cantidad");
        tableModel.addColumn("Nombre de Clase");
        tableModel.addColumn("Fecha de la clase");
        tableModel.addColumn("URL de Clase");
        JScrollPane scrollPane = new JScrollPane(tablaRankingClaseDictado);
        scrollPane.setBounds(23, 83, 550, 202);
        
        getContentPane().add(scrollPane);
		
		JLabel lblRankingDictadoClase = new JLabel("Ranking dictado clase");
		lblRankingDictadoClase.setBounds(210, 33, 164, 15);
		getContentPane().add(lblRankingDictadoClase);
		
		JButton btnCargarRanking = new JButton("Cargar Ranking");
		btnCargarRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<DtClase> claseOrdenadas = iClase.getRankingClases();
				
				if (claseOrdenadas.isEmpty()) {
							
					JOptionPane.showMessageDialog(null, "Error: No hay clases para mostrar en el ranking.", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{	
	             	 tableModel.setRowCount(0); // Limpiar las filas existentes	
	             	   for (DtClase cl : claseOrdenadas) {
	             		   tableModel.addRow(new Object[]{cl.getCantidadClases() ,cl.getNombre(), cl.getFechaClase(), cl.getUrl()});
				            
	             	   	}
					}	
				
			}
		});
		btnCargarRanking.setBounds(124, 325, 164, 25);
		getContentPane().add(btnCargarRanking);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0); // Limpiar las filas existentes
				dispose();
			}
		});
		btnCancelar.setBounds(330, 325, 164, 25);
		getContentPane().add(btnCancelar);

	}
}
