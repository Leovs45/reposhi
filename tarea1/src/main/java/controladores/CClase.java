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
	
	private List<Clase> clases = new ArrayList<>();
	
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
		clases.add(clase);
		System.out.println("OK - Clase Creada");
	}

	@Override
	public void registroClase(String institucion, String actividadDeportiva, String clase, String nickname) {
		// TODO Auto-generated method stub
		
	}
	
	public Clase buscarClase(String nombre) {
		Clase clase = null;
		if (clases.size() == 0) {
			return clase;
		} else {
			for(Clase c: clases) {
				if (c.getNombreClase().equals(nombre)) {
					clase = c;
				}
			}
		}

		return clase;
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
