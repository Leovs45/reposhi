package logica;

import java.util.Date;

public class Registro {
	private	Date fechaRegistro;
	private Socio socio;
	private Clase clase;

	//Constructor
	public Registro(Date fechaRegistro, Socio socio, Clase clase) {
		super();
		this.fechaRegistro = fechaRegistro;
		this.socio = socio;
		this.clase = clase;
	}
	
	//Getters & setters
	public Date getfechaRegistro() {
		return fechaRegistro;
	}
	
	public void setfechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Socio getsocio() {
		return socio;
	}
	
	public void setsocio(Socio socio) {
		this.socio = socio;
	}
	
	public Clase getclase() {
		return clase;
	}
	
	public void setclase(Clase clase) {
		this.clase = clase;
	}
	
}
