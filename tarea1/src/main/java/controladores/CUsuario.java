package controladores;
import logica.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario {
	private List<Usuario> usuarios = new ArrayList<>();
	
	private static CUsuario instancia = null;

	public static CUsuario getInstancia() {
		if (instancia == null)
			instancia = new CUsuario();
		return instancia;
	}
	
	@Override
	public void altaUsuario(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento, InstitucionDeportiva institucion, String descripcionGeneral, String biografia, String sitioWeb){
		Usuario profe = new Profesor(nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
		usuarios.add(profe);
	}
	
	public void altaUsuario(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento) {
		Usuario socio = new Socio(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
		usuarios.add(socio);
	}	
	
	@Override
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
	    }
	}
	
	public boolean esProfesor(Usuario u) {
		if(u instanceof Profesor) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<DtUsuario> getUsuarios() {
		List<DtUsuario> dtUsuarios = new ArrayList<>();
		
		for(Usuario u: usuarios) {
			dtUsuarios.add(u.getDtUsuario());
		}
		
		return dtUsuarios;
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
	public void modificarFechaNacimiento(String nickname, Date nuevaFecha) {
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
	public void listarSocios() {
		if(usuarios.size() == 0) {
			System.out.println("  ERROR - No existe ningun usuario creado");
		} else {
			for(Usuario u: usuarios) {
				if(u instanceof Socio) {
					System.out.println(u.getNickname());
				}
			}
		}
	}
	
	@Override
	public Usuario buscarSocio(String nickname) {
		Usuario socio = null;
		if (usuarios.size() == 0) {
			return socio;
		} else {
			for(Usuario u: usuarios) {
				if (u.getNickname().equals(nickname)) {
					if(u instanceof Socio) {
						socio = u;
					}
				}
			}
		}

		return socio;
	}
	
	@Override
	public boolean existenUsuarios() {
		return usuarios.size() != 0;
	}
	
	@Override 
	public List<String> obtenerArrayNicknames() {
		List nicknames = new ArrayList<>();
			
		for(Usuario u: usuarios) {
			nicknames.add(u.getNickname());
		}
		
		return nicknames;
	}
	
	@Override
	public DtUsuario getDtUsuario(String nickname) {
		Usuario user = buscarUsuario(nickname);
		
		return new DtUsuario(user.getNickname(), user.getNombre(), user.getApellido(), user.getCorreoElectronico(), user.getFechaNacimiento());
	}
	
	@Override
	public boolean esSocio(String nickname) {
		Usuario usuario = buscarUsuario(nickname);
		boolean esSocio;
		if(usuario instanceof Socio) {
			esSocio = true;
		} else {
			esSocio = false;
		}
		return esSocio;
	}
	
	@Override
	public DtSocio getDtSocio(String nickname) {
		Usuario user = buscarUsuario(nickname);
		
		Socio socio = (Socio) user;
		
		return socio.getDtSocio();
	}
	
	@Override 
	public DtProfesor getDtProfesor(String nickname) {
		Usuario user = buscarUsuario(nickname);
		
		Profesor profesor = (Profesor) user;
		
		return profesor.getDtProfesor();
	}
	
	@Override
	public boolean existeUsuario(String nickname) {
		Usuario user = buscarUsuario(nickname);
		
		if(user == null) {
			return false;
		} else {
			return true;
		}
	}
}
