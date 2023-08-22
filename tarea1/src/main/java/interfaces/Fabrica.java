package interfaces;
import controladores.*;

import controladores.*;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica() {};
	
	public static Fabrica getInstancia() {
		if(instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IUsuario getIUsuario() {
		return CUsuario.getInstancia();
	}
	
	public IInstitucionDeportiva getIInstitucionDeportiva() {
		return CInstitucionDeportiva.getInstancia();
	}
	
	public IActividadDeportiva getIActividadDeportiva() {
		return CActividadDeportiva.getInstancia();
	}
	
	public IClase getIClase() {
		return CClase.getInstancia();
	}
	
	public IActividadDeportiva getIActividadDeportiva() {
		return CActividadDeportiva.getInstancia();
	}
	
	public IInstitucionDeportiva getIInstitucionDeportiva() {
		return CInstitucionDeportiva.getInstancia();
	}
}
	
