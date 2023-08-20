package interfaces;
import controladores.*;

import controladores.CUsuario;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica() {};
	
	public static Fabrica getInstancia() {
		if(instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IUsuario getIUsuario() {
		return new CUsuario();
	}
	
	public IActividadDeportiva getIActividadDeportiva() {
		return CActividadDeportiva.getInstancia();
	}
	
	public IInstitucionDeportiva getIInstitucionDeportiva() {
		return CInstitucionDeportiva.getInstancia();
	}
}
	
