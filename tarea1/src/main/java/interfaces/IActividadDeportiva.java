package interfaces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;


public interface IActividadDeportiva {
	public List<ActividadDeportiva> Actividades = new ArrayList<>();
	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,double costo, Date fechaAlta);
	//public void consultaActividadDeportiva(String institucion);
	public List<ActividadDeportiva> consultaActividadDeportiva(String institucion);
	public ActividadDeportiva buscarActividadDeportiva(String nombre);
	public Clase buscarClase(String nombre);
	//Opcionales
	public void modificarInstitucion(String nombreActividad, String nuevaInstitucion);
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion);
	public void modificarDuracion(String nombreActividad, int nuevaDuracion);
	public void modificarCosto(String nombreActividad, double nuevoCosto);
	public void rankingActividades();
}