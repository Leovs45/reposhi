package controladores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtActividad;
import datatypes.DtClase;
import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import persistencia.Conexion;


public class CActividadDeportiva implements IActividadDeportiva {
	
	public List<ActividadDeportiva> actividades = new ArrayList<>();

	private static CActividadDeportiva instancia = null;
	
	public static CActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CActividadDeportiva();
		return instancia;
	}
	
	@Override
	public void altaActividadDeportiva(InstitucionDeportiva institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta) {
		ActividadDeportiva actividad = new ActividadDeportiva(institucion, nombreActividad, descripcion, duracionMinutos, costo, fechaAlta);
		institucion.agregarActividadDeportiva(actividad);
		//=====================================================================			
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(institucion);
		em.getTransaction().commit();
//=====================================================================
		
	}

	@Override
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
	
	@Override
	public ActividadDeportiva buscarActividad(String nombreActividad) {
		for(ActividadDeportiva act: actividades) {
			if(nombreActividad.equals(act.getNombre())) {
				return act;
			}
		}
		return null;
	}

	
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion) {
		ActividadDeportiva actividad = buscarActividadDeportiva(nombreActividad);
		actividad.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarDuracion(String nombreActividad, int nuevaDuracion) {
		ActividadDeportiva actividad = buscarActividadDeportiva(nombreActividad);
		actividad.setDuracionMinutos(nuevaDuracion);
	}

	@Override
	public void modificarCosto(String nombreActividad, double nuevoCosto) {
		ActividadDeportiva actividad = buscarActividadDeportiva(nombreActividad);
		actividad.setCosto(nuevoCosto);
	}
	
	@Override
	public void agregarActividad(ActividadDeportiva actividad) {
		actividades.add(actividad);
	}
	
	/*
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
	
	/*
	
	
	/*
	@Override
	public List<DtActividad> getRankingActividades() {
	    int i, j;
	    boolean swapped;
	    DtActividad temp;
	    List<DtActividad> actividadesOrdenadas = actividades.stream()
	                                    .map(a -> new DtActividad(a.getNombre(), a.getCosto(),a.getDescripcion()))
	                                    .collect(Collectors.toList());

	    for (i = 0; i < actividadesOrdenadas.size() - 1; i++) {
	        swapped = false;
	        for (j = 0; j < actividadesOrdenadas.size() - 1 - i; j++) {
	            if (actividadesOrdenadas.get(j).getCantidadDeClases() < actividadesOrdenadas.get(j + 1).getCantidadDeClases()) {
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
	*/
	
	@Override
	public List<DtActividad> getRankingActividades() {
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

	    List<DtActividad> rankingDtActividades = new ArrayList<>();
	    for (ActividadDeportiva actividad : actividadesOrdenadas) {
	        List<Clase> claseActividad = actividad.getArrayClase();
	        DtActividad dt = new DtActividad(claseActividad,actividad.getNombre(),actividad.getCosto(),actividad.getDescripcion());
	        rankingDtActividades.add(dt);
	    }

	    return rankingDtActividades;
	}

	
	
	
	@Override
	public List<DtActividad> getActividades() {
		List<DtActividad> dtActividades = new ArrayList<>();
		
		for(ActividadDeportiva act: actividades) {
			dtActividades.add(act.getDtActividad());
		}
		
		return dtActividades;
		
	}

	@Override
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

	@Override
	public List<DtClase> getarrDtClase(String nombreActividad) {
		List<DtClase> asd = new ArrayList<>();
		ActividadDeportiva a = buscarActividadDeportiva(nombreActividad);
		asd = a.getDtArrayClase();
		return asd;
	}
	
	@Override
	public boolean existeActividad(String nombreActividad) {
		for(ActividadDeportiva act: actividades) {
			if(nombreActividad.equals(act.getNombre())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public DtActividad getDtActividad(String nombreActividad) {
		ActividadDeportiva actividad = buscarActividad(nombreActividad);
		
		return actividad.getDtActividad();
	}
}
