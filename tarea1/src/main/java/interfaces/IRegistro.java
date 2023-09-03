package interfaces;
import java.util.Date;

import excepciones.RegistroClaseRepetidoException;
import logica.*;

public interface IRegistro {

public void RegistroDictadoClases(Date FechaRegistro, Socio unSocio, Clase unaClase ) throws RegistroClaseRepetidoException;

}
