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
	static Fabrica f; //Esta bien esto?
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

		
	
	public static void main(String[] args) {
		f = Fabrica.getInstancia();
		menu();
		Scanner input = new Scanner(System.in);
		int op = Integer.parseInt(input.nextLine());
		switch (op) {
			case 1:
				//AltaUsuario();
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
