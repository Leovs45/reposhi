package presentacion;


import java.util.List;
import java.util.Scanner;

import interfaces.*;
import datatypes.*;
import logica.InstitucionDeportiva;
import logica.Usuario;
import controladores.CInstitucionDeportiva;


public class Principal {
	static Fabrica f = Fabrica.getInstancia();	
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
		IInstitucionDeportiva IInstitucion = f.getIInstitucionDeportiva();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Nombre de la institucion: ");
		String nombre = null;
		int opt = 1;
		nombre = entrada.nextLine();
		
		InstitucionDeportiva institucion = IInstitucion.buscarInstitucionDeportiva(nombre);

		while (institucion != null && opt == 1) {
			System.out.println("Ya existe una institucion con ese nombre.");
			System.out.println("Deseas volver a intentarlo?");
			System.out.println("  1. Si \n  2. No");
			opt = Integer.parseInt(entrada.nextLine());
		  if (opt == 1) {
				System.out.println("Nombre de la institucion: ");
				nombre = entrada.nextLine();
				institucion = IInstitucion.buscarInstitucionDeportiva(nombre);
			}
		}
		
		if(opt == 1) {
			System.out.println("Descripcion de la institucion: ");
			String descripcion = null;
			descripcion = entrada.nextLine();
			
			System.out.println("URL de la institucion: ");
			String url = null;
			url = entrada.nextLine();
			
			IInstitucion.altaInstitucionDeportiva(nombre, descripcion, url);
		}
	}
	static void altaUsuario() {
		CInstitucionDeportiva cInstitucion = CInstitucionDeportiva.getInstancia();
		IUsuario IUser = f.getIUsuario();
		int aux=0;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Nickname: ");
			String nickname = input.nextLine();
			Usuario user= IUser.buscarUsuario(nickname);
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
			        	IUser.altaUsuario(tpProfe, nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
			        	break;
			        }
			    case 2:
			    	TipoUsuario tpSocio = TipoUsuario.UsuarioComun;
		        	IUser.altaUsuario(tpSocio, nickname, nombre, apellido, correoElectronico, fechaNacimiento);
			    	break;
			    }
			}
		}while (aux !=0);
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
				altaUsuario();
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
