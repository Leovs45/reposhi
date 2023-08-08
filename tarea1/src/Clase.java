import java.util.Date;

public class Clase {
    private String nombreClase;
    private ActividadDeportiva actividadDeportiva;
    private Date fechaClase;
    private Profesor profesor;
    private String horaInicio;
    private String urlClase;
    private Date fechaRegistro;

    public Clase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, Profesor profesor,
                 String horaInicio, String urlClase, Date fechaRegistro) {
        this.nombreClase = nombreClase;
        this.actividadDeportiva = actividadDeportiva;
        this.fechaClase = fechaClase;
        this.profesor = profesor;
        this.horaInicio = horaInicio;
        this.urlClase = urlClase;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public ActividadDeportiva getActividadDeportiva() {
        return actividadDeportiva;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getUrlClase() {
        return urlClase;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    // Setters (si es necesario)
}
