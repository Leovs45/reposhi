package interfaces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtActividad;
import datatypes.DtClase;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
import excepciones.ExisteActividadDepException;


public interface IActividadDeportiva {
	public List<ActividadDeportiva> actividades = new ArrayList<>();
	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta) throws ExisteActividadDepException;
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion);
	public void modificarDuracion(String nombreActividad, int nuevaDuracion);
	public void modificarCosto(String nombreActividad, double nuevoCosto);
	public List<DtActividad> getRankingActividades();
	public void agregarActividad(ActividadDeportiva actividad);
	public List<DtActividad> getActividades();
	public ActividadDeportiva buscarActividadDeportiva(String nombreActividad);
	public boolean existeClaseEnActividad(String nombreActividad, String nombreClase);
	public List<ActividadDeportiva> consultaActividadDeportiva(String institucion);
	public List<DtClase> getarrDtClase(String nombreActividad) ;
	public boolean existeActividad(String nombreActividad);
	public ActividadDeportiva buscarActividad(String nombreActividad);
	public DtActividad getDtActividad(String nombreActividad);

}
