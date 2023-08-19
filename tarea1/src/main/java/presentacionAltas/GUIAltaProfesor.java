package presentacionAltas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIAltaProfesor extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaProfesor frame = new GUIAltaProfesor();
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
	public GUIAltaProfesor() {
		setBounds(100, 100, 450, 300);

	}

}
