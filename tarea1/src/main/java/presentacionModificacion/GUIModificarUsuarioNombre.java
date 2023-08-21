package presentacionModificacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class GUIModificarUsuarioNombre extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModificarUsuarioNombre frame = new GUIModificarUsuarioNombre();
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
	public GUIModificarUsuarioNombre() {
		setBounds(100, 100, 450, 300);

	}

}
