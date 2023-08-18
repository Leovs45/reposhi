package presentacion;

import java.util.ArrayList;
import logica.*;
import interfaces.*;
import controladores.*;
import datatypes.*;
import java.util.Date;
import java.util.Scanner;

import interfaces.Fabrica;
public class Principal {
	static Fabrica f = Fabrica.getInstancia();	
	static IUsuario IUser = f.getIUsuario();
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
				   			"13- Ranking de Actividades Deportivas");
	}
	static void AltaUsuario() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nickname: ");
		String nickname = input.nextLine();
		System.out.print("Nombre: ");
	    String nombre = input.nextLine();
	    System.out.print("Apellido: ");
	    String apellido = input.nextLine();
	    System.out.print("Correo Electronico: ");
	    String correoElectronico = input.nextLine();
	    System.out.print("Fecha de Nacimiento: ");
	    String fechaNacimiento = input.nextLine();
	    System.out.print("El usuario es profesor o socio? 1- Profesor 2- Socio ");
	    int op = input.nextInt();
	    switch(op) {
	    case 1:
	    	TipoUsuario tpProfe = TipoUsuario.Profesor;
	    	System.out.print("Institucion: ");
	        String institucion = input.nextLine();
	        System.out.print("Descripcion General: ");
	        String descripcionGeneral = input.nextLine();
	        System.out.print("Biografia: ");
	        String biografia = input.nextLine();
	        System.out.print("Sitio Web: ");
	        String sitioWeb = input.nextLine();
        	IUser.altaUsuario(tpProfe, nickname, nombre, apellido, correoElectronico, fechaNacimiento, institucion, descripcionGeneral, biografia, sitioWeb);
	        
	    	break;
	    case 2:
	    	TipoUsuario tpSocio = TipoUsuario.UsuarioComun;
        	//IUser.altaUsuario(tpSocio, nickname, nombre, apellido, correoElectronico, fechaNacimiento);
	    	break;
	    }
	}
		
	
	public static void main(String[] args) {
		menu();
		Scanner input = new Scanner(System.in);
		int op = Integer.parseInt(input.nextLine());
		switch (op) {
			case 1:
				AltaUsuario();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
}
