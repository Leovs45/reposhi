package presentacionConsultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIConsultaActividadDeportiva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsultaActividadDeportiva frame = new GUIConsultaActividadDeportiva();
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
	public GUIConsultaActividadDeportiva() {
		setBounds(100, 100, 450, 300);

	}

}
