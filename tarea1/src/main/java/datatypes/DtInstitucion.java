package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Profesor;

public class DtInstitucion {
    private String nombre;
    private String descripcion;
    private String url;
    private List<Profesor> profesores = new ArrayList<>();
    private List<ActividadDeportiva> actividades = new ArrayList<>();

    public DtInstitucion(String nombre, String descripcion, String url, List<Profesor> profesores, List<ActividadDeportiva> actividades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.profesores = profesores;
        this.actividades = actividades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<DtProfesor> getProfesores() {
        List<DtProfesor> dtProfesores = new ArrayList<>();
        
        for(Profesor profesor: profesores) {
        	dtProfesores.add(profesor.getDtProfesor());
        }
        
        return dtProfesores;
    }

    public List<DtActividad> getActividades() {
    	List<DtActividad> dtActividades = new ArrayList<>();
        
        for(ActividadDeportiva actividad: actividades) {
        	dtActividades.add(actividad.getDtActividad());
        }
        
        return dtActividades;
    }
    
    public DtActividad buscarDtActividad (String nombreActividad) {
		DtActividad dtAct = null;
		if (actividades.size() == 0) {
			dtAct = null;
		} else {
			for(ActividadDeportiva a: actividades) {
				if (a.getNombre().equals(nombreActividad)) {
					dtAct = new DtActividad(a.getInstitucion(),a.getNombre(),a.getDescripcion(),a.getDuracionMinutos(),a.getCosto(),a.getFechaRegistro(),a.getArrayClase());
				}
			}
		}
		return dtAct;
	}
    
}

