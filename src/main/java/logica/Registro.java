package logica;

import java.util.Date;

public class Registro {
	private	Date fechaReg;
	private Socio unSocio;
	private Clase unaClase;
	public
		Registro(Date fechaReg, Socio unSocio, Clase unaClase)
		{
			this.fechaReg = fechaReg;
			this.unSocio = unSocio;
			this.unaClase = unaClase;
		}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public Socio getUnSocio() {
		return unSocio;
	}
	public void setUnSocio(Socio unSocio) {
		this.unSocio = unSocio;
	}
	public Clase getUnaClase() {
		return unaClase;
	}
	public void setUnaClase(Clase unaClase) {
		this.unaClase = unaClase;
	}
	
	
}