package interfaces;

import java.util.Date;

public interface IClase {
	public void altaDictadoClase(String institucion, String nombreClase, Date fecha, String horaInicio, String nombreProfesor, String url, Date fechaAlta);
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname);

	// Opcionales
	public void consultarDictadoClase(String institucion, String clase);
	public void rankingDictadoClase();
}
