import java.util.Date;

public class Profesor extends Usuario {
    private String institucion;
    private String descripcionGeneral;
    private String biografia;
    private String sitioWeb;

    public Profesor(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento,
                    String institucion, String descripcionGeneral, String biografia, String sitioWeb) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
        this.institucion = institucion;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    // Setters (si es necesario)
}
