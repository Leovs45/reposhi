package controladores;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

public class CClase implements IClase {
	Conexion conexion = Conexion.getInstancia();
	EntityManager em = conexion.getEntityManager();
	
	private static CClase instancia = null;
	
	public static CClase getInstancia() {
		if (instancia == null)
			instancia = new CClase();
		return instancia;
	}

	

	@Override
	public Clase buscarClase(String abuscar) {
		Clase clas = em.find(Clase.class, abuscar);
		return clas;
	}	
	@Override
	public void altaDictadoClase(String nombreClase, DtActividad actividadDeportiva, Date fechaClase, String nombreProfesor,
			String horaInicio, String urlClase, Date fechaRegistro) throws ClaseRepetidaException {
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();

		Usuario usuario = iUsuario.buscarUsuario(nombreProfesor);
		Profesor profesor = (Profesor) usuario;
		ActividadDeportiva act = iActividad.buscarActividadDeportiva(actividadDeportiva.getNombre());

		Clase clase = buscarClase(nombreClase);
		if(clase != null) {
			throw new ClaseRepetidaException("Ya existe una clase con ese nombre");
		}else {
			clase = new Clase(nombreClase, act, fechaClase, profesor, horaInicio, urlClase, fechaRegistro);
			profesor.agregarClase(clase);
			act.agregarClase(clase);
			em.getTransaction().begin();
			em.persist(clase);
			em.getTransaction().commit();
		}
	}
	
	@Override
	public List<DtClase> getRankingClases() {
	    int i, j;
	    boolean swapped;
	    Clase temp;
	    String consultaClases = "SELECT c FROM Clase c";
		TypedQuery<Clase> queryClase = em.createQuery(consultaClases, Clase.class);
	    List<Clase> clasesOrdenadas = new ArrayList<>(queryClase.getResultList());
		

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
	
}
