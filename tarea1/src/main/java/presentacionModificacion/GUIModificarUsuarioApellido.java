package presentacionModificacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIModificarUsuarioApellido extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModificarUsuarioApellido frame = new GUIModificarUsuarioApellido();
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
	public GUIModificarUsuarioApellido() {
		setBounds(100, 100, 450, 300);

	}

}
