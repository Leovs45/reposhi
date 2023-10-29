package publicadores;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;


import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IUsuario;
import interfaces.IClase;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class publicadorConsultaUsuario {
	
	private Fabrica fabrica;
	private  IUsuario iUs;
	private Endpoint endpoint;
	

	public publicadorConsultaUsuario() {
		
		fabrica = Fabrica.getInstancia();
		iUs = fabrica.getIUsuario();

	}
	
	@WebMethod(exclude = true)//este no lo queremos accesible desde los web services
	public void publicar(){
		endpoint = Endpoint.publish("http://localhost:1980/publicado", this);
	}
	
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR (yo solo publicaria los metodos de las interfaces que utilizo para el CU de la tarea 2 en el servlert,tambien se podrian publicar todos)
	@WebMethod
	public boolean esSocio(String nickname){
		//quizas evaular que no sea null
		return iUs.esSocio(nickname);
	}
	
	@WebMethod
	public DtSocio getDtSocio(String nickname){
		
		return iUs.getDtSocio(nickname);
	}
	
	@WebMethod
	public DtProfesor getDtProfesor(String nickname){
		
		return iUs.getDtProfesor(nickname);
	}
	
	

		
}
