package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIConsultaUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultaUsuario frame = new GUIConsultaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIConsultaUsuario() {
		setBounds(100, 100, 450, 300);

	}

}
