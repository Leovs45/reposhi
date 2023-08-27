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
	/*public Usuario buscarUsuario(String nickname) {
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
	}*/
	public Usuario buscarUsuario(String nickname) {
	    Usuario usuario = null;
	    for (Usuario i : usuarios) {
	        if (i.getNickname().equals(nickname)) {
	            usuario = i;
	            break; // Se puede salir del bucle una vez que se encuentra el usuario
	        }
	    }
	    return usuario; // Retornar null si no se encontró, o el usuario encontrado
	}


	@Override
	public void consultaUsuario(String nickname) {
	    Usuario usuario = buscarUsuario(nickname);
	    
	    if (usuario == null) {
	        System.out.println("Usuario no encontrado.");
	    } else {
	        System.out.println("Detalles del usuario:");
	       // System.out.println("Tipo de Usuario: " + usuario.getTipoUsuario());
	        System.out.println("Nickname: " + usuario.getNickname());
	        System.out.println("Nombre: " + usuario.getNombre());
	        System.out.println("Apellido: " + usuario.getApellido());
	        System.out.println("Correo Electrónico: " + usuario.getCorreoElectronico());
	        System.out.println("Fecha de Nacimiento: " + usuario.getFechaNacimiento());
	        
	        if (usuario instanceof Profesor) {
	            Profesor profesor = (Profesor) usuario;
	            System.out.println("Institución: " + profesor.getInstitucion());
	            System.out.println("Descripción General: " + profesor.getDescripcionGeneral());
	            System.out.println("Biografía: " + profesor.getBiografia());
	            System.out.println("Sitio Web: " + profesor.getSitioWeb());
	        }
	        
	        System.out.println("--------------------------------------------");
	    }
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
