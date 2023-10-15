package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
import logica.Profesor;
import persistencia.Conexion;
import datatypes.DtActividad;
import datatypes.DtClase;
import datatypes.DtInstitucion;
import excepciones.InstitucionRepetidaException;

public  class CInstitucionDeportiva implements IInstitucionDeportiva {
	Conexion conexion = Conexion.getInstancia();
	EntityManager em = conexion.getEntityManager();	
	private static CInstitucionDeportiva instancia = null;
	
	public static CInstitucionDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CInstitucionDeportiva();
		return instancia;
	}

	@Override
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url) throws InstitucionRepetidaException {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombre);
		if(institucion != null)
			throw new InstitucionRepetidaException("La institucion ya existe");
		else {
			institucion = new InstitucionDeportiva(nombre, descripcion, url);
			em.getTransaction().begin();
			em.persist(institucion);
			em.getTransaction().commit();
		}
	}
	
	@Override
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva institucion = em.find(InstitucionDeportiva.class, nombre);
		return institucion;
	}
	
	public void agregarActividadDeportivaInstitucion(InstitucionDeportiva unaInstitucion, ActividadDeportiva unaActividad){
		
		unaInstitucion.setAgregarActividad(unaActividad);
		
	}
	

	public ActividadDeportiva buscarActividadDeportiva(String nombreInstitucion, String nombreActividad){
		InstitucionDeportiva institucion = em.find(InstitucionDeportiva.class, nombreInstitucion);
		
		ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);

		return actividad;
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion) {
		InstitucionDeportiva institucion = em.find(InstitucionDeportiva.class, nombreInstitucion);
		institucion.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarUrl(String nombreInstitucion, String nuevoUrl) {
		InstitucionDeportiva institucion = em.find(InstitucionDeportiva.class, nombreInstitucion);
		institucion.setUrl(nuevoUrl);
	}
	
	public List<String> getListaNombreInstituciones() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		List<String> instituciones = new ArrayList<>();
		String consultaInstituciones = "SELECT i FROM InstitucionDeportiva i";
		TypedQuery<InstitucionDeportiva> queryInstitucion = em.createQuery(consultaInstituciones, InstitucionDeportiva.class);
		List <InstitucionDeportiva> institucion = queryInstitucion.getResultList();
		for(InstitucionDeportiva i: institucion) {
			instituciones.add(i.getNombre());
		}
		return instituciones;
	}
	
	public boolean existeInstitucion(String nombre) {
		String consultaInstituciones = "SELECT i FROM InstitucionDeportiva i";
		TypedQuery<InstitucionDeportiva> queryInstitucion = em.createQuery(consultaInstituciones, InstitucionDeportiva.class);
		List <InstitucionDeportiva> instituciones = queryInstitucion.getResultList();
		boolean existe = false;
		for(InstitucionDeportiva i: instituciones) {
			if (nombre.equals(i.getNombre()))
				existe=true;
		}

		return existe;
	}
	public boolean existeActividadEnUnaInstitucion(String nombreInstitucion, String nombreActividad) {
		boolean existe = false;
		ActividadDeportiva act= buscarActividadDeportiva(nombreInstitucion, nombreActividad);
		if(act != null)
			existe = true;

		return existe;
	}
	
	@Override
	public DtActividad obtenerActividadDeUnaInstitucion(String nombreInstitucion, String nombreActividad) {
		InstitucionDeportiva ins = buscarInstitucionDeportiva(nombreInstitucion);
		ActividadDeportiva act = ins.buscarActividadDeportiva(nombreActividad);
		DtActividad dtAct = new	DtActividad(ins, act.getNombre(), act.getDescripcion(), act.getDuracionMinutos(), act.getCosto(), act.getFechaRegistro(), act.getArrayClase());
		return dtAct;
	}
	
	@Override
	public List<String> obtenerActividadesDeUnaInstitucion(String nombreInstitucion){
		List<String> asd = new ArrayList<>();
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		List<ActividadDeportiva> actividades = institucion.getArrayActividadDeportiva();
		for(ActividadDeportiva act: actividades)
			asd.add(act.getNombre());
		return asd;
	}
	
	@Override
	public List<DtInstitucion> getInstituciones() {
		List<DtInstitucion> dtInstituciones = new ArrayList<>();
		String consultaInstituciones = "SELECT i FROM InstitucionDeportiva i";
		TypedQuery<InstitucionDeportiva> queryInstitucion = em.createQuery(consultaInstituciones, InstitucionDeportiva.class);
		List <InstitucionDeportiva> instituciones = queryInstitucion.getResultList();
		
		for(InstitucionDeportiva inst: instituciones) {
			dtInstituciones.add(inst.getDtInstitucion());
		}
		
		return dtInstituciones;
	}
	
	@Override
	public boolean existeActividadEnInstitucion(String nombreInstitucion, String nombreActividad) {
		ActividadDeportiva actividad = buscarActividadDeportiva(nombreInstitucion, nombreActividad);
		
		if(actividad == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public List<String> obtenerClasesDeActividad(String nombreInstitucion, String nombreActividad) {
		List<String> nombresClases = new ArrayList<>();
		ActividadDeportiva actividad = buscarActividadDeportiva(nombreInstitucion, nombreActividad);
		return actividad.obtenerListaClases();
	}
	
	@Override
	public boolean existeClaseDeActividad(String nombreInstitucion, String nombreActividad, String nombreClase) {
		ActividadDeportiva actividad = buscarActividadDeportiva(nombreInstitucion, nombreActividad);
		return actividad.existeClase(nombreClase);
		
	}
	
	@Override 
	public DtClase obtenerDtClase(String nombreInstitucion, String nombreActividad, String nombreClase) {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);
		return actividad.obtenerDtClase(nombreClase);
	}
	
	@Override
	public DtInstitucion getDtInstitucion(String nombreInstitucion) {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		if(institucion!= null)
			return institucion.getDtInstitucion();
		else
			return null;
	}
	
}
