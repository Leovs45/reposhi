package interfaces;

import java.util.Date;
import java.util.List;

import logica.Clase;
import datatypes.DtActividad;
import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.UsuarioNoEsProfesorException;

public interface IClase {
	public void altaDictadoClase(String nombreClase, DtActividad actividadDeportiva, Date fechaClase, String nombreProfesor,
			String horaInicio, String urlClase, Date fechaRegistro) throws ClaseRepetidaException, UsuarioNoEsProfesorException;
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname);
	public void rankingDictadoClase();
	public List<DtClase> getRankingClases();
	public void consultarDictadoClase(Clase clase);
	public void agregarClase(Clase clase);
	//public List<Clase> getRankingClases();
}
