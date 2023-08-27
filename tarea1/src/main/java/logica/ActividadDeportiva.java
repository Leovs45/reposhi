package logica;

import java.util.Date;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IClase;

import java.util.ArrayList;

public class ActividadDeportiva {
    private String institucion;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private double costo;
    private Date fechaRegistro;
    private List<Clase> clases = new ArrayList<>();

    //Constructor
	public ActividadDeportiva(InstitucionDeportiva institucion2, String nombre, String descripcion, int duracionMinutos, double costo,
			Date fechaRegistro) {
		super();
		this.institucion = institucion2.getNombre();
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

	public List<Clase> getArrayClase() {
		return clases;
	}

	public void setArrayClase(List<Clase> arrayClase) {
		this.clases = arrayClase;
	}
	
	public Clase buscarClase(String nombre) {
		Clase clase = null;
		if (clases.size() == 0) {
			return clase;
		} else {
			for(Clase c: clases) {
				if (c.getNombreClase().equals(nombre)) {
					clase = c;
				}
			}
		}
		return clase;
	}
	
	public void listarClases() {
		if (clases.size() == 0) {
			System.out.println("  ERROR - No hay clases");
		} else {
			System.out.println("\nCLASES: \n");
			for (Clase c: clases) {
				System.out.println(c.getNombreClase() + " - " + c.getActividadDeportiva().getNombre() + " - " + c.getFechaClase() + " - " + c.getProfesor().getNombre() + " - " + c.getHoraInicio());
			}
		}
	}

	
	public void agregarClase(Clase c) {
		clases.add(c);

		Fabrica f = Fabrica.getInstancia();
		IClase iClase = f.getIClase();
		iClase.agregarClase(c);
	}
	
	public void registroClase(String nombreClase, Usuario usuario){
		Socio socio = (Socio) usuario;
		Clase clase = buscarClase(nombreClase);
		
		if (clase == null) {
			System.out.println("  ERROR - No existe una clase con el nombre " + nombreClase);
		} else {
			clase.registroClase(socio, clase);
		}
		System.out.println("Registrado usuario " + usuario.getNickname() + " en la clase" + clase.getNombreClase());
	}
	
	public boolean existenClases() {
		return clases.size() > 0;
	}
   
}
