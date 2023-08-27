package controladores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;


public class CActividadDeportiva implements IActividadDeportiva {
	
	private List<ActividadDeportiva> clases = new ArrayList<>();

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
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarDescripcion(ActividadDeportiva actividad, String nuevaDescripcion) {
		actividad.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarDuracion(ActividadDeportiva actividad, int nuevaDuracion) {
		actividad.setDuracionMinutos(nuevaDuracion);
	}

	@Override
	public void modificarCosto(ActividadDeportiva actividad, double nuevoCosto) {
		actividad.setCosto(nuevoCosto);
	}
	
	@Override
	public void agregarActividad(ActividadDeportiva actividad) {
		actividades.add(actividad);
	}

	@Override
	public List<ActividadDeportiva> getRankingActividades() {
	    int i, j;
	    boolean swapped;
	    ActividadDeportiva temp;
	    List<ActividadDeportiva> actividadesOrdenadas = new ArrayList<>(actividades);

	    for (i = 0; i < actividadesOrdenadas.size() - 1; i++) {
	        swapped = false;
	        for (j = 0; j < actividadesOrdenadas.size() - 1 - i; j++) {
	            if (actividadesOrdenadas.get(j).getCantidadClases() < actividadesOrdenadas.get(j + 1).getCantidadClases()) {
	                temp = actividadesOrdenadas.get(j);
	                actividadesOrdenadas.set(j, actividadesOrdenadas.get(j + 1));
	                actividadesOrdenadas.set(j + 1, temp);
	                swapped = true;
	            }
	        }

	        if (!swapped) {
	            break;
	        }
	    }

	    return actividadesOrdenadas;
	}
	
	@Override
	public List<ActividadDeportiva> getActividades() {
		return actividades;
	}
	
	@Override
	public ActividadDeportiva buscarActividadDeportiva(String nombreActividad) {
		ActividadDeportiva actividad = null;
		if (actividades.size() == 0) {
			actividad = null;
		} else {
			for(ActividadDeportiva a: actividades) {
				if (a.getNombre().equals(nombreActividad)) {
					actividad = a;
				}
			}
		}
		return actividad;
	}

}
