package interfaces;

import java.util.List;

import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
import datatypes.DtActividad;
import datatypes.DtClase;
import datatypes.DtInstitucion;
import excepciones.InstitucionRepetidaException;


public interface IInstitucionDeportiva {
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url) throws InstitucionRepetidaException;
	public List<DtInstitucion> getInstituciones();
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion);
	public void modificarUrl(String nombreInstitucion, String nuevoUrl);
	public void agregarActividadDeportivaInstitucion(InstitucionDeportiva unaInstitucion, ActividadDeportiva unaActividad);
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre);
	public List<String> getListaNombreInstituciones();
	public boolean existeInstitucion(String nombre);
	public boolean existeActividadEnUnaInstitucion(String nombreInstitucion, String nombreActividad);
	public DtActividad obtenerActividadDeUnaInstitucion(String nombreInstitucion, String nombreActividad);
	public List<String> obtenerActividadesDeUnaInstitucion(String nombre);
	public ActividadDeportiva buscarActividadDeportiva(String nombreInstitucion, String nombreActividad);
	boolean existeActividadEnInstitucion(String nombreInstitucion, String nombreActividad);
	List<String> obtenerClasesDeActividad(String nombreInstitucion, String nombreActividad);
	boolean existeClaseDeActividad(String nombreInstitucion, String nombreActividad, String nombreClase);
	DtClase obtenerDtClase(String nombreInstitucion, String nombreActividad, String nombreClase);
	DtInstitucion getDtInstitucion(String nombreInstitucion);
}
