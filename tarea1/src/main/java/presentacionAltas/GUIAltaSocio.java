package presentacionAltas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIAltaSocio extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaSocio frame = new GUIAltaSocio();
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
	public GUIAltaSocio() {
		setBounds(100, 100, 450, 300);

	}

}
