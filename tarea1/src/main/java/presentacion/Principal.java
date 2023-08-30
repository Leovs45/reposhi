/*package presentacion;

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
import presentacion.*;

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

//**************************************************************************************
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
		InstitucionDeportiva institucion = null;
	  // Obtener la fecha actual
	  fechaRegistro = new Date();
	  System.out.println("Fecha de inscripcion: " + fechaRegistro + "\n");
		
		System.out.println("Ingresar nombre de la Institucion: ");
		nombreInstitucion = entrada.nextLine();
		institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
		
		if (institucion == null) {
			System.out.println("No existe la institucion " + nombreInstitucion);
		} else {
			do {
				System.out.println("Ingresar nombre de la actividad:");
				nombre = entrada.nextLine();

				ActividadDeportiva ad = iInstitucion.buscarActividadDeportiva(nombreInstitucion, nombre);
				if (ad != null) {
					System.out.println("Ya existe una actividad con ese nombre.");
					System.out.println("¿Deseas Modificar?");
					System.out.println("  1. Si\n  2. No");
					opt = entrada.nextInt();
								
					switch (opt) {
						case 1: 
							System.out.println("Que deseas modificar? \n    1. Descripcion \n    2. Duracion \n    3. Costo");
							int optModificar;
							optModificar = entrada.nextInt();
										
							switch (optModificar) {
								case 1:
									System.out.println("Ingresar la nueva descripcion:");
									descripcion = entrada.nextLine();
									iActividad.modificarDescripcion(ad.getNombre(), descripcion);
									break;
								case 2:
									System.out.println("Ingresar la duracion en minutos de la actividad:");
									duracionMinutos = entrada.nextInt();
									iActividad.modificarDuracion(ad.getNombre(), duracionMinutos);
									break;
								case 3:
									System.out.println("Ingresar costo:");
									costo = entrada.nextDouble();
									iActividad.modificarCosto(ad.getNombre(), costo);
								break;
							}

							break;
						case 2:
						break;
					}

				} else {
					System.out.println("Ingresar la nueva descripcion:");
					descripcion = entrada.nextLine();
					System.out.println("Ingresar la duracion en minutos de la actividad:");
					duracionMinutos = entrada.nextInt();
					System.out.println("Ingresar costo:");
					costo = entrada.nextDouble();
					
					iActividad.altaActividadDeportiva(institucion, nombre, descripcion, duracionMinutos, costo, fechaRegistro);
				}

				System.out.println("¿Deseas agregar otra actividad deportiva?");
				System.out.println("    1. Si \n    2. No");
				opt = entrada.nextInt();

	  	} while (opt == 1);	
		}
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
			    Date fechaNacimiento = new Date();
			    System.out.print("El usuario es profesor o socio? 1- Profesor 2- Socio ");
			    int op = Integer.parseInt(input.nextLine());
			    switch(op) {
			    case 1:
			    	System.out.print("Institucion: ");
			    	
			        String nombreInstitucion = input.nextLine();
			        InstitucionDeportiva institucion = cInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
			        if(institucion == null) {
			        	System.out.print("No existe una institucion deportiva con ese nombre \n");
			        	aux=0;
			        	break;
			        } else {
				        System.out.print("Descripcion General: ");
				        String descripcionGeneral = input.nextLine();
				        System.out.print("Biografia: ");
				        String biografia = input.nextLine();
				        System.out.print("Sitio Web: ");
				        String sitioWeb = input.nextLine();
			        	iUser.altaUsuario(nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
			        	break;
			        }
			    case 2:
		        	iUser.altaUsuario(nickname, nombre, apellido, correoElectronico, fechaNacimiento);
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
					System.out.println("Ingresa el nueva fecha de nacimiento: ");
					Date nuevaFecha = new Date();
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
	        	System.out.println("Ingresar nickname del profesor: ");
	        	String nomProfe = entrada.nextLine();
						Usuario unProfe = iUsuario.buscarUsuario(nomProfe);
						if(unProfe != null) {
							System.out.print("Este usuario ya existe");
							if(!iUsuario.esProfesor(unProfe.getNombre())) {
								System.out.println(" y no es profesor.");
							}
						}

						System.out.println("Ingresar actividad deportiva: ");

						System.out.println("Ingresar hora inicio: ");
						String horaInicio = entrada.nextLine();
						
						System.out.println("Ingresar url: ");
						String urlClase = entrada.nextLine();
						
						//iClase.altaDictadoClase(nombreClase, ad, fechaClase, nomProfe, horaInicio, urlClase, fechaRegistro);
	        }
		   
		 } while (opt == 1);
	}
	
	static void consultarActividadDeportiva() {
		Fabrica f = Fabrica.getInstancia();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingresa el nombre de la institucion: ");
		String nombreInstitucion = entrada.nextLine();
		
		InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
		
		if (institucion == null) {
			System.out.println("No existe una institucion con el nombre" + nombreInstitucion);
		} else {
			institucion.listarActividades();
			
			ActividadDeportiva ad = null;
			int opt = 1;
			do {
				System.out.println("Elija una opción: ");
				int op = Integer.parseInt(entrada.nextLine());
				ad = institucion.obtenerActividad(op);
				
				if (ad == null) {
					System.out.println(op + " no es una opcion correcta");
					System.out.println("Volver a intentar? \n    1. Si \n    2. No");
					opt = entrada.nextInt();
				}

			} while (ad == null && opt == 1);
			
			if (ad != null) {
				System.out.println(ad.getNombre() + " - " + ad.getDescripcion() + " - " + ad.getDuracionMinutos() + " - " + ad.getCosto() + " - " + ad.getFechaRegistro());
				ad.listarClases();
			}
		}
	}
	
	static void precargarDatos() {
		Fabrica f = Fabrica.getInstancia();
		
		// Creo institucion
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		iInstitucion.altaInstitucionDeportiva("i1", "descripcion", "url");
		iInstitucion.altaInstitucionDeportiva("i2", "descripcion", "url");
		
		// Creo usuario
		IUsuario iUsuario = f.getIUsuario();
		iUsuario.altaUsuario("User1", "Usuario", "1", "mail@false.com", new Date());
		iUsuario.altaUsuario("User2", "Usuario", "1", "mail@false.com", new Date());
		iUsuario.altaUsuario("User3", "Usuario", "1", "mail@false.com", new Date());
		iUsuario.altaUsuario("User4", "Usuario", "1", "mail@false.com", new Date());
		iUsuario.altaUsuario("User5", "Usuario", "1", "mail@false.com", new Date());
		InstitucionDeportiva i1 = iInstitucion.buscarInstitucionDeportiva("i1");
		InstitucionDeportiva i2 = iInstitucion.buscarInstitucionDeportiva("i2");
		iUsuario.altaUsuario("Profe", "Profesor", "Profesoro", "otro@mail.com", new Date(), i1, "Descripcion", "Bio", "sitio web");
		iUsuario.altaUsuario("Profa", "Profesora", "Profesorara", "otro@mail.com", new Date(), i2, "Descripcion", "Bio", "sitio web");
		
		Usuario user1 = iUsuario.buscarUsuario("Profe");
		Usuario user2 = iUsuario.buscarUsuario("Profa");
		
		Usuario u1 = iUsuario.buscarUsuario("User1");
		Usuario u2 = iUsuario.buscarUsuario("User2");
		Usuario u3 = iUsuario.buscarUsuario("User3");
		Usuario u4 = iUsuario.buscarUsuario("User4");
		Usuario u5 = iUsuario.buscarUsuario("User5");
		
		
		Profesor profe1 = (Profesor) user1;
		Profesor profe2 = (Profesor) user2;
		
		// Creo actividades
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		iActividad.altaActividadDeportiva(i1, "a1", "Descripcion", 120, 120, new Date());
		iActividad.altaActividadDeportiva(i1, "a3", "Descripcion", 120, 120, new Date());
		iActividad.altaActividadDeportiva(i2, "a2", "Descripcion", 120, 120, new Date());
		iActividad.altaActividadDeportiva(i2, "a4", "Descripcion", 120, 120, new Date());

		ActividadDeportiva a1 = i1.buscarActividadDeportiva("a1");
		ActividadDeportiva a3 = i1.buscarActividadDeportiva("a3");
		ActividadDeportiva a2 = i2.buscarActividadDeportiva("a2");
		ActividadDeportiva a4 = i2.buscarActividadDeportiva("a4");
	
		// Creo clases
		IClase iClase = f.getIClase();
		//iClase.altaDictadoClase("c1", a1, new Date(), profe1.getNickname(), "12:00", "url", new Date());
		//iClase.altaDictadoClase("c3", a1, new Date(), profe1.getNickname(), "12:00", "url", new Date());
		//iClase.altaDictadoClase("c5", a3, new Date(), profe1.getNickname(), "12:00", "url", new Date());
		//iClase.altaDictadoClase("c2", a2, new Date(), profe2.getNickname(), "12:00", "url", new Date());
		//iClase.altaDictadoClase("c4", a4, new Date(), profe2.getNickname(), "12:00", "url", new Date());
		
		//Creo registros
		// actividad.registroClase(nombreClase, socio);
		
		a1.registroClase("c1", u1);
		a1.registroClase("c1", u2);
		a3.registroClase("c5", u1);
		a3.registroClase("c5", u2);
		a3.registroClase("c5", u3);
		a3.registroClase("c5", u4);
		a3.registroClase("c5", u5);
		a4.registroClase("c4", u3);
		
	}

	public static void consultarPerfilUsuario() {
		Fabrica f = Fabrica.getInstancia();
		IUsuario iUsuario = f.getIUsuario();
		Scanner entrada = new Scanner(System.in);
		
		iUsuario.listarUsuarios();

		if (!iUsuario.existenUsuarios())	{
			System.out.println("  ERROR - No existen usuarios");
		} else {
			System.out.println("Ingresa el nickname del usuario: ");
			String nickname = entrada.nextLine();
			iUsuario.consultaUsuario(nickname);
		}
	}
	
	public static void registroDictadoClase() {
		Fabrica f = Fabrica.getInstancia();
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		IUsuario iUsuario = f.getIUsuario();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingresa la institucion:");
		String nombreInstitucion = entrada.nextLine();
		
		InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
		
		if(institucion == null) {
			System.out.println("  ERROR - No existe una institucion con el nombre " + nombreInstitucion);
		} else {
			if(!institucion.existenActividades()) {
				System.out.println("  ERROR - No existen actividades en esta institucion");
			} else {
				System.out.println("--------------------\nLISTA DE ACTIVIDADES:");
				institucion.listarActividades();
				System.out.println("--------------------");
				System.out.println("Ingresa el nombre de la actividad");
				System.out.println("0. Salir");
				
				String nombreActividad = entrada.nextLine();
				
				if(nombreActividad != "0") {
					ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);
					
					if (actividad != null){
						System.out.println("--------------------\nLISTA DE SOCIOS:");
						iUsuario.listarSocios();
						System.out.println("--------------------");
						System.out.println("Ingresa el nombre del socio que deseas registrar:");
						String nicknameSocio = entrada.nextLine();
						Usuario socio = iUsuario.buscarSocio(nicknameSocio);
						
						if (socio == null) {
							System.out.println("No existe un usuario con el nickname " + nicknameSocio);
						} else {
							System.out.println("--------------------\nLISTA DE CLASES:");
							actividad.listarClases();
							System.out.println("--------------------");
							System.out.println("A que clase lo deseas registrar: ");
							String nombreClase = entrada.nextLine();
							actividad.registroClase(nombreClase, socio);
						}
					}
				}
			}
			
		}
		
	}
	
	public static void rankingActividadesDeportivas() {
		Fabrica f = Fabrica.getInstancia();
		IActividadDeportiva iActividad = f.getIActividadDeportiva();
		List<ActividadDeportiva> actividadesOrdenadas = iActividad.getRankingActividades();
		
		for(ActividadDeportiva a: actividadesOrdenadas) {
			System.out.println(a.getNombre() + " " + a.getCantidadClases());
			//getCosto, getDescripcion
		}
	}
	
	public static void consultaRegistroClase() {
		Fabrica f = Fabrica.getInstancia();
		IInstitucionDeportiva iInstitucion = f.getIInstitucionDeportiva();
		IClase iClase = f.getIClase();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingresa la institucion: ");
		String nombreInstitucion = entrada.nextLine();
		
		InstitucionDeportiva institucion = iInstitucion.buscarInstitucionDeportiva(nombreInstitucion);
		
		if(institucion != null){
			institucion.listarActividades();
			System.out.println("Ingresa el nombre de la actividad: ");
			String nombreActividad = entrada.nextLine();
			ActividadDeportiva actividad = institucion.buscarActividadDeportiva(nombreActividad);
			
			if(actividad != null) {
				actividad.listarClases();
				System.out.println("Ingresa el nombre de la clase: ");
				String nombreClase = entrada.nextLine();
				Clase clase = actividad.buscarClase(nombreClase);
				iClase.consultarDictadoClase(clase);
			} else {
				System.out.println("  ERROR - No existe una institucion con el nombre " + nombreActividad);
			}

		} else {
			System.out.println("  ERROR - No existe una institucion con el nombre " + nombreInstitucion);
		}
	}
	
	public static void rankingDictadoClases() {
		Fabrica f = Fabrica.getInstancia();
		IClase iClase = f.getIClase();
		List<Clase> clasesOrdenadas = iClase.getRankingClases();
		
		for(Clase c: clasesOrdenadas) {
			System.out.println(c.getNombreClase() + " " + c.getCantidadRegistros());
			//getFechaClase getURL
		}
	}
	
	//**************************************************************************************
	
	public static void main(String[] args) {
		//Fabrica f = Fabrica.getInstancia();
		//Scanner input = new Scanner(System.in);
		
		//Tirando_datos td= new Tirando_datos();
		//td.rellenarDatos();
		
	/***
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
			case 2:
				consultarPerfilUsuario();
				break;
			case 3: //Alta de Actividad Deportiva
				agregarActividadDeportiva();
				break;
			case 4: //Consultar actividad deportiva
				consultarActividadDeportiva();
				break;
			case 5:
				agregarClase();
				break;
			case 6: //Registrar socio a clase
				registroDictadoClase();
				break;
			case 7:
				agregarInstitucionDeportiva();
				break;
			case 8:
				modificarUsuario();
				break;
			case 9: // Consultar dictado de clase
				consultaRegistroClase();
				break;
			case 10: //Modificar Actividad Deportiva
				break;
			case 11:
				modificarInstitucionDeportiva();
				break;
			case 12: 
				rankingDictadoClases();
				break;
			case 13: 
				rankingActividadesDeportivas();
				break;
			case 14:
				listarInstituciones();
				break;
			case 15:
				listarUsuarios();
				break;
			case 99:
				precargarDatos();
				break;
			default:
				System.out.print("  ERROR - " + op + " no es una opcion valida");
				break;
		}
	  } while (op != 0);
		
	}
	
}
	*/
