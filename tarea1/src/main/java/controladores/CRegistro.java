package controladores;
import interfaces.*;
import logica.Clase;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.*;

public class CRegistro implements IRegistro{
//	private List<Registro> registros = new ArrayList<>();
	private static CRegistro instancia = null;

	
	public static CRegistro getInstancia() {
		if (instancia == null)
			instancia = new CRegistro();
		return instancia;
	}
	
	public void RegistroDictadoClases(Date FechaRegistro, String unSocio, String unaClase ) {
		Fabrica f = Fabrica.getInstancia();
		IUsuario cuser = f.getIUsuario();
		Socio soc = (Socio) cuser.buscarSocio(unSocio);
		IClase cclase = f.getIClase();
		Clase clas = cclase.buscarClase(unaClase);
		Registro unRegistro = new Registro(FechaRegistro,unSocio,unaClase);
		System.out.println("mira como anoto");
		soc.agregarRegistro(unRegistro);
	}
}
