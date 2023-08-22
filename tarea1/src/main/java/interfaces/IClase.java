package interfaces;

import java.util.Date;

import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.Profesor;

public interface IClase {
	public void altaDictadoClase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, Profesor profesor,
			String horaInicio, String urlClase, Date fechaRegistro);
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname);
	//public void altaDictadoClase(String institucion, String nombreClase, Date fecha, Date horaInicio,String nombreProfesor, String url, Date fechaAlta);
	
	// Opcionales
	public void consultarDictadoClase(String institucion, String clase);
	public void rankingDictadoClase();
}
