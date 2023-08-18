package controladores;
import logica.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import datatypes.TipoUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario{
	private List<Usuario> usuarios = new ArrayList<>();
	
	private static CUsuario instancia = null;

	public static CUsuario getInstancia() {
		if (instancia == null)
			instancia = new CUsuario();
		return instancia;
	}
	
	
	@Override
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, InstitucionDeportiva institucion, String descripcionGeneral, String biografia, String sitioWeb){
		if(tipoUsuario == TipoUsuario.Profesor) {
			Usuario profe = new Profesor(nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
			usuarios.add(profe);
		}
	}
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento) {
		if(tipoUsuario == TipoUsuario.UsuarioComun) {
			Usuario socio = new Socio(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
			usuarios.add(socio);
		}
	}	
	public Usuario buscarUsuario(String nickname) {
		Usuario usuario = null;
		if (usuarios.size() == 0) {
			return usuario;
		} else {
			for(Usuario i: usuarios) {
				if (i.getNickname().equals(nickname)) {
					usuario = i;
				}
			}
		}

		return usuario;
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
