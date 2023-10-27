package publicadores;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import datatypes.DtActividad;
import interfaces.Fabrica;
import interfaces.IActividadDeportiva;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class publicadorActividadDeportiva {
	private Fabrica fabrica;
	private IActividadDeportiva iAct;
	private Endpoint endpoint;

	
	public publicadorActividadDeportiva() {
		fabrica = Fabrica.getInstancia();
		iAct = fabrica.getIActividadDeportiva();
	}
	
	@WebMethod(exclude = true)//este no lo queremos accesible desde los web services
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:8080/publicadores", this);
    }
	
	@WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

	//LOS MÉTODOS QUE VAMOS A PUBLICAR (segun caso de uso solo los que utilizo en este caso,tambien se podrian publicar todos)
	
	@WebMethod
	public boolean existeActividad(String nombreActividad){
		//quizas evaular que nombreActividad no sea null
		return iAct.existeActividad(nombreActividad);
	}
	
	@WebMethod
		public DtActividad getDtActividad(String nombreActividad){
			//quizas evaular que nombreActividad no sea null
			 return iAct.getDtActividad(nombreActividad);
		}
		
		
		
}
