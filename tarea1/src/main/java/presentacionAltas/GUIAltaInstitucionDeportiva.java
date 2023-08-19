package presentacionAltas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIAltaInstitucionDeportiva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAltaInstitucionDeportiva frame = new GUIAltaInstitucionDeportiva();
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
	public GUIAltaInstitucionDeportiva() {
		setBounds(100, 100, 450, 300);

	}

}
