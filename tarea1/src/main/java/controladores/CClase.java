package controladores;

import java.util.Date;

import interfaces.IClase;

public class CClase implements IClase {
	
	private static CClase instancia = null;
	
	public static CClase getInstancia() {
		if (instancia == null)
			instancia = new CClase();
		return instancia;
	}

	@Override
	public void altaDictadoClase(String institucion, String nombreClase, Date fecha, String horaInicio,
			String nombreProfesor, String url, Date fechaAlta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void consultarDictadoClase(String institucion, String clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rankingDictadoClase() {
		// TODO Auto-generated method stub
		
	}

}
