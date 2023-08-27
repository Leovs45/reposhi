package logica;

import java.util.ArrayList;
import java.util.List;

public class InstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	private List<Profesor> profesores = new ArrayList<>();
	private List<ActividadDeportiva> actividades = new ArrayList<>();
	
	//Constructor
	public InstitucionDeportiva (String nombre, String descripcion, String url)
	{
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	//Getters & Setters
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

	public List<Profesor> getArrayProfesor() {
		return profesores;
	}

	public void setArrayProfesor(ArrayList<Profesor> arrayProfesor) {
		this.profesores = arrayProfesor;
	}

	public List<ActividadDeportiva> getArrayActividadDeportiva() {
		return actividades;
	}

	public void setArrayActividadDeportiva(ArrayList<ActividadDeportiva> arrayActividadDeportiva) {
		this.actividades = arrayActividadDeportiva;
	}

	public void setAgregarActividad(ActividadDeportiva ad) {
		this.actividades.add(ad);
		
	}
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
	
	public void agregarActividadDeportiva(ActividadDeportiva actividad) {
		actividades.add(actividad);
	}
}
