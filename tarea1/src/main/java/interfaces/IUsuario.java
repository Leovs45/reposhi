package interfaces;

import java.util.Date;
import datatypes.TipoUsuario;

public interface IUsuario {
	public void altaUsuario(TipoUsuario tipoUsuario, String nickname, String nombre, String apellido, String email, Date fechaNacimiento);
	// La idea es que si TipoUsuario == Profesor, adentro de la implementación de altaUsuario se llame a altaProfesor. Sino, se crea el socio comun
	public void altaProfesor(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String institucion, String descripcion, String biografia, String link);
	public void consultaUsuario();
	
	//Opcionales
	public void modificarNombre(String nickname, String nuevoNombre);
	public void modificarApellido(String nickname, String nuevoApellido);
	public void modificarFechaNacimiento(String nickname, Date nuevaFecha);
}
