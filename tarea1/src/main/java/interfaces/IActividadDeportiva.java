package interfaces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtActividad;
import datatypes.DtClase;
import excepciones.ExisteActividadDepException;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;


public interface IActividadDeportiva {
	public List<ActividadDeportiva> actividades = new ArrayList<>();
	
	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta) throws ExisteActividadDepException;
	public ActividadDeportiva buscarActividadDeportiva(String nombreActividad);
	public List<ActividadDeportiva> consultaActividadDeportiva(String institucion);
	public ActividadDeportiva buscarActividad(String nombreActividad);
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion);
	public void modificarDuracion(String nombreActividad, int nuevaDuracion);
	public void modificarCosto(String nombreActividad, double nuevoCosto);
	public List<DtActividad> getRankingActividades();
	public List<DtActividad> getActividades();
	public boolean existeClaseEnActividad(String nombreActividad, String nombreClase);
	public List<DtClase> getarrDtClase(String nombreActividad) ;
	public boolean existeActividad(String nombreActividad);
	public DtActividad getDtActividad(String nombreActividad);

}
