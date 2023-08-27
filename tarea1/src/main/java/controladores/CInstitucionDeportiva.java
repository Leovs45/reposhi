package controladores;

import java.util.ArrayList;
import java.util.List;

import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;

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
		InstitucionDeportiva institucion = new InstitucionDeportiva(nombre, descripcion, url);
		instituciones.add(institucion);
		System.out.println("OK  -  La institucion fue creada correctamente");
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
	
	public List<InstitucionDeportiva> getListaInstituciones(){
		
		return instituciones;
	} 
	
}
