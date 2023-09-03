package excepciones;

public class EmailRepetidoException extends Exception {
	private static final long serialVersionUID = 1L;

    public EmailRepetidoException(String mensaje) {
        super(mensaje);
    }
}
