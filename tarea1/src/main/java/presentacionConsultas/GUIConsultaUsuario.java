package presentacionConsultas;

import java.awt.EventQueue;
import interfaces.IUsuario;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIConsultaUsuario extends JInternalFrame {
	private JTextField textFieldIngreseUsr;
	/**
	 * Create the frame.
	 */
	public GUIConsultaUsuario(IUsuario iUsuario) {
		setClosable(true);
		setTitle("Consultar usuario");
		setBounds(100, 100, 559, 364);
		getContentPane().setLayout(null);
		
		textFieldIngreseUsr = new JTextField();
		textFieldIngreseUsr.setBounds(213, 36, 174, 19);
		getContentPane().add(textFieldIngreseUsr);
		textFieldIngreseUsr.setColumns(10);
		
		JLabel lblConsultarUsuario = new JLabel("Consultar usuario:");
		lblConsultarUsuario.setBounds(70, 38, 132, 15);
		getContentPane().add(lblConsultarUsuario);
		
		JList listDataUsuarios = new JList();
		listDataUsuarios.setBounds(49, 67, 418, 185);
		getContentPane().add(listDataUsuarios);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(iUsuario.existenUsuarios()) {
					JOptionPane.showMessageDialog(null, "Error - No existe usuario", "Error Consulta usuario", JOptionPane.WARNING_MESSAGE);
				}else {
					String nickname = textFieldIngreseUsr.getText();
					listDataUsuarios.add(iUsuario.consultaUsuario(nickname));
				}
			}
		});
		btnAceptar.setBounds(139, 274, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnCancelar.setBounds(287, 274, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
