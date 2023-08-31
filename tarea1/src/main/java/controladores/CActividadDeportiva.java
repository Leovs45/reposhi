package controladores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtClase;
import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
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
		System.out.println("OK  -  La actividad fue creada correctamente");
	}

	public ActividadDeportiva buscarActividadDeportiva(String nombre){
		ActividadDeportiva actividad = null;
		if (actividades.size() == 0) {
			return actividad;
		} else {
			for(ActividadDeportiva ad: actividades) {
				if (ad.getNombre().equals(nombre)) {
					actividad = ad;
				}
			}
		}
		return actividad;
	}

	@Override
	public List<ActividadDeportiva> consultaActividadDeportiva(String institucion) {
	    List<ActividadDeportiva> actividadesEncontradas = new ArrayList<>();
	    
	    for (ActividadDeportiva actividad: actividades) {
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
	public boolean existeClaseEnActividad(String nombreActividad, String nombreClase) {
		boolean existe = false;
		ActividadDeportiva act = buscarActividadDeportiva(nombreActividad);
		List<Clase>clases = act.getArrayClase();
		for(Clase c : clases) {
			if(nombreClase.equals(c.getNombreClase()))
				existe=true;
		}
		return existe;
	}
	public List<DtClase> getarrDtClase(String nombreActividad) {
		List<DtClase> asd = new ArrayList<>();
		ActividadDeportiva a = buscarActividadDeportiva(nombreActividad);
		asd = a.getDtArrayClase();
		return asd;
	}
}
