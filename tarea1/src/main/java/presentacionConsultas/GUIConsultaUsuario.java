package presentacionConsultas;

import java.awt.EventQueue;
import interfaces.IUsuario;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

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
		
		
		DefaultListModel<String> lista = new DefaultListModel<String>();
		JList listaDataUsers = new JList(lista);
		listaDataUsers.setBounds(55, 80, 453, 160);
		getContentPane().add(listaDataUsers);
		listaDataUsers.setEnabled(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nickname = textFieldIngreseUsr.getText();
						if(iUsuario.buscarUsuario(nickname) == null) {
					JOptionPane.showMessageDialog(null, "Error - No existe usuario: "+nickname, "Error Consulta usuario", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Se encontro a la usuario/a: "+nickname, "Consulta usuario", JOptionPane.INFORMATION_MESSAGE);
					listaDataUsers.setModel(lista);
				}
			}
		});
		btnAceptar.setBounds(139, 274, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(287, 274, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
