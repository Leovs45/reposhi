package interfaces;

import java.util.Date;

import logica.ActividadDeportiva;
import logica.Profesor;

public interface IClase {
	public void altaDictadoClase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, String nombreProfesor,
			String horaInicio, String urlClase, Date fechaRegistro);
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname);
	
	// Opcionales
	public void consultarDictadoClase(String institucion, String clase);
	public void rankingDictadoClase();
}
