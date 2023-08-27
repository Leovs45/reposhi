package logica;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Clase {
    private String nombreClase;
    private ActividadDeportiva actividadDeportiva;
    private Date fechaClase;
    private Profesor profesor;
    private String horaInicio;
    private String urlClase;
    private Date fechaRegistro;
    private List<Registro> registros = new ArrayList<>();
    
    //Constructor
	public Clase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, Profesor profesor,String horaInicio, String urlClase, Date fechaRegistro) {
		super();
		this.nombreClase = nombreClase;
		this.actividadDeportiva = actividadDeportiva;
		this.fechaClase = fechaClase;
		this.profesor = profesor;
		this.horaInicio = horaInicio;
		this.urlClase = urlClase;
		this.fechaRegistro = fechaRegistro;
	}
	
	//Getters & Setters
	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public ActividadDeportiva getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(ActividadDeportiva actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public Date getFechaClase() {
		return fechaClase;
	}

	public void setFechaClase(Date fechaClase) {
		this.fechaClase = fechaClase;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getUrlClase() {
		return urlClase;
	}

	public void setUrlClase(String urlClase) {
		this.urlClase = urlClase;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Registro> getArrayRegistro() {
		return registros;
	}

	public void setArrayRegistro(ArrayList<Registro> arrayRegistro) {
		this.registros = arrayRegistro;
	}
	
	public void registroClase(Socio socio, Clase clase) {
		Date date = new Date();
		Registro registro = new Registro(date, socio, clase);
		registros.add(registro);
		socio.agregarRegistro(registro);
	}

}