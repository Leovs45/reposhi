package logica;

import java.util.Date;


import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IClase;
import interfaces.IUsuario;

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
	
	public Registro(Date fechaRegistro, String socio, String clase) {
		super();
		this.fechaRegistro = fechaRegistro;
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();
		this.socio = (Socio) iUsuario.buscarSocio(socio);
		IClase iclase = f.getIClase();
		this.clase = iclase.buscarClase(clase);		
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
	
	public DtRegistro getDtRegistro() {
		return new DtRegistro(fechaRegistro, socio.getDtSocio(), clase.getDtClase());
	}
	
}
