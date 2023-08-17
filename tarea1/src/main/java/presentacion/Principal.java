package presentacion;

import java.util.Scanner;

import interfaces.Fabrica;
import logica.InstitucionDeportiva;
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
			case 3:
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
