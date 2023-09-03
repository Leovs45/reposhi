package controladores;
import interfaces.*;
import logica.Clase;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.*;
import excepciones.RegistroClaseRepetidoException;


public class CRegistro implements IRegistro{
	private List<Registro> registros = new ArrayList<>();
	private static CRegistro instancia = null;

	
	public static CRegistro getInstancia() {
		if (instancia == null)
			instancia = new CRegistro();
		return instancia;
	}
	/*
	public void RegistroDictadoClases(Date FechaRegistro, Socio unSocio, Clase unaClase ) {
		Registro unRegistro = new Registro(FechaRegistro,unSocio,unaClase);
		registros.add(unRegistro);
	}*/
	
	public void RegistroDictadoClases(Date FechaRegistro, Socio unSocio, Clase unaClase) throws RegistroClaseRepetidoException {
	    for (Registro registroExistente : registros) {
	        if (registroExistente.getsocio().equals(unSocio) && 
	            registroExistente.getclase().equals(unaClase) &&
	            registroExistente.getfechaRegistro().equals(FechaRegistro)) {
	            throw new RegistroClaseRepetidoException("El socio ya está registrado para esta clase en esta fecha.");
	        }
	    }

	    Registro unRegistro = new Registro(FechaRegistro, unSocio, unaClase);
	    registros.add(unRegistro);
	}


	

}

