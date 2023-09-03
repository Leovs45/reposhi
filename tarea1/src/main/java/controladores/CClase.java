package controladores;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.Fabrica;
import interfaces.IClase;
import interfaces.IUsuario;
import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.Profesor;
import logica.Usuario;
import persistencia.Conexion;
import datatypes.DtActividad;

public class CClase implements IClase {
	
	private List<Clase> clases = new ArrayList<>();
	
	private static CClase instancia = null;
	
	public static CClase getInstancia() {
		if (instancia == null)
			instancia = new CClase();
		return instancia;
	}

	@Override
	public void altaDictadoClase(String nombreClase, DtActividad actividadDeportiva, Date fechaClase, String nombreProfesor,
			String horaInicio, String urlClase, Date fechaRegistro) {
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();

		Usuario usuario = iUsuario.buscarUsuario(nombreProfesor);
		Profesor profesor = (Profesor) usuario;
		ActividadDeportiva act = iActividad.buscarActividadDeportiva(actividadDeportiva.getNombre());

		Clase clase = new Clase(nombreClase, act, fechaClase, profesor, horaInicio, urlClase, fechaRegistro);
		profesor.agregarClase(clase);
		act.agregarClase(clase);
		System.out.println("OK - Clase Creada");
		//=====================================================================			
				Conexion conexion = Conexion.getInstancia();
				EntityManager em = conexion.getEntityManager();
				em.getTransaction().begin();
				em.persist(clase);
				em.getTransaction().commit();
		//=====================================================================
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
