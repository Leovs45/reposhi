package excepciones;

public class UsuarioNoEsProfesorException extends Exception {
  private static final long serialVersionUID = 1L;

	public UsuarioNoEsProfesorException(String string) {
    super(string);
  }
}