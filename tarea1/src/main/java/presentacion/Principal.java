package presentacion;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

import interfaces.*;
import datatypes.*;
import logica.InstitucionDeportiva;
import logica.Usuario;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import interfaces.Fabrica;
import interfaces.IClase;

import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import interfaces.IActividadDeportiva;
import logica.InstitucionDeportiva;
import logica.Profesor;
import logica.Clase;
import logica.ActividadDeportiva;
import controladores.CClase;
import logica.ActividadDeportiva;
import controladores.CInstitucionDeportiva;


public class Principal {
	static Fabrica f = Fabrica.getInstancia();	
	static void menu() {
		System.out.println("\nMENU\n"+
		"1- Agregar Usuario\n" +
		"2- Consultar perfil de usuario\n" +
		"3- Agregar Actividad Deportiva\n" +
		"4- Consultar Actividad Deportiva\n" +
		"5- Agregar Dictado de Clase\n" +
		"6- Registrar socio a Dictado de Clase\n" +
		"7- Agregar Institucion Deportiva\n" +
		"8- Modificar Datos de Usuario\n" +
		"9- Consultar Dictado de Clase\n" +
		"10- Modificar Actividad Deportiva\n" +
		"11- Modificar Institucion Deportiva\n" +
		"12- Ranking de dictado de clases\n" +
		"13- Ranking de Actividades Deportivas\n" +
		"14- Listar instituciones deportivas\n" +
		"15- Listar usuarios\n" +
		"0- Salir");
	}
	
	static void agregarInstitucionDeportiva(){
		Fabrica f = Fabrica.getInstancia();
		IInstitucionDeportiva cInstitucion = f.getIInstitucionDeportiva();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Nombre de la institucion: ");
		String nombre = null;
		int opt = 1;
		nombre = entrada.nextLine();
		
		InstitucionDeportiva institucion = cInstitucion.buscarInstitucionDeportiva(nombre);

		while (institucion != null && opt == 1) {
			System.out.println("Ya existe una institucion con ese nombre.");
			System.out.println("Deseas volver a intentarlo?");
			System.out.println("    1. Si \n    2. No");
			opt = Integer.parseInt(entrada.nextLine());
		  if (opt == 1) {
				System.out.println("Nombre de la institucion: ");
				nombre = entrada.nextLine();
				institucion = cInstitucion.buscarInstitucionDeportiva(nombre);
			}
		}
		
		if(opt == 1) {
			System.out.println("Descripcion de la institucion: ");
			String descripcion = null;
			descripcion = entrada.nextLine();
			
			System.out.println("URL de la institucion: ");
			String url = null;
			url = entrada.nextLine();
			
			cInstitucion.altaInstitucionDeportiva(nombre, descripcion, url);
		}
	}
	
