package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IClase;
import interfaces.IUsuario;
@Entity
@Table(name = "Registro")
public class Registro {
	@Id
	private	Date fechaRegistro;
	@ManyToOne
	private Socio socio;
	@ManyToOne
	private Clase clase;
	
//costructor vacio
public Registro(){};

	//Constructor
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
