package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends Usuario {
	private List<Registro> registros = new ArrayList<>();
	
	//Constructor
    public Socio(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento) {
		super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
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
	
	public void listarRegistros() {
		if(registros.size() > 0) {
			for(Registro r: registros) {
				System.out.println("- " + r.getclase().getNombreClase() + "\n  Fecha de registro: " + r.getfechaRegistro());
			}
		}
	}

}
