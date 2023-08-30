package interfaces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtClase;
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
	public List<ActividadDeportiva> getActividades();
	public ActividadDeportiva buscarActividadDeportiva(String nombreActividad);
	public boolean existeClaseEnActividad(String nombreActividad, String nombreClase);
	public List<ActividadDeportiva> consultaActividadDeportiva(String institucion);
	public List<DtClase> getarrDtClase(String nombreActividad) ;

}
