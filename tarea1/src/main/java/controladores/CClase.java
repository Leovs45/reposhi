package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import interfaces.IClase;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Profesor;

public class CClase implements IClase {
	
	private static CClase instancia = null;
	
	public static CClase getInstancia() {
		if (instancia == null)
			instancia = new CClase();
		return instancia;
	}

	@Override
	public void altaDictadoClase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, Profesor profesor,
			String horaInicio, String urlClase, Date fechaRegistro) {
		Clase clase = new Clase(nombreClase, actividadDeportiva, fechaClase, profesor, horaInicio, urlClase, fechaRegistro);
		profesor.agregarClase(clase);
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
