package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor extends Usuario {
    private InstitucionDeportiva institucion;
    private String descripcionGeneral;
    private String biografia;
    private String sitioWeb;
    private List<Clase> clases = new ArrayList<>();
    
    //Constructor
    public Profesor(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento,
    		InstitucionDeportiva institucion, String descripcionGeneral, String biografia, String sitioWeb) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
        this.institucion = institucion;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }
 
    //Getters & Setters
	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
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
	
	public void agregarClase(Clase c) {
		clases.add(c);
	}
	
	public Clase buscarClase(String nombre) {
		Clase clase = null;
		if (clases.size() == 0) {
			return clase;
		} else {
			for(Clase c: clases) {
				if (c.getNombreClase().equals(nombre)) {
					clase = c;
				}
			}
		}

		return clase;
	}

    
}
