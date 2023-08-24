package interfaces;

import logica.*;
import java.util.Date;

import controladores.CUsuario;
import datatypes.TipoUsuario;

public interface IUsuario {
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, InstitucionDeportiva institucion, String descripcionGeneral, String biografia, String sitioWeb);
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento);
	public void consultaUsuario(String nickname);
	
	// Opcionales
	public void modificarNombre(String nickname, String nuevoNombre);
	public void modificarApellido(String nickname, String nuevoApellido);
	public void modificarFechaNacimiento(String nickname, String nuevaFecha);
	
	// Adicionales
	public Usuario buscarUsuario(String nombre);
	public void listarUsuarios();
	public boolean esProfesor(Usuario u);
	public boolean existenUsuarios();
	public Usuario buscarSocio(String nickname);
	public void listarSocios();
}
