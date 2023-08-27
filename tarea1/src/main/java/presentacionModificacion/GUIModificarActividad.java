package presentacionModificacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIModificarActividad extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModificarActividad frame = new GUIModificarActividad();
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
	public GUIModificarActividad() {
		setBounds(100, 100, 450, 300);

	}

}
