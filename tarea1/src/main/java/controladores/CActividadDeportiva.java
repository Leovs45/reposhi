package controladores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;


public class CActividadDeportiva implements IActividadDeportiva {
	

	private static CActividadDeportiva instancia = null;
	
	public static CActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CActividadDeportiva();
		return instancia;
	}
	
	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta) {
		ActividadDeportiva actividad = new ActividadDeportiva(institucion, nombreActividad, descripcion, duracionMinutos, costo, fechaAlta);
		institucion.agregarActividadDeportiva(actividad);
		System.out.println("OK  -  La institucion fue creada correctamente");
	}

	public ActividadDeportiva buscarActividadDeportiva(String nombre){
		ActividadDeportiva Actividad = null;
		if (Actividades.size() == 0) {
			return Actividad;
		} else {
			for(ActividadDeportiva ad: Actividades) {
				if (ad.getNombre().equals(nombre)) {
					Actividad = ad;
				}
			}
		}

		return Actividad;
	}
	@Override
	public List<ActividadDeportiva> consultaActividadDeportiva(String institucion) {
	    List<ActividadDeportiva> actividadesEncontradas = new ArrayList<>();
	    
	    for (ActividadDeportiva actividad : Actividades) {
	        if (actividad.getInstitucion().equals(institucion)) {
	            actividadesEncontradas.add(actividad);
	        }
	    }
	    
	    return actividadesEncontradas;
	}

	public Clase buscarClase(String nombre){
		
		return buscarClase(nombre);
	
	}
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarInstitucion(String nombreActividad, String nuevaInstitucion) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setInstitucion(nuevaInstitucion);
		
	}

	@Override
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarDuracion(String nombreActividad, int nuevaDuracion) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setCosto(nuevaDuracion);
	}

	@Override
	public void modificarCosto(String nombreActividad, double nuevoCosto) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setCosto(nuevoCosto);
	}

	@Override
	public void rankingActividades() {
		// TODO Auto-generated method stub
		
	}

}
