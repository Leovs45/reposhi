package excepciones;

public class NoExisteInstitucionException extends Exception {
  private static final long serialVersionUID = 1L;

	public NoExisteInstitucionException(String string) {
    super(string);
  }
}
