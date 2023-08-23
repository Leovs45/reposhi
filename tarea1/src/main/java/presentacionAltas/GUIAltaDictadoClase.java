package presentacionAltas;

import javax.swing.JInternalFrame;

import interfaces.IClase;

public class GUIAltaDictadoClase extends JInternalFrame {


	/* Create the frame. */
	public GUIAltaDictadoClase(IClase iClase) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
