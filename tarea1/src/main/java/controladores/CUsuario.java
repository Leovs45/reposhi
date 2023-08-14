package controladores;

import java.util.Date;

import datatypes.TipoUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario{

	@Override
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String email,
			Date fechaNacimiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaProfesor(String nickname, String nombre, String apellido, String email, Date fechaNacimiento,
			String institucion, String descripcion, String biografia, String link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultaUsuario() {
		// TODO Auto-generated method stub
		
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarNombre(String nickname, String nuevoNombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarApellido(String nickname, String nuevoApellido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarFechaNacimiento(String nickname, Date nuevaFecha) {
		// TODO Auto-generated method stub
		
	}
	
}
