package controladores;
import logica.*;
import java.util.ArrayList;
import java.util.List;

import datatypes.TipoUsuario;
import interfaces.IUsuario;
import logica.Usuario;

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
	
	public boolean esProfesor(Usuario u) {
		if(u instanceof Profesor) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void consultaUsuario(String nickname) {
		Usuario usuario = buscarUsuario(nickname);
		
		if(usuario == null) {
			System.out.println("  ERROR - No existe un usuario con el nickname " + nickname);
		} else {
			if (usuario instanceof Socio) {
				System.out.println("SOCIO: " + usuario.getNickname());
				System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
				System.out.println("Correo electronico: " + usuario.getCorreoElectronico());
				System.out.println("Fecha de Nacimiento: " + usuario.getFechaNacimiento());
				// TODO agregar que se muestre las clases en las que participó
			} else {
				Profesor profe = (Profesor) usuario;
				System.out.println("PROFESOR: " + usuario.getNickname());
				System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
				System.out.println("Correo electronico: " + usuario.getCorreoElectronico());
				System.out.println("Fecha de Nacimiento: " + usuario.getFechaNacimiento());
				System.out.println("Clases que dicta: ");
				profe.listarClases();
			}
		}
		
	}

	@Override
	public void modificarNombre(String nickname, String nuevoNombre) {
		Usuario user = buscarUsuario(nickname);
		user.setNombre(nuevoNombre);
	}

	@Override
	public void modificarApellido(String nickname, String nuevoApellido) {
		Usuario user = buscarUsuario(nickname);
		user.setApellido(nuevoApellido);
	}

	@Override
	public void modificarFechaNacimiento(String nickname, String nuevaFecha) {
		Usuario user = buscarUsuario(nickname);
		user.setFechaNacimiento(nuevaFecha);
	}
	
	@Override
	public void listarUsuarios() {
		if(usuarios.size() == 0) {
			System.out.println("  ERROR - No existe ningun usuario creado");
		} else {
			for(Usuario u: usuarios) {
				System.out.println(u.getNickname());
			}
		}
	}
	
	@Override
	public boolean existenUsuarios() {
		return usuarios.size() != 0;
	}
	
}
