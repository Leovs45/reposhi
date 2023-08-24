package presentacionConsultas;

import java.awt.EventQueue;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import logica.InstitucionDeportiva;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUIConsultaActividadDeportiva extends JInternalFrame {
	/**
	 * Create the frame.
	 */
	public GUIConsultaActividadDeportiva(IActividadDeportiva iActividad) {
		//=========================================================
		Fabrica f = Fabrica.getInstancia();
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		List<InstitucionDeportiva>ins = iInstitucion.getListaInstituciones();
		
		
		setTitle("Consulta Actividad Deportiva");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox cmbInstituciones = new JComboBox();
		JComboBox cmbActivides = new JComboBox();
		cmbActivides.setEnabled(false);
		cmbInstituciones.setSelectedIndex(-1); 
		cmbActivides.setSelectedIndex(-1); 
		cmbActivides.setEnabled(false);
		cmbActivides.setBounds(186, 79, 188, 22);
		getContentPane().add(cmbActivides);

		JLabel lblInstitucionDep = new JLabel("Institucion Deportiva:");
		lblInstitucionDep.setBounds(23, 36, 134, 14);
		getContentPane().add(lblInstitucionDep);
		cmbInstituciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedItem = (String) cmbInstituciones.getSelectedItem();
				cmbActivides.setEnabled(true);
			}
		});
		 for (InstitucionDeportiva i : ins) {
			 cmbInstituciones.addItem(i.getNombre());
	       }

		cmbInstituciones.setBounds(185, 32, 189, 22);
		getContentPane().add(cmbInstituciones);
		
		JLabel lblNewLabel = new JLabel("Actividad: ");
		lblNewLabel.setBounds(23, 83, 60, 14);
		getContentPane().add(lblNewLabel);
		
		
	}
}
