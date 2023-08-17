package logica;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
	private ArrayList<Registro> arrayRegistro;
	
	//Constructor
    public Socio(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,
			ArrayList<Registro> arrayRegistro) {
		super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
		this.arrayRegistro = arrayRegistro;
	}

    //Getters & Setters
	public ArrayList<Registro> getArrayRegistro() {
		return arrayRegistro;
	}

	public void setArrayRegistro(ArrayList<Registro> arrayRegistro) {
		this.arrayRegistro = arrayRegistro;
	}

}
