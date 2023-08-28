package interfaces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;


public interface IActividadDeportiva {
	public List<ActividadDeportiva> actividades = new ArrayList<>();
	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta);
	
	//Opcionales
	public void modificarDescripcion(ActividadDeportiva actividad, String nuevaDescripcion);
	public void modificarDuracion(ActividadDeportiva actividad, int nuevaDuracion);
	public void modificarCosto(ActividadDeportiva actividad, double nuevoCosto);
	public List<ActividadDeportiva> getRankingActividades();
	public void agregarActividad(ActividadDeportiva actividad);
	List<ActividadDeportiva> getActividades();
	ActividadDeportiva buscarActividadDeportiva(String nombreActividad);

	List<ActividadDeportiva> consultaActividadDeportiva(String institucion);
}
