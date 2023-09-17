package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import datatypes.DtSocio;

@Entity
@Table(name = "Socio")
public class Socio extends Usuario {
	//@OneToMany
	@OneToMany(mappedBy = "socio")
	private List<Registro> registros = new ArrayList<>();
	//Constructor vacio
	
	public Socio() {};
	
	//Constructor
    public Socio(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento, String password) {
		super(nickname, nombre, apellido, correoElectronico, fechaNacimiento, password);
	}

    //Getters & Setters
	public List<Registro> getArrayRegistro() {
		return registros;
	}

	public void setArrayRegistro(ArrayList<Registro> arrayRegistro) {
		this.registros = arrayRegistro;
	}
	
	public void agregarRegistro(Registro registro) {
		registros.add(registro);
	}
	
	public DtSocio getDtSocio() {
		return new DtSocio(getNickname(), getNombre(), getApellido(), getCorreoElectronico(), getFechaNacimiento(), registros);
	}

}
