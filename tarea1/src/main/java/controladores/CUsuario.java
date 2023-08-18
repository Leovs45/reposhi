package controladores;
import logica.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import datatypes.TipoUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario{
	private List<Usuario> usuarios = new ArrayList<>();
	
	
	@Override
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String institucion, String descripcionGeneral, String biografia, String sitioWeb){
		if(tipoUsuario == TipoUsuario.Profesor) {
			Usuario profe = new Profesor(nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
			usuarios.add(profe);
		}
	}
	public void existeUsuario(String nombre) {
		for (Usuario usuario : usuarios) {
			if(usuario.getNombre().equals(nombre)) {
				System.out.print("Existe este usuario");
			}else
				System.out.print("No Existe este usuario");
		}
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
