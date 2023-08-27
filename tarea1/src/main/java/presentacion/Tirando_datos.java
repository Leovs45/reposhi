package presentacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.*;
import logica.*;
import datatypes.*;


public class Tirando_datos{


	public void rellenarDatos() {
		
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
		
		System.out.println("coleccion de institucion deportiva");
		System.out.println("========================================");
		
		List<InstitucionDeportiva> ins = iInstitucion.getListaInstituciones();//las "coleccion de " intituciones recordadas por el controlador
		for(InstitucionDeportiva i : ins) {
			System.out.println(i.getNombre());
		}
		
		
		
		//obtener/buscar  instituciones:
		System.out.println("buscar institucion deportiva");
		System.out.println("========================================");
		InstitucionDeportiva id1 = iInstitucion.buscarInstitucionDeportiva("Instituto 1");
		InstitucionDeportiva id2 = iInstitucion.buscarInstitucionDeportiva("Instituto 2");
		InstitucionDeportiva id3 = iInstitucion.buscarInstitucionDeportiva("Instituto 3");
		InstitucionDeportiva id4 = iInstitucion.buscarInstitucionDeportiva("Instituto 4");
		
		//Usuario: hay coleccion de usuarios?
		System.out.println("alta de usuario profesor");
		System.out.println("========================================");
		//Profesor(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento,InstitucionDeportiva institucion, String descripcionGeneral, String biografia, String sitioWeb)
		Profesor p1 = new Profesor("Profesor 1", "nombre1", "apellido1", "correo1",fecha.toString(),id1, "descripcion general 1", "biografia 1", "url 1");
		Profesor p2 = new Profesor("Profesor 2", "nombre2", "apellido2", "correo2",fecha.toString(),id2, "descripcion general 2", "biografia 2", "url 2");
		Profesor p3 = new Profesor("Profesor 3", "nombre3", "apellido3", "correo3",fecha.toString(),id3, "descripcion general 3", "biografia 3", "url 3");
		Profesor p4= new Profesor("Profesor 4", "nombre4", "apellido4", "correo4",fecha.toString(),id4, "descripcion general 4", "biografia4", "url 4");
		//Profesor profesor = (Profesor) usuario;
		IUsuario iu = f.getIUsuario();
		Usuario usuario = iu.buscarUsuario("Profesor 4");
		//Profesor profesor = (Profesor) usuario;//me dice que profesor es null
		System.out.println(iu.toString());
		IUsuario iUser = f.getIUsuario();
		
		//iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 1", "nombre1", "apellido1", "correo1",fecha.toString(), id1, "descripcion general 1", "biografia 1", "url 1");
		//iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 2", "nombre2", "apellido2", "correo1",fecha.toString(), id1, "descripcion general 2", "biografia 2", "url 2");
		//iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 3", "nombre3", "apellido3", "correo1",fecha.toString(), id2, "descripcion general 3", "biografia 3", "url 3");
		//iUser.altaUsuario(TipoUsuario.Profesor, "Profesor 4", "nombre4", "apellido4", "correo1",fecha.toString(), id2, "descripcion general 4", "biografia 4", "url 4");
		
		//iUser.altaUsuario(tpProfe, nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
		//iUser.altaUsuario(tpSocio, nickname, nombre, apellido, correoElectronico, fechaNacimiento);
		
		//Usuario comun
		System.out.println("alta usuario comun");
		System.out.println("========================================");
		
		Socio s1= new Socio("UComun 1", "nombre1", "apellido1", "correo1",fecha.toString());
		Socio s2= new Socio("UComun 2", "nombre2", "apellido2", "correo2",fecha.toString());
		Socio s3= new Socio("UComun 3", "nombre3", "apellido3", "correo3",fecha.toString());
		Socio s4= new Socio("UComun 4", "nombre4", "apellido4", "correo4",fecha.toString());
		//Socio s5= new Socio("UComun 5", "nombre5", "apellido5", "correo5",fecha.toString());
		//Socio s6= new Socio("UComun 6", "nombre6", "apellido6", "correo6",fecha.toString());
		
		//iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 7", "nombre7", "apellido7", "correo7",fecha.toString());
		//iUser.altaUsuario(TipoUsuario.UsuarioComun, "UComun 8", "nombre8", "apellido8", "correo8",fecha.toString());
		
		
		//busqueda/cosulta usuarios
		//profesor
		
		System.out.println("buscando usuario profesor");
		System.out.println("========================================");
		//Usuario up1 = iUser.buscarUsuario("Profesor 1");
		//Usuario up2 = iUser.buscarUsuario("Profesor 2");
		//Usuario up3 = iUser.buscarUsuario("Profesor 3");
		//Usuario up4 = iUser.buscarUsuario("Profesor 4");
		
		//comun
		System.out.println("buscando usuario comun");
		System.out.println("========================================");
		///Usuario uc1 = iUser.buscarUsuario("UComun 1");
		//Usuario uc2 = iUser.buscarUsuario("UComun 2");
		//Usuario uc3 = iUser.buscarUsuario("UComun 3");
		//Usuario uc4 = iUser.buscarUsuario("UComun 4");
		//Usuario uc5 = iUser.buscarUsuario("UComun 5");
		//Usuario uc7 = iUser.buscarUsuario("UComun 7");
		//Usuario uc8 = iUser.buscarUsuario("UComun 8");
		
		System.out.println("consultando usuarios ");
		System.out.println("========================================");
		//me esta faltando ConsultaUsuario() para probar hice esto:
		//donde se esta guardando el tipo de usuario???
		//if uc1 instaceof 
		iUser.consultaUsuario(s1.getNickname());
		iUser.consultaUsuario(s2.getNickname());
		iUser.consultaUsuario(s3.getNickname());
		iUser.consultaUsuario(s4.getNickname());
		
		iUser.consultaUsuario(p1.getNickname());
		iUser.consultaUsuario(p2.getNickname());
		iUser.consultaUsuario(p3.getNickname());
		iUser.consultaUsuario(p4.getNickname());
		
		//Actividad Deportiva://¿1no hay coleccion de actividades?
		
		System.out.println("alta Actividades deportivas");
		System.out.println("========================================");
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		iActividad.altaActividadDeportiva(id1, "nombreActividad 1","descripcion actividad 1", '8',1.1f,fecha);//1.1f es un float
		iActividad.altaActividadDeportiva(id1, "nombreActividad 2","descripcion actividad 2", '7',2.1f,fecha);
		iActividad.altaActividadDeportiva(id2, "nombreActividad 3","descripcion actividad a", '6',3.1f,fecha);
		iActividad.altaActividadDeportiva(id2, "nombreActividad 4","descripcion actividad b", '5',4.1f,fecha);
		iActividad.altaActividadDeportiva(id3, "nombreActividad 5","descripcion actividad 1", '4',5.1f,fecha);
		iActividad.altaActividadDeportiva(id3, "nombreActividad 6","descripcion actividad 2", '3',6.1f,fecha);
		iActividad.altaActividadDeportiva(id4, "nombreActividad 7","descripcion actividad a", '2',7.1f,fecha);
		iActividad.altaActividadDeportiva(id4, "nombreActividad 8","descripcion actividad b", '1',8.1f,fecha);
		//TODO ojo que en alta de actividad deportiva debe rellenarse el array de clase
		
		System.out.println("buscar actividad deportiva");
		System.out.println("========================================");
		/*ActividadDeportiva actividadEncontrada1 = iActividad.buscarActividadDeportiva("nombreActividad 1");
		System.out.println(actividadEncontrada1.getNombre());
		ActividadDeportiva actividadEncontrada2 = iActividad.buscarActividadDeportiva("nombreActividad 2");
		System.out.println(actividadEncontrada2.getNombre());
		ActividadDeportiva actividadEncontrada3 = iActividad.buscarActividadDeportiva("nombreActividad 3");
		System.out.println(actividadEncontrada3.getNombre());
		ActividadDeportiva actividadEncontrada4 = iActividad.buscarActividadDeportiva("nombreActividad 4");
		System.out.println(actividadEncontrada4.getNombre());
		*/
		System.out.println("Consulta(lista de) Actividades Deportivas");
		System.out.println("========================================");
		List<ActividadDeportiva>lad1 = iActividad.consultaActividadDeportiva(id1.getNombre()); //esta no hacia  nada porque no esta?
		List<ActividadDeportiva>lad2 = iActividad.consultaActividadDeportiva(id2.getNombre());
		//List<ActividadDeportiva>lad3 = iActividad.consultaActividadDeportiva(id3.getNombre());
		//List<ActividadDeportiva>lad4 = iActividad.consultaActividadDeportiva(id4.getNombre());
		
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
		
		ActividadDeportiva ad1=id1.buscarActividadDeportiva("nombreActividad 1");
		ActividadDeportiva ad2=id1.buscarActividadDeportiva("nombreActividad 2");
		ActividadDeportiva ad3=id2.buscarActividadDeportiva("nombreActividad 3");
		ActividadDeportiva ad4=id2.buscarActividadDeportiva("nombreActividad 4");
		ActividadDeportiva ad5=id3.buscarActividadDeportiva("nombreActividad 5");
		ActividadDeportiva ad6=id3.buscarActividadDeportiva("nombreActividad 6");
		ActividadDeportiva ad7=id4.buscarActividadDeportiva("nombreActividad 7");
		ActividadDeportiva ad8=id4.buscarActividadDeportiva("nombreActividad 8");
		
		
		
		/*iActividad.altaActividadDeportiva(id1, "nombreActividad 1","descripcion actividad 1", '8',1.1f,fecha);//1.1f es un float
		iActividad.altaActividadDeportiva(id1, "nombreActividad 2","descripcion actividad 2", '7',2.1f,fecha);
		iActividad.altaActividadDeportiva(id2, "nombreActividad 3","descripcion actividad a", '6',3.1f,fecha);
		iActividad.altaActividadDeportiva(id2, "nombreActividad 4","descripcion actividad b", '5',4.1f,fecha);
		iActividad.altaActividadDeportiva(id3, "nombreActividad 5","descripcion actividad 1", '4',5.1f,fecha);
		iActividad.altaActividadDeportiva(id3, "nombreActividad 6","descripcion actividad 2", '3',6.1f,fecha);
		iActividad.altaActividadDeportiva(id4, "nombreActividad 7","descripcion actividad a", '2',7.1f,fecha);
		iActividad.altaActividadDeportiva(id4, "nombreActividad 8","descripcion actividad b", '1',8.1f,fecha);

	*/
		
		//Alta Dictado de clases
		System.out.println("alta dicatado de clases");
		System.out.println("========================================");
		IClase iClase= f.getIClase();/*
		iClase.altaDictadoClase(id1.getNombre(), "nombre Clase 1", fecha, "14:00", "Profesor 1","String url", fecha);
		iClase.altaDictadoClase(id1.getNombre(), "nombre Clase 2", fecha, "15:00", "Profesor 1","String url", fecha);
		iClase.altaDictadoClase(id2.getNombre(), "nombre Clase 3", fecha, "14:00", "Profesor 2","String url", fecha);
		iClase.altaDictadoClase(id2.getNombre(), "nombre Clase 4", fecha, "15:00", "Profesor 2","String url", fecha);
		iClase.altaDictadoClase(id3.getNombre(), "nombre Clase 5", fecha, "14:00", "Profesor 3","String url", fecha);
		iClase.altaDictadoClase(id3.getNombre(), "nombre Clase 6", fecha, "15:00", "Profesor 3","String url", fecha);
		iClase.altaDictadoClase(id4.getNombre(), "nombre Clase 7", fecha, "14:00", "Profesor 4","String url", fecha);
		iClase.altaDictadoClase(id4.getNombre(), "nombre Clase 8", fecha, "15:00", "Profesor 4","String url", fecha);
		*/
		
		//TODO ojo que cuando creamos el ata de actividad depÃ³rtiva deberiamos agregar clases asociadas	
		///Clase(String nombreClase, ActividadDeportiva actividadDeportiva, Date fechaClase, Profesor profesor,String horaInicio, String urlClase, Date fechaRegistro)
				Clase c1 = new Clase("nombre Clase 1",ad1,fecha,p1,"14:00","String url",fecha);
				Clase c2 = new Clase("nombre Clase 2",ad1,fecha,p1,"14:00","String url",fecha);
				Clase c3 = new Clase("nombre Clase 3",ad2,fecha,p2,"14:00","String url",fecha);
				Clase c4 = new Clase("nombre Clase 4",ad2,fecha,p2,"14:00","String url",fecha);
				Clase c5 = new Clase("nombre Clase 5",ad3,fecha,p3,"14:00","String url",fecha);
				Clase c6 = new Clase("nombre Clase 6",ad3,fecha,p3,"14:00","String url",fecha);
				Clase c7 = new Clase("nombre Clase 7",ad4,fecha,p4,"14:00","String url",fecha);
				Clase c8 = new Clase("nombre Clase 8",ad4,fecha,p4,"14:00","String url",fecha);
				
				
				 ArrayList<Clase> clasesitas1= new ArrayList<>();
				 ArrayList<Clase> clasesitas2 = new ArrayList<>();
				 ArrayList<Clase> clasesitas3 = new ArrayList<>();
				 ArrayList<Clase> clasesitas4 = new ArrayList<>();
				 ArrayList<Clase> clasesitas5= new ArrayList<>();
				 ArrayList<Clase> clasesitas6 = new ArrayList<>();
				 ArrayList<Clase> clasesitas7 = new ArrayList<>();
				 ArrayList<Clase> clasesitas8 = new ArrayList<>();
				
				clasesitas1.add(c1);
				clasesitas1.add(c1);
				clasesitas2.add(c2);
				clasesitas2.add(c2);
				clasesitas3.add(c3);
				clasesitas3.add(c3);
				clasesitas4.add(c4);
				clasesitas4.add(c4);
				clasesitas5.add(c5);
				clasesitas6.add(c6);
				clasesitas7.add(c7);
				clasesitas8.add(c8);
			
				ad1.agregarClase(c1);
				ad2.agregarClase(c2);
				ad3.agregarClase(c3);
				ad4.agregarClase(c4);
				/*ad4.setArrayClase(clasesitas4);
				ad5.setArrayClase(clasesitas5);
				ad6.setArrayClase(clasesitas6);
				ad7.setArrayClase(clasesitas7);
				ad8.setArrayClase(clasesitas8);
				*/

	
		//Registro a dictado de Clase del tipo asociativo  dede clase??
		System.out.println("alta registro dictado de clases");
		System.out.println("========================================");
		iClase.registroClase(id1.getNombre(), ad1.getNombre(),"nombre Clase 1", s1.getNombre());//usuario comun  estoy tirando un socio
		iClase.registroClase(id1.getNombre(), ad2.getNombre(),"nombre Clase 2", s2.getNombre());
		iClase.registroClase(id2.getNombre(), ad3.getNombre(),"nombre Clase 1", s3.getNombre());
		iClase.registroClase(id2.getNombre(), ad4.getNombre(),"nombre Clase 2", s4.getNombre());
		iClase.registroClase(id3.getNombre(), ad5.getNombre(),"nombre Clase 1", s1.getNombre());
		iClase.registroClase(id3.getNombre(), ad6.getNombre(),"nombre Clase 2", s2.getNombre());
		iClase.registroClase(id4.getNombre(), ad7.getNombre(),"nombre Clase 1", s3.getNombre());
		iClase.registroClase(id4.getNombre(), ad8.getNombre(),"nombre Clase 2", s4.getNombre());
	}
	

}
