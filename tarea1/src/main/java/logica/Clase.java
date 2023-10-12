package logica;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import datatypes.DtClase;

import java.util.ArrayList;
@Entity
@Table(name = "Clase")
public class Clase {
	@Id
    private String nombreClase;
	@ManyToOne
    private ActividadDeportiva actividadDeportiva;
    @Column
	private Date fechaClase;
    @ManyToOne(targetEntity = Profesor.class)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
    @Column
    private String horaInicio;
    @Column
    private String urlClase;
    @Column
    private Date fechaRegistro;
    @OneToMany
    private List<Registro> registros = new ArrayList<>();
    // constructor vacio
    public Clase() {}
    //Constructor
	public Clase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, Profesor profesor,
			String horaInicio, String urlClase, Date fechaRegistro) {
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
		Registro registro = new Registro(date, socio.getNickname(), clase.getNombreClase());
		registros.add(registro);
		socio.agregarRegistro(registro);
	}
	public void agregarRegistro(Registro registro) {
		registros.add(registro);
	}
	
	public int getCantidadRegistros() {
		return registros.size();
	}
	
	public DtClase getDtClase() {
		return new DtClase(nombreClase, actividadDeportiva, fechaClase, horaInicio, urlClase, fechaRegistro);
	}

}
