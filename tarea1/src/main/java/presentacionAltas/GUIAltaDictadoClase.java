package presentacionAltas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIAltaDictadoClase extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaDictadoClase frame = new GUIAltaDictadoClase();
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
	public GUIAltaDictadoClase() {
		setBounds(100, 100, 450, 300);

	}

}
