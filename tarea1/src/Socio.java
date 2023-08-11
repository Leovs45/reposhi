import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {

	private ArrayList<Registro> arrayRegistro;	
	
    public Socio(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento, ArrayList<Registro> arrayRegistro)
    {
    	super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
    	this.arrayRegistro= arrayRegistro;
    }

	public ArrayList<Registro> getArrayRegistro() {
		return arrayRegistro;
	}

	public void setArrayRegistro(ArrayList<Registro> arrayRegistro) {
		this.arrayRegistro = arrayRegistro;
	}



}