	static void agregarActividadDeportiva() {
	    Fabrica f = Fabrica.getInstancia();
	    IActividadDeportiva iActividad = f.getIActividadDeportiva();
	    IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();

	    Scanner entrada = new Scanner(System.in);

	    String nombreInstitucion;
	    String nombre;
	    String descripcion;
	    int duracionMinutos;
	    double costo;
	    Date fechaRegistro;
	    int opt =1;

	    // Obtener la fecha actual
	    fechaRegistro = new Date();
	    System.out.println("Fecha de inscripcion: " + fechaRegistro + "\n");

	    do {
	        System.out.println("Ingresar nombre de la actividad:");
	        nombre = entrada.nextLine();

	        ActividadDeportiva ad = iActividad.buscarActividadDeportiva(nombre);
	        if (ad != null) {
	            System.out.println("Ya existe una actividad con ese nombre.");
	            System.out.println("¿Deseas Modificar?");
	            System.out.println("  1. Si\n  2. No");
	            opt = entrada.nextInt();
	            entrada.nextLine(); // Limpiar el buffer del scanner

	            if (opt == 1) {
	                System.out.println("Ingresar la descripcion:");
	                descripcion = entrada.nextLine();

	                System.out.println("Ingresar la duracion en minutos de la actividad:");
	                duracionMinutos = entrada.nextInt();
	                entrada.nextLine(); // Limpiar el buffer del scanner

	                System.out.println("Ingresar costo:");
	                costo = entrada.nextDouble();
	                entrada.nextLine(); // Limpiar el buffer del scanner

	                System.out.println("Ingresar nombre de la Institucion:");
	                nombreInstitucion = entrada.nextLine();

	                InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
	                if (institucion == null) {
	                    System.out.println("La institucion deportiva no existe");
	                } else {
	                    iActividad.modificarDescripcion(nombre, descripcion);
	                    iActividad.modificarDuracion(nombre, duracionMinutos);
	                    iActividad.modificarCosto(nombre, costo);
	                    iActividad.modificarInstitucion(nombre, nombreInstitucion);
	                }
	            }
	        } else {
	            System.out.println("Ingresar la descripcion:");
	            descripcion = entrada.nextLine();

	            System.out.println("Ingresar la duracion en minutos de la actividad:");
	            duracionMinutos = entrada.nextInt();
	            entrada.nextLine(); // Limpiar el buffer del scanner

	            System.out.println("Ingresar costo:");
	            costo = entrada.nextDouble();
	            entrada.nextLine(); // Limpiar el buffer del scanner

	            System.out.println("Ingresar nombre de la Institucion:");
	            nombreInstitucion = entrada.nextLine();

	            InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
	            if (institucion == null) {
	                System.out.println("La institucion deportiva no existe");
	            } else {
	                iActividad.altaActividadDeportiva(nombreInstitucion, nombre, descripcion, duracionMinutos, costo, fechaRegistro);
	            }
	        }

	        System.out.println("¿Deseas agregar otra actividad deportiva?");
	        System.out.println("  1. Si\n  2. No");
	        opt = entrada.nextInt();
	        entrada.nextLine(); // Limpiar el buffer del scanner

	    } while (opt == 1);
}
	
	static void modificarInstitucionDeportiva() {
		CInstitucionDeportiva cInstitucion = CInstitucionDeportiva.getInstancia();
		Scanner entrada = new Scanner(System.in);
		int opt, opt2 = 1;
		
		String nombreInstitucion;
		InstitucionDeportiva institucion = null;
		
		System.out.println("Ingresa el nombre de la institucion a modificar");
		nombreInstitucion = entrada.nextLine();
		institucion = cInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
		
		while (institucion == null && opt2 == 1) {
			System.out.println("No existe una institucion con ese nombre");
			System.out.println("Deseas volver a intentarlo?");
			System.out.println("    1. Si \n    2. No");
			opt2 = Integer.parseInt(entrada.nextLine());
			
			if(opt2 == 1) {
				System.out.println("Ingresa el nombre de la institucion a modificar");
				nombreInstitucion = entrada.nextLine();
				institucion = cInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
			}
		}
		
		if(opt2 == 1) {
			System.out.println("\nQue dato deseas modificar?");
			System.out.println("    1. Descripcion \n    2. Url \n    3. Salir");
			opt = Integer.parseInt(entrada.nextLine());
			
			switch (opt) {
				case 1: 
					String descripcion;
					System.out.println("Ingresa la nueva descripcion: ");
					descripcion = entrada.nextLine();
					cInstitucion.modificarDescripcion(nombreInstitucion, descripcion);
					break;
				case 2:
					String url;
					System.out.println("Ingresa la nueva url: ");
					url = entrada.nextLine();
					cInstitucion.modificarUrl(nombreInstitucion, url);
					break;
				case 3:
					break;
				default:
					System.out.println("ERROR - " + opt + " no es una opcion valida");
					break;
			}
		}
	}
	
	static void listarInstituciones() {
		CInstitucionDeportiva cInstitucion = CInstitucionDeportiva.getInstancia();
		cInstitucion.listarInstituciones();

	}

