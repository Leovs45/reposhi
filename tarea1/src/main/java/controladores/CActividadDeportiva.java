package controladores;
import java.util.Date;
import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;


public class CActividadDeportiva implements IActividadDeportiva {

	private static CActividadDeportiva instancia = null;
	
	public static CActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CActividadDeportiva();
		return instancia;
	}

	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta) {
		ActividadDeportiva actividad = new ActividadDeportiva(institucion, nombreActividad, descripcion, duracionMinutos, costo, fechaAlta);
		institucion.agregarActividadDeportiva(actividad);
		System.out.println("OK  -  La institucion fue creada correctamente");
	}
	
	@Override
	public void consultaActividadDeportiva(String institucion) {
		// TODO Auto-generated method stub
		
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarDescripcion(ActividadDeportiva actividad, String nuevaDescripcion) {
		actividad.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarDuracion(ActividadDeportiva actividad, int nuevaDuracion) {
		actividad.setDuracionMinutos(nuevaDuracion);
	}

	@Override
	public void modificarCosto(ActividadDeportiva actividad, double nuevoCosto) {
		actividad.setCosto(nuevoCosto);
	}

	@Override
	public void rankingActividades() {
		// TODO Auto-generated method stub
		
	}

}
