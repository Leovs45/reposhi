package logica;

import java.util.Date;
import java.util.ArrayList;

public class ActividadDeportiva {
    private String institucion;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private double costo;
    private Date fechaRegistro;
    ArrayList<ActividadDeportiva> arrayActividadDeportiva;
    private ArrayList<Clase> arrayClase;

    //Constructor
	public ActividadDeportiva(String institucion, String nombre, String descripcion, int duracionMinutos, double costo,
			Date fechaRegistro) {
		super();
		this.institucion = institucion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionMinutos = duracionMinutos;
		this.costo = costo;
		this.fechaRegistro = fechaRegistro;
	}
	
	//Getters & Setters
	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
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

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public ArrayList<Clase> getArrayClase() {
		return arrayClase;
	}
	public void setAgregarActividad(ActividadDeportiva ad){
		
		this.arrayActividadDeportiva.add(ad);
	}
	public void setArrayClase(ArrayList<Clase> arrayClase) {
		this.arrayClase = arrayClase;
	}

   
}
