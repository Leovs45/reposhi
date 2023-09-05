package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import datatypes.DtInstitucion;
import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
@Entity
@Table(name = "Institucion_Deportiva")
public class InstitucionDeportiva {
	@Id
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String url;
	@OneToMany
	private List<Profesor> profesores = new ArrayList<>();
	@OneToMany
	private List<ActividadDeportiva> actividades = new ArrayList<>();
	
		
	//Constructor
	public InstitucionDeportiva (String nombre, String descripcion, String url)
	{
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	//consturctor vacio

	public InstitucionDeportiva (){}

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

	//public List<Profesor> getArrayProfesor() {
	////	return profesores;
//	}

	public void setArrayProfesor(List<Profesor> arrayProfesor) {
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
	
	public ActividadDeportiva obtenerActividad(int opt) {
		ActividadDeportiva ad = null;
		if (actividades.size() == 0) {
			return ad;
		} else {
			if (opt > actividades.size()) {
				return ad;
			} else {
				ad = actividades.get(opt - 1);
			}
		}
		return ad;
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
		Fabrica f = Fabrica.getInstancia();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
	}
	
	public boolean existenActividades() {
		return actividades.size() > 0;
	}
	
	public DtInstitucion getDtInstitucion() {
		return new DtInstitucion(nombre, descripcion, url, profesores, actividades);
	}

}
