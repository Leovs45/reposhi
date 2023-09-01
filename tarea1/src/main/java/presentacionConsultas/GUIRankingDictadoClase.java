package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IClase;
import interfaces.IInstitucionDeportiva;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUIRankingDictadoClase extends JInternalFrame {
	private JTable tablaRankingClaseDictado;


	public GUIRankingDictadoClase(IClase iClase) {
		
		setClosable(true);
		setTitle("Ranking Dictado Clase");
		setBounds(100, 100, 608, 500);
		getContentPane().setLayout(null);
		
		JButton btnCargarRanking = new JButton("Cargar Ranking");
		btnCargarRanking.setBounds(108, 431, 164, 25);
		getContentPane().add(btnCargarRanking);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(323, 431, 164, 25);
		getContentPane().add(btnCancelar);
		
		tablaRankingClaseDictado = new JTable();
		
		DefaultTableModel tableModel = (DefaultTableModel) tablaRankingClaseDictado.getModel();
        tableModel.addColumn("Nombre de Clase");
        tableModel.addColumn("Fecha de la clase");
        tableModel.addColumn("URL de Clase");
        JScrollPane scrollPane = new JScrollPane(tablaRankingClaseDictado);
        scrollPane.setBounds(23, 270, 550, 150);
        
        getContentPane().add(scrollPane);
		
		JLabel lblRankingDictadoClase = new JLabel("Ranking dictado clase");
		lblRankingDictadoClase.setBounds(185, 33, 164, 15);
		getContentPane().add(lblRankingDictadoClase);

	}
}
