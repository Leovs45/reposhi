package controladores;

import java.util.Date;

import interfaces.Fabrica;
import interfaces.IClase;
import interfaces.IUsuario;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.Profesor;
import logica.Usuario;

public class CClase implements IClase {
	
	private static CClase instancia = null;
	
	public static CClase getInstancia() {
		if (instancia == null)
			instancia = new CClase();
		return instancia;
	}

	@Override
	public void altaDictadoClase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, String nombreProfesor,
			String horaInicio, String urlClase, Date fechaRegistro) {
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();

		Usuario usuario = iUsuario.buscarUsuario(nombreProfesor);
		Profesor profesor = (Profesor) usuario;

		Clase clase = new Clase(nombreClase, actividadDeportiva, fechaClase, profesor, horaInicio, urlClase, fechaRegistro);
		profesor.agregarClase(clase);
		actividadDeportiva.agregarClase(clase);
		System.out.println("OK - Clase Creada");
	}

	@Override
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname) {
		// TODO Auto-generated method stub
		
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void consultarDictadoClase(String institucion, String clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rankingDictadoClase() {
		// TODO Auto-generated method stub
		
	}
	
}
