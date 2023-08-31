package datatypes;

import java.util.Date;

public class DtRegistro {
    private Date fechaRegistro;
    private DtSocio socio;
    private DtClase clase;

    public DtRegistro(Date fechaRegistro, DtSocio socio, DtClase clase) {
        this.fechaRegistro = fechaRegistro;
        this.socio = socio;
        this.clase = clase;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public DtSocio getSocio() {
        return socio;
    }

    public DtClase getClase() {
        return clase;
    }
}
