package interfaces;

import java.util.Date;
import java.util.List;
import logica.Clase;
import datatypes.DtActividad;

public interface IClase {
	public void altaDictadoClase(String nombreClase, DtActividad actividadDeportiva, Date fechaClase, String nombreProfesor,
			String horaInicio, String urlClase, Date fechaRegistro);
	public Clase buscarClase(String abuscar);
	public List<Clase> getRankingClases();
}
