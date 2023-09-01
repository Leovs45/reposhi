package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Clase;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;

public class DtActividad{
    private InstitucionDeportiva institucion;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private double costo;
    private Date fechaRegistro;
    private List<Clase> clases;
    
    public DtActividad(InstitucionDeportiva institucion, String nombre, String descripcion, int duracionMinutos, double costo, Date fechaRegistro, List<Clase> clases){
    	this.institucion = institucion;
    	this.nombre = nombre;
    	this.descripcion = descripcion;
    	this.duracionMinutos = duracionMinutos;
    	this.costo = costo;
    	this.fechaRegistro = fechaRegistro;
    	this.clases = clases;
    }
    
    public DtActividad(String nombre, double costo, String descripcion) {
    	this.nombre = nombre;
    	this.costo = costo;
    	this.descripcion = descripcion;
    }

	public DtInstitucion getInstitucion() {
		return institucion.getDtInstitucion();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public double getCosto() {
		return costo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public int getCantidadDeClases() {
		return clases.size();
		
	}
	
	public List<DtClase> getClases() {
		List<DtClase> dtClases = new ArrayList<>();
		
		for(Clase clase: clases) {
			dtClases.add(clase.getDtClase());
		}
		
		return dtClases;
	}
}
