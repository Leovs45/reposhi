package controladores;

import java.util.Date;

import interfaces.IActividadDeportiva;

public class CActividadDeportiva implements IActividadDeportiva {
	
	private static CActividadDeportiva instancia = null;
	
	public static CActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CActividadDeportiva();
		return instancia;
	}

	@Override
	public void altaActividadDeportiva(String institucion, String nombreActividad, String descripcion, String duracion,
			int costo, Date fechaAlta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultaActividadDeportiva(String institucion) {
		// TODO Auto-generated method stub
		
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarInstitucion(String nombreActividad, String nuevaInstitucion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDuracion(String nombreActividad, int nuevaDuracion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCosto(String nombreActividad, double nuevoCosto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rankingActividades() {
		// TODO Auto-generated method stub
		
	}

}
