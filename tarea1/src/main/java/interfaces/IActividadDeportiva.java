package interfaces;

import java.util.Date;

public interface IActividadDeportiva {
	public void altaActividadDeportiva(String institucion, String nombreActividad, String descripcion, String duracion, int costo, Date fechaAlta);
	public void consultaActividadDeportiva(String institucion);
	
	//Opcionales
	public void modificarInstitucion(String nombreActividad, String nuevaInstitucion);
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion);
	public void modificarDuracion(String nombreActividad, int nuevaDuracion);
	public void modificarCosto(String nombreActividad, double nuevoCosto);
	public void rankingActividades();
}
