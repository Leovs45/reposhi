package presentacion;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import interfaces.Fabrica;
import interfaces.IActividadDeportiva;
import interfaces.IInstitucionDeportiva;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import controladores.CInstitucionDeportiva;


public class Principal {
	
	Fabrica f = Fabrica.getInstancia();

	static void menu() {
		System.out.println("MENU\n"+
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
		"0- Salir");
	}
	
	static void agregarInstitucionDeportiva() {
		CInstitucionDeportiva cInstitucion = CInstitucionDeportiva.getInstancia();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Nombre de la institucion: ");
		String nombre = null;
		int opt = 1;
		nombre = entrada.nextLine();
		
		InstitucionDeportiva institucion = cInstitucion.buscarInstitucionDeportiva(nombre);

		while (institucion != null && opt == 1) {
			System.out.println("Ya existe una institucion con ese nombre.");
			System.out.println("Deseas volver a intentarlo?");
			System.out.println("  1. Si \n  2. No");
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

		
	//**************************************************************************************		
	public static void main(String[] args) {
		Fabrica f = Fabrica.getInstancia();
		Scanner input = new Scanner(System.in);
		int op;
		
		do {
			menu();
			op = Integer.parseInt(input.nextLine());
			
			switch (op) {
			case 1:
				//AltaUsuario();
				System.out.print("Alta usuario - No implementado");
				break;
			case 2:
				break;
			case 3://Alta de Actividad Deportiva
				agregarActividadDeportiva();
				break;
			case 7:
				agregarInstitucionDeportiva();
				break;
			default:
				break;
		}
	  } while (op != 0);
		
	}
}