	static void altaUsuario() {
		CInstitucionDeportiva cInstitucion = CInstitucionDeportiva.getInstancia();
		IUsuario iUser = f.getIUsuario();
		int aux=0;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Nickname: ");
			String nickname = input.nextLine();
			Usuario user= iUser.buscarUsuario(nickname);
			if(user != null){
				System.out.print("Ya existe este usuario\n");
				aux =1;
			}
			else {
				System.out.print("Nombre: ");
			    String nombre = input.nextLine();
			    System.out.print("Apellido: ");
			    String apellido = input.nextLine();
			    System.out.print("Correo Electronico: ");
			    String correoElectronico = input.nextLine();
			    System.out.print("Fecha de Nacimiento: ");
			    String fechaNacimiento = input.nextLine();
			    System.out.print("El usuario es profesor o socio? 1- Profesor 2- Socio ");
			    int op = Integer.parseInt(input.nextLine());
			    switch(op) {
			    case 1:
			    	TipoUsuario tpProfe = TipoUsuario.Profesor;
			    	System.out.print("Institucion: ");
			    	
			        String nombreInstitucion = input.nextLine();
			        InstitucionDeportiva institucion = cInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
			        if(institucion != null) {
			        	System.out.print("Ya existe una institucion deportiva con ese nombre");
			        	aux=1;
			        }
			        else {
				        System.out.print("Descripcion General: ");
				        String descripcionGeneral = input.nextLine();
				        System.out.print("Biografia: ");
				        String biografia = input.nextLine();
				        System.out.print("Sitio Web: ");
				        String sitioWeb = input.nextLine();
			        	iUser.altaUsuario(tpProfe, nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
			        	break;
			        }
			    case 2:
			    	TipoUsuario tpSocio = TipoUsuario.UsuarioComun;
		        	iUser.altaUsuario(tpSocio, nickname, nombre, apellido, correoElectronico, fechaNacimiento);
			    	break;
			    }
			}
		}while (aux !=0);
	}
	
	static void modificarUsuario() {
		IUsuario iUsuario = f.getIUsuario();
		Scanner entrada = new Scanner(System.in);
		int opt, opt2 = 1;
		
		String nickname;
		System.out.println("Ingresa el nickname del usuario a modificar: ");
		nickname = entrada.nextLine();
		Usuario user = iUsuario.buscarUsuario(nickname);
		
		while (user == null && opt2 == 1) {
			System.out.println("No existe un usuario con el nickname " + nickname);
			System.out.println("Deseas volver a intentarlo?");
			System.out.println("    1. Si \n    2. No");
			opt2 = Integer.parseInt(entrada.nextLine());
			
			if(opt2 == 1) {
				System.out.println("Ingresa el nickname del usuario a modificar: ");
				nickname = entrada.nextLine();
				user = iUsuario.buscarUsuario(nickname);
			}
		}
		
		if (opt2 == 1) {
			System.out.println("\nQue dato deseas modificar?");
			System.out.println("    1. Nombre \n    2. Apellido \n    3. Fecha de Nacimiento \n    4. Salir");
			opt = Integer.parseInt(entrada.nextLine());
			
			switch(opt) {
				case 1:
					String nuevoNombre;
					System.out.println("Ingresa el nuevo nombre: ");
					nuevoNombre = entrada.nextLine();
					iUsuario.modificarNombre(nickname, nuevoNombre);
					break;
				case 2:
					String nuevoApellido;
					System.out.println("Ingresa el nuevo apellido: ");
					nuevoApellido = entrada.nextLine();
					iUsuario.modificarApellido(nickname, nuevoApellido);
					break;
				case 3:
					String nuevaFecha;
					System.out.println("Ingresa el nueva fecha de nacimiento: ");
					nuevaFecha = entrada.nextLine();
					iUsuario.modificarFechaNacimiento(nickname, nuevaFecha);
					break;
				case 4:
					break;
				default:
					System.out.println("ERROR - " + opt + " no es una opcion valida");
					break;
			}
		}
	}
	
	static void listarUsuarios () {
		IUsuario iUsuario = f.getIUsuario();
		iUsuario.listarUsuarios();
	}
		
