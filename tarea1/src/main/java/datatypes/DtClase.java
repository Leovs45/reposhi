package datatypes;

import java.util.Date;

public class DtClase {
	private String nombre;
	private Date fechaClase;
	private String horaInicio;
	private String url;
	private Date fechaRegistro;
	
	public DtClase(String nombre, Date fechaClase, String horaInicio,String url, Date fechaRegistro) {
		this.nombre = nombre;
		this.fechaClase = fechaClase;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaRegistro = fechaRegistro;
	}
	public String getNombre() {
		return nombre;
	}

	public String getUrl() {
		return url;
	}
	public Date getFechaClase() {
		return fechaClase;
	}
	public void setFechaClase(Date fechaClase) {
		this.fechaClase = fechaClase;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
