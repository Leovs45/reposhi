package presentacionAltas;

import java.awt.EventQueue;
import interfaces.IUsuario;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class GUIAltaUsuario extends JInternalFrame {
	/**
	 * Create the frame.
	 */
	public GUIAltaUsuario(IUsuario iUsuario) {
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblEstoEsAlta = new JLabel("ESTO ES ALTA USUARIO");
		lblEstoEsAlta.setBounds(71, 64, 184, 15);
		getContentPane().add(lblEstoEsAlta);

	}
}
