import java.util.Date;

public class ActividadDeportiva {
    private String institucion;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private double costo;
    private Date fechaRegistro;

    public ActividadDeportiva(String institucion, String nombre, String descripcion, int duracionMinutos,
                              double costo, Date fechaRegistro) {
        this.institucion = institucion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public double getCosto() {
        return costo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    // Setters (si es necesario)
}
