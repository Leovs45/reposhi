package logica;

import logica.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
	private ArrayList<Registro> arrayRegistro;
	
	//Constructor
    public Socio(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento) {
		super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
	}

    //Getters & Setters
	public ArrayList<Registro> getArrayRegistro() {
		return arrayRegistro;
	}

	public void setArrayRegistro(ArrayList<Registro> arrayRegistro) {
		this.arrayRegistro = arrayRegistro;
	}

}
