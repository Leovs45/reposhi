package logica;

import java.util.ArrayList;

public class InstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	ArrayList<Profesor> arrayProfesor;
	ArrayList<ActividadDeportiva> arrayActividadDeportiva;
	
	public InstitucionDeportiva (String nombre, String descripcion, String url, ArrayList<Profesor> arrayProfesor, ArrayList<ActividadDeportiva> arrayActividadDeportiva)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.arrayProfesor = arrayProfesor;
		this.arrayActividadDeportiva = arrayActividadDeportiva;
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

	public ArrayList<Profesor> getArrayProfesor() {
		return arrayProfesor;
	}

	public void setArrayProfesor(ArrayList<Profesor> arrayProfesor) {
		this.arrayProfesor = arrayProfesor;
	}

	public ArrayList<ActividadDeportiva> getArrayActividadDeportiva() {
		return arrayActividadDeportiva;
	}

	public void setArrayActividadDeportiva(ArrayList<ActividadDeportiva> arrayActividadDeportiva) {
		this.arrayActividadDeportiva = arrayActividadDeportiva;
	}
	
}