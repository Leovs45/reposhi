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
import logica.Registro;
import logica.Usuario;
import persistencia.Conexion;
import datatypes.DtActividad;
import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.UsuarioNoEsProfesorException;

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
			String horaInicio, String urlClase, Date fechaRegistro) throws ClaseRepetidaException, UsuarioNoEsProfesorException {
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		
		
		ActividadDeportiva act = iActividad.buscarActividadDeportiva(actividadDeportiva.getNombre());
		Clase claseExistente = act.buscarClase(nombreClase);
		
		if(claseExistente != null) {
			throw new ClaseRepetidaException("Ya existe una clase con el  nombre " + nombreClase);
		}

		Usuario usuario = iUsuario.buscarUsuario(nombreProfesor);
		
		if(usuario instanceof Profesor) {
			Profesor profesor = (Profesor) usuario;
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

		} else {
			throw new UsuarioNoEsProfesorException("El usuario " + usuario.getNickname() + " no es un Profesor");
		}
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
	
	/*
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
	}*/
	
	
	@Override
	public List<DtClase> getRankingClases() {
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

	    List<DtClase> rankingDtClases = new ArrayList<>();
	    for (Clase clase : clasesOrdenadas) {
	        List<Registro> claseRegistro = clase.getArrayRegistro();
	        DtClase dt = new DtClase(claseRegistro,clase.getNombreClase(),clase.getFechaClase(),clase.getUrlClase());
	        rankingDtClases.add(dt);
	    }

	    return rankingDtClases;
	}

	@Override
	public void rankingDictadoClase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarClase(Clase clase) {
		// TODO Auto-generated method stub
		
	}

	
}
