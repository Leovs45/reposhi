package interfaces;

import logica.*;
import java.util.Date;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public interface IUsuario {
	public void altaUsuario(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento, InstitucionDeportiva institucion, String descripcionGeneral, String biografia, String sitioWeb);
	public void altaUsuario(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento);
	public List<DtUsuario> getUsuarios();
	
	// Opcionales
	public void modificarNombre(String nickname, String nuevoNombre);
	public void modificarApellido(String nickname, String nuevoApellido);
	public void modificarFechaNacimiento(String nickname, Date nuevaFecha);
	
	// Adicionales
	public Usuario buscarUsuario(String nombre);
	public void listarUsuarios();
	public boolean existeUsuario(String nombre);
	public boolean esProfesor(String nombre);
	public boolean existenUsuarios();
	public Usuario buscarSocio(String nickname);
	public void listarSocios();
	public void consultaUsuario(String nickname);
	public List<String> obtenerArrayNicknames();
	public DtUsuario getDtUsuario(String nickname);
	public boolean esSocio(String nickname);
	public DtSocio getDtSocio(String nickname);
	public DtProfesor getDtProfesor(String nickname);
	boolean existeUsuario(String nickname);
}
