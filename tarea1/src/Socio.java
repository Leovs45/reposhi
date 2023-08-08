import java.util.Date;

public class Socio {
    private Usuario usuario;
    private Date fechaInscripcion;

    public Socio(Usuario usuario, Date fechaInscripcion) {
        this.usuario = usuario;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    // Setters (si es necesario)
}
