package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIConsultaInstitucion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultaInstitucion frame = new GUIConsultaInstitucion();
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
	public GUIConsultaInstitucion() {
		setBounds(100, 100, 450, 300);

	}

}
