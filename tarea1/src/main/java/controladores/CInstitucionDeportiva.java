package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
import datatypes.DtActividad;

public  class CInstitucionDeportiva implements IInstitucionDeportiva {
	
	private List<InstitucionDeportiva> instituciones = new ArrayList<>();
	
	private static CInstitucionDeportiva instancia = null;
	
	public static CInstitucionDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CInstitucionDeportiva();
		return instancia;
	}

	@Override
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url) {
		if(buscarInstitucionDeportiva(nombre) == null) {
			InstitucionDeportiva institucion = new InstitucionDeportiva(nombre, descripcion, url);
			instituciones.add(institucion);
			System.out.println("OK  -  La institucion fue creada correctamente");
		}
		else
			System.out.println("Institucion ya existente");
	}
	
	// Recibe un string y devuelve una institución deportiva con ese nombre
	// Si no existe una institución deportiva con ese nombre devuelve null
	@Override
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva institucion = null;
		if (instituciones.size() == 0) {
			return institucion;
		} else {
			for(InstitucionDeportiva i: instituciones) {
				if (i.getNombre().equals(nombre)) {
					institucion = i;
				}
			}
		}
		return institucion;
	}
	
	public void agregarActividadDeportivaInstitucion(InstitucionDeportiva unaInstitucion, ActividadDeportiva unaActividad){
		
		unaInstitucion.setAgregarActividad(unaActividad);
		
	}
	

	public ActividadDeportiva buscarActividadDeportiva(String nombreInstitucion, String nombreActividad){
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		
		ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);

		return actividad;
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion) {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		institucion.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarUrl(String nombreInstitucion, String nuevoUrl) {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		institucion.setUrl(nuevoUrl);
	}
	
	@Override
	public void listarInstituciones() {
		if(instituciones.size() == 0) {
			System.out.println("  ERROR - No existe ninguna institucion deportiva creada");
		} else {
			for (InstitucionDeportiva i: instituciones) {
				System.out.println(i.getNombre() + " " + i.getDescripcion() + " " + i.getUrl());
			}
		}
	}
	
	public List<String> getListaNombreInstituciones() {
		List<String> institucion = new ArrayList<>();
		for(InstitucionDeportiva ins : instituciones) {
			institucion.add(ins.getNombre());
		}
		return institucion;
	}
	
	public boolean existeInstitucion(String nombre) {
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
	
	public List<InstitucionDeportiva> getListaInstituciones(){
		
		return instituciones;
	}
	@Override
	public DtActividad obtenerActividadDeUnaInstitucion(String nombreInstitucion, String nombreActividad) {
		ActividadDeportiva act;
		InstitucionDeportiva ins = buscarInstitucionDeportiva(nombreInstitucion);
		act = ins.buscarActividadDeportiva(nombreActividad);
		DtActividad dtAct = new	DtActividad(ins.getNombre(), act.getNombre(), act.getDescripcion() , act.getDuracionMinutos(), act.getCosto(), act.getFechaRegistro());
		return dtAct;
	}
	

	public List<String> obtenerActividadesDeUnaInstitucion(String nombre){
		List<String> asd = new ArrayList<>();
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombre);
		List<ActividadDeportiva> actividades = institucion.getArrayActividadDeportiva();
		for(ActividadDeportiva act: actividades)
			asd.add(act.getNombre());
		return asd;
	}
	public List<InstitucionDeportiva> getInstituciones() {
		return instituciones;
	}
	
	
	
}
