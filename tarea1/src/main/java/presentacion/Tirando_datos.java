package presentacion;
import java.util.Date;
import java.util.List;

import interfaces.*;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
import logica.Usuario;
import datatypes.*;


public class Tirando_datos {

	public void rellenarDatos() {
		// TODO Auto-generated method stub
		Date fecha =new Date();
		
		Fabrica f = Fabrica.getInstancia();
		//Institucion deportiva
		System.out.println("alta institucion deportiva");
		System.out.println("========================================");
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();//el controlador de insitucion deberia llevar una lista(coleccion) de insituciones y se agrega cada una al finalizar el alta
		iInstitucion.altaInstitucionDeportiva("Instituto 1","descripcion inistitucion 1", "url Insitucion 1");
		iInstitucion.altaInstitucionDeportiva("Instituto 2","descripcion inistitucion 2", "url Insitucion 2");
		iInstitucion.altaInstitucionDeportiva("Instituto 3","descripcion inistitucion 3", "url Insitucion 3");
		iInstitucion.altaInstitucionDeportiva("Instituto 4","descripcion inistitucion 4", "url Insitucion 4");
		//obtener/buscar  instituciones:
		System.out.println("buscar institucion deportiva");
		System.out.println("========================================");
		InstitucionDeportiva id1 = iInstitucion.buscarInstitucionDeportiva("Instituto 1");
		InstitucionDeportiva id2 = iInstitucion.buscarInstitucionDeportiva("Instituto 2");
		InstitucionDeportiva id3 = iInstitucion.buscarInstitucionDeportiva("Instituto 3");
		InstitucionDeportiva id4 = iInstitucion.buscarInstitucionDeportiva("Instituto 4");
		
		//Usuario:// hay coleccion de usuarios?
		System.out.println("alta de usuario profesor");
		System.out.println("========================================");
		IUsuario iUser = f.getIUsuario();
		iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 1", "nombre1", "apellido1", "correo1",fecha.toString(), id1, "descripcion general 1", "biografia 1", "url 1");
		iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 2", "nombre2", "apellido2", "correo1",fecha.toString(), id1, "descripcion general 2", "biografia 2", "url 2");
		iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 3", "nombre3", "apellido3", "correo1",fecha.toString(), id2, "descripcion general 3", "biografia 3", "url 3");
		iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 4", "nombre4", "apellido4", "correo1",fecha.toString(), id2, "descripcion general 4", "biografia 4", "url 4");
		
		
		//Usuario comun
		System.out.println("alta usuario comun");
		System.out.println("========================================");
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 1", "nombre1", "apellido1", "correo1",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 2", "nombre2", "apellido2", "correo2",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 3", "nombre3", "apellido3", "correo3",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 4", "nombre4", "apellido4", "correo4",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 5", "nombre5", "apellido5", "correo5",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 6", "nombre6", "apellido6", "correo6",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 7", "nombre7", "apellido7", "correo7",fecha.toString());
		iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 8", "nombre8", "apellido8", "correo8",fecha.toString());
		
		
		//busqueda/cosulta usuarios
		//profesor
		
		System.out.println("buscando usuario profesor");
		System.out.println("========================================");
		Usuario up1 = iUser.buscarUsuario("Profesor 1");
		Usuario up2 = iUser.buscarUsuario("Profesor 2");
		Usuario up3 = iUser.buscarUsuario("Profesor 3");
		Usuario up4 = iUser.buscarUsuario("Profesor 4");
		
		//comun
		System.out.println("buscando usuario comun");
		System.out.println("========================================");
		Usuario uc1 = iUser.buscarUsuario("UComun 1");
		Usuario uc2 = iUser.buscarUsuario("UComun 2");
		Usuario uc3 = iUser.buscarUsuario("UComun 3");
		Usuario uc4 = iUser.buscarUsuario("UComun 4");
		//Usuario uc5 = iUser.buscarUsuario("UComun 5");
		//Usuario uc7 = iUser.buscarUsuario("UComun 7");
		//Usuario uc8 = iUser.buscarUsuario("UComun 8");
		
		System.out.println("consultando usuarios ");
		System.out.println("========================================");
		//me esta faltando ConsultaUsuario() para probar hice esto:
		//donde se esta guardando el tipo de usuario???
		//if uc1 instaceof 
		iUser.consultaUsuario(uc1.getNickname());
		iUser.consultaUsuario(uc2.getNickname());
		iUser.consultaUsuario(uc3.getNickname());
		iUser.consultaUsuario(uc4.getNickname());
		
		iUser.consultaUsuario(up1.getNickname());
		iUser.consultaUsuario(up2.getNickname());
		iUser.consultaUsuario(uc3.getNickname());
		iUser.consultaUsuario(uc4.getNickname());
		
		//Actividad Deportiva://¿1no hay coleccion de actividades?
		
		System.out.println("alta Actividades deportivas");
		System.out.println("========================================");
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		iActividad.altaActividadDeportiva(id1.getNombre(), "nombreActividad 1","descripcion actividad 1", '8',1.1f,fecha);//1.1f es un float
		iActividad.altaActividadDeportiva(id1.getNombre(), "nombreActividad 2","descripcion actividad 2", '7',2.1f,fecha);
		iActividad.altaActividadDeportiva(id2.getNombre(), "nombreActividad 3","descripcion actividad a", '6',3.1f,fecha);
		iActividad.altaActividadDeportiva(id2.getNombre(), "nombreActividad 4","descripcion actividad b", '5',4.1f,fecha);
		iActividad.altaActividadDeportiva(id3.getNombre(), "nombreActividad 5","descripcion actividad 1", '4',5.1f,fecha);
		iActividad.altaActividadDeportiva(id3.getNombre(), "nombreActividad 6","descripcion actividad 2", '3',6.1f,fecha);
		iActividad.altaActividadDeportiva(id4.getNombre(), "nombreActividad 7","descripcion actividad a", '2',7.1f,fecha);
		iActividad.altaActividadDeportiva(id4.getNombre(), "nombreActividad 8","descripcion actividad b", '1',8.1f,fecha);
		
		//consulta Actividad Deportiva
		System.out.println("Consulta(lista de) Actividades Deportivas");
		System.out.println("========================================");
		List<ActividadDeportiva>lad1 = iActividad.consultaActividadDeportiva(id1.getNombre()); //esta no hacia  nada porque no esta?
		List<ActividadDeportiva>lad2 = iActividad.consultaActividadDeportiva(id2.getNombre());
		List<ActividadDeportiva>lad3 = iActividad.consultaActividadDeportiva(id3.getNombre());
		List<ActividadDeportiva>lad4 = iActividad.consultaActividadDeportiva(id4.getNombre());
		//List<ActividadDeportiva> actividadesEncontradas;
		System.out.println("========================================");
		for(ActividadDeportiva actividad : lad1) {//solo el lad1 y lad2 de ejemplo
			
			System.out.println("Nombre: " + actividad.getNombre());
		    System.out.println("Descripción: " + actividad.getDescripcion());
		    System.out.println("Duración en minutos: " + actividad.getDuracionMinutos());
		    System.out.println("Costo: " + actividad.getCosto());
		    System.out.println("Fecha de alta: " + actividad.getFechaRegistro());
		    System.out.println("--------------------------------------------");
			
		}
		System.out.println("========================================");
		for(ActividadDeportiva actividad : lad2) {
			
			System.out.println("Nombre: " + actividad.getNombre());
		    System.out.println("Descripción: " + actividad.getDescripcion());
		    System.out.println("Duración en minutos: " + actividad.getDuracionMinutos());
		    System.out.println("Costo: " + actividad.getCosto());
		    System.out.println("Fecha de alta: " + actividad.getFechaRegistro());
		    System.out.println("--------------------------------------------");
			
		}
		
		// busca Actividad Deportiva
		System.out.println("BUSCA actividades deportivas");
		System.out.println("========================================");
		//List<ActividadDeportiva> actividadesEncontradas = controladorActividades.consultaActividadDeportiva("nombreDeLaInstitucion");
		
		ActividadDeportiva ad1= iActividad.buscarActividadDeportiva("nombreActividad 1");
		ActividadDeportiva ad2= iActividad.buscarActividadDeportiva("nombreActividad 2");
		ActividadDeportiva ad3= iActividad.buscarActividadDeportiva("nombreActividad 3");
		ActividadDeportiva ad4= iActividad.buscarActividadDeportiva("nombreActividad 4");
		ActividadDeportiva ad5= iActividad.buscarActividadDeportiva("nombreActividad 5");
		ActividadDeportiva ad6= iActividad.buscarActividadDeportiva("nombreActividad 6");
		ActividadDeportiva ad7= iActividad.buscarActividadDeportiva("nombreActividad 7");
		ActividadDeportiva ad8= iActividad.buscarActividadDeportiva("nombreActividad 8");
		
		
		//Alta Dictado de clases
		System.out.println("alta dicatado de clases");
		System.out.println("========================================");
		IClase iClase= f.getIClase();
		iClase.altaDictadoClase(id1.getNombre(), "nombre Clase 1", fecha, "14:00", up1.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id1.getNombre(), "nombre Clase 2", fecha, "15:00", up1.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id2.getNombre(), "nombre Clase 1", fecha, "14:00", up2.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id2.getNombre(), "nombre Clase 2", fecha, "15:00", up2.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id3.getNombre(), "nombre Clase 1", fecha, "14:00", up3.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id3.getNombre(), "nombre Clase 2", fecha, "15:00", up3.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id4.getNombre(), "nombre Clase 1", fecha, "14:00", up4.getNombre(),"String url", fecha);
		iClase.altaDictadoClase(id4.getNombre(), "nombre Clase 2", fecha, "15:00", up4.getNombre(),"String url", fecha);
		
	
		//Registro a dictado de Clase del tipo asociativo  dede clase?? esta no esta haciendo nada por ahora
		System.out.println("alta registro dictado de clases");
		System.out.println("========================================");
		iClase.registroClase(id1.getNombre(), ad1.getNombre(),"nombre Clase 1", uc1.getNombre());//usuario comun  estoy tirando un socio
		iClase.registroClase(id1.getNombre(), ad2.getNombre(),"nombre Clase 2", uc1.getNombre());
		iClase.registroClase(id2.getNombre(), ad3.getNombre(),"nombre Clase 1", uc2.getNombre());
		iClase.registroClase(id2.getNombre(), ad4.getNombre(),"nombre Clase 2", uc2.getNombre());
		iClase.registroClase(id3.getNombre(), ad5.getNombre(),"nombre Clase 1", uc3.getNombre());
		iClase.registroClase(id3.getNombre(), ad6.getNombre(),"nombre Clase 2", uc3.getNombre());
		iClase.registroClase(id4.getNombre(), ad7.getNombre(),"nombre Clase 1", uc4.getNombre());
		iClase.registroClase(id4.getNombre(), ad8.getNombre(),"nombre Clase 2", uc4.getNombre());
	}
	

}