	static void agregarClase() {
		 Fabrica f = Fabrica.getInstancia();
		 IActividadDeportiva iActividad = f.getIActividadDeportiva();
		 IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		 IClase iClase = f.getIClase();
		 IUsuario iUsuario = f.getIUsuario();
		 Scanner entrada = new Scanner(System.in);
		 int opt =1;

		 // Obtener la fecha actual
		 Date fechaRegistro = new Date();
		 System.out.println("Fecha de inscripcion: " + fechaRegistro + "\n");
		 
		 //Fecha de clase seteada a mano
		 Date fechaClase = new Date(2023, 7, 21);
	        System.out.println("Fecha de la Clase: " + fechaClase + "\n");
	        
	        
		   System.out.println("Ingresar institución deportiva: ");
		   String instituto = entrada.nextLine();
		   InstitucionDeportiva id = iInstitucion.buscarInstitucionDeportiva(instituto);
		   if (instituto == null) {
               System.out.println("La institucion deportiva no existe");
		   }else{
			   System.out.println("Se eligio la institucion: " + instituto);
			   id.listarActividades();
		   }
		  
		   System.out.println("Elija una opción: ");
		   int op = Integer.parseInt(entrada.nextLine());
		   ActividadDeportiva ad = id.obtenerActividad(op);
		   
		  do {
		   System.out.println("Ingrese el nombre de la clase: ");
		   String nombreClase = entrada.nextLine();
		   Clase claseExistente = ad.buscarClase(nombreClase);
		   
		   if (claseExistente != null) {
               System.out.println("El nombre de la clase ya existe");
               System.out.println("¿Deseas Modificar?");
	           System.out.println("  1. Si\n  2. No");
	           opt = entrada.nextInt();
	           entrada.nextLine(); // Limpiar el buffer del scanner
	           
	           System.out.println("Ingresar nombre de la clase nuevamente: ");
	           String nuevoNomClase = entrada.nextLine();
	            
	        } else {
	        	System.out.println("Ingresar profesor: ");
	        	String nomProfe = entrada.nextLine();
                Usuario unProfe = iUsuario.buscarUsuario(nomProfe);
                if(unProfe != null) {
                	System.out.print("Este usuario ya existe");
                	if(!iUsuario.esProfesor(unProfe)) {
                		System.out.println(" y no es profesor.");
                	}
                }
                
                Profesor profesor = (Profesor) unProfe;

                System.out.println("Ingresar actividad deportiva: ");

                System.out.println("Ingresar hora inicio: ");
                String horaInicio = entrada.nextLine();
                
                System.out.println("Ingresar url: ");
                String urlClase = entrada.nextLine();
                
                iClase.altaDictadoClase(nombreClase, ad, fechaClase, profesor, horaInicio, urlClase, fechaRegistro);
	        }
		   
		 } while (opt == 1);
	}
	
	
//**************************************************************************************

	public static void main(String[] args) {
		Fabrica f = Fabrica.getInstancia();
		Scanner input = new Scanner(System.in);
		int op;
		
		do {
			menu();
			op = Integer.parseInt(input.nextLine());
			
			switch (op) {
			case 0:
				break;
			case 1:
				altaUsuario();
				break;
			case 2: //Consultar perfil usuario
				break;
			case 3: //Alta de Actividad Deportiva
				agregarActividadDeportiva();
				break;
			case 4: //Consultar actividad deportiva
				break;
			case 5:
				agregarClase();
				break;
			case 6: //Registrar socio a clase
				break;
			case 7:
				agregarInstitucionDeportiva();
				break;
			case 8:
				modificarUsuario();
				break;
			case 9: // Consultar dictado de clase
				break;
			case 10: //Modificar Actividad Deportiva
				break;
			case 11:
				modificarInstitucionDeportiva();
				break;
			case 12: // Ranking de dictado de clases
				break;
			case 13: // Ranking de Actividades Deportivas
				break;
			case 14:
				listarInstituciones();
				break;
			case 15:
				listarUsuarios();
				break;
			default:
				System.out.print("  ERROR - " + op + " no es una opcion valida");
				break;
		}
	  } while (op != 0);
		
	}
}
