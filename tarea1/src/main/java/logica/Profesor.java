package logica;

import java.util.Date;

public class Profesor extends Usuario {
    private String institucion;
    private String descripcionGeneral;
    private String biografia;
    private String sitioWeb;

    //Constructor
    public Profesor(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento,
                    String institucion, String descripcionGeneral, String biografia, String sitioWeb) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
        this.institucion = institucion;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }
 
    //Getters & Setters
	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getDescripcionGeneral() {
		return descripcionGeneral;
	}

	public void setDescripcionGeneral(String descripcionGeneral) {
		this.descripcionGeneral = descripcionGeneral;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

    
}
