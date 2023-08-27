package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IClase;
import interfaces.IUsuario;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.Profesor;
import logica.Usuario;

public class CClase implements IClase {
	
	private List<Clase> clases = new ArrayList<>();
	
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
	public void consultarDictadoClase(Clase clase) {
		System.out.println(clase.getNombreClase() + " " + clase.getActividadDeportiva().getNombre() + " " + clase.getFechaClase() + " " + clase.getHoraInicio() + " " + clase.getProfesor().getNombre() + " ");
	}

	@Override
	public void rankingDictadoClase() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void agregarClase(Clase clase) {
		clases.add(clase);
	}
	
	@Override
	public List<Clase> getRankingClases() {
	    int i, j;
	    boolean swapped;
	    Clase temp;
	    List<Clase> clasesOrdenadas = new ArrayList<>(clases);

	    for (i = 0; i < clasesOrdenadas.size() - 1; i++) {
	        swapped = false;
	        for (j = 0; j < clasesOrdenadas.size() - 1 - i; j++) {
	            if (clasesOrdenadas.get(j).getCantidadRegistros() < clasesOrdenadas.get(j + 1).getCantidadRegistros()) {
	                temp = clasesOrdenadas.get(j);
	                clasesOrdenadas.set(j, clasesOrdenadas.get(j + 1));
	                clasesOrdenadas.set(j + 1, temp);
	                swapped = true;
	            }
	        }

	        if (!swapped) {
	            break;
	        }
	    }

	    return clasesOrdenadas;
	}

	
}
