package controladores;
import interfaces.*;
import logica.Clase;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.*;

public class CRegistro implements IRegistro{
	private List<Registro> registros = new ArrayList<>();
	private static CRegistro instancia = null;

	
	public static CRegistro getInstancia() {
		if (instancia == null)
			instancia = new CRegistro();
		return instancia;
	}
	
	public void RegistroDictadoClases(Date FechaRegistro, Socio unSocio, Clase unaClase ) {
		Registro unRegistro = new Registro(FechaRegistro,unSocio,unaClase);
		registros.add(unRegistro);
	}
}
