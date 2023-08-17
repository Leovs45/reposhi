package controladores;

import java.util.ArrayList;
import java.util.List;

import interfaces.IInstitucionDeportiva;
import logica.InstitucionDeportiva;

public class CInstitucionDeportiva implements IInstitucionDeportiva {
	
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
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUrl(String nombreInstitucion, String nuevoUrl) {
		// TODO Auto-generated method stub
		
	}

}
