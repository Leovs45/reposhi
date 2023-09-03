package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import datatypes.DtActividad;
import datatypes.DtClase;
import interfaces.IActividadDeportiva;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;



public class GUIRankingActividadDeportiva extends JInternalFrame {
	private JTable tablaRankingActividad;

	

	public GUIRankingActividadDeportiva(IActividadDeportiva iActividad) {
		tablaRankingActividad = new JTable();
		
		DefaultTableModel tableModel = (DefaultTableModel) tablaRankingActividad.getModel();
		tableModel.addColumn("Cantidad");
		tableModel.addColumn("Nombre actividad");
        tableModel.addColumn("Costo");
        tableModel.addColumn("Descripción");
        JScrollPane scrollPane = new JScrollPane(tablaRankingActividad);
        scrollPane.setBounds(23, 108, 550, 312);
        
        getContentPane().add(scrollPane);
		
		JLabel lblRankingActividades = new JLabel("Ranking actividades");
		lblRankingActividades.setBounds(217, 32, 164, 15);
		getContentPane().add(lblRankingActividades);
		
		setClosable(true);
		setTitle("Ranking Actividades ");
		setBounds(100, 100, 610, 500);
		getContentPane().setLayout(null);
		
		JButton btnCargarRanking = new JButton("Cargar Ranking");
		btnCargarRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			List<DtActividad> actividadesOrdenadas = iActividad.getRankingActividades();
					
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
		
		btnCargarRanking.setBounds(108, 431, 164, 25);
		getContentPane().add(btnCargarRanking);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0); // Limpiar las filas existentes
				dispose();
			}
		});
		btnCancelar.setBounds(323, 431, 164, 25);
		getContentPane().add(btnCancelar);

	}

}
