package interfaces;

import logica.InstitucionDeportiva;

public interface IInstitucionDeportiva {
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url);
	

	// Opcionales
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion);
	public void modificarUrl(String nombreInstitucion, String nuevoUrl);
	
	// Adicionales
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre);
	public void listarInstituciones();
}
