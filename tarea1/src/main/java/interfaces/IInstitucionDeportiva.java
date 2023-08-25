package interfaces;

import java.util.List;

import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;

public interface IInstitucionDeportiva {
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url);
	
	public List<InstitucionDeportiva> getListaInstituciones();
	// Opcionales
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion);
	public void modificarUrl(String nombreInstitucion, String nuevoUrl);
	public void agregarActividadDeportivaInstitucion(InstitucionDeportiva unaInstitucion, ActividadDeportiva unaActividad);
	// Adicionales
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre);
	public void listarInstituciones();
}
