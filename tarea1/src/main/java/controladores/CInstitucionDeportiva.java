package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Profesor;
import logica.Registro;

public class CInstitucionDeportiva implements IInstitucionDeportiva {
	
	private List<InstitucionDeportiva> instituciones = new ArrayList<>();
	
	private static CInstitucionDeportiva instancia = null;
	
	public static CInstitucionDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CInstitucionDeportiva();
		return instancia;
	}

	@Override
	public void altaInstitucionDeportiva(String nombre, String descripcion, String url) {
		InstitucionDeportiva institucion = new InstitucionDeportiva(nombre, descripcion, url);
		instituciones.add(institucion);
		System.out.println("OK  -  La institucion fue creada correctamente");
	}
	
	// Recibe un string y devuelve una institución deportiva con ese nombre
	// Si no existe una institución deportiva con ese nombre devuelve null
	@Override
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva institucion = null;
		if (instituciones.size() == 0) {
			return institucion;
		} else {
			for(InstitucionDeportiva i: instituciones) {
				if (i.getNombre().equals(nombre)) {
					institucion = i;
				}
			}
		}

		return institucion;
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarDescripcion(String nombreInstitucion, String nuevaDescripcion) {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		institucion.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarUrl(String nombreInstitucion, String nuevoUrl) {
		InstitucionDeportiva institucion = buscarInstitucionDeportiva(nombreInstitucion);
		institucion.setUrl(nuevoUrl);
	}
	
	/**********************************/
	// ADICIONALES
	/**********************************/
	
	@Override
	public void listarInstituciones() {
		if(instituciones.size() == 0) {
			System.out.println("  ERROR - No existe ninguna institucion deportiva creada");
		} else {
			for (InstitucionDeportiva i: instituciones) {
				System.out.println(i.getNombre() + " " + i.getDescripcion() + " " + i.getUrl());
			}
		}
	}
	
	@Override
	public void listarActividadesDeportivas(InstitucionDeportiva institucion) {
		//Lista las actividades deportivas de la institución que se le pasa
		
		//Me quedo el array de actividades deportivas de la institución
		ArrayList<ActividadDeportiva> listaActividades = institucion.getArrayActividadDeportiva();		
		
		if(listaActividades.size() == 0) {
			System.out.println(" \n ERROR - No existe ninguna actividad para esta institucion");
		} else {
			//indice para recorrer el arreglo y darle un numerito pa seleccionar al usuario
			int indes = 1;
			for (ActividadDeportiva a: listaActividades) {
				System.out.println( indes + " - " + "Nombre Actovidad Deportiva: " + a.getNombre() + "\n");
			}
			System.out.println("Seleccione número de Clase para más detalles de la misma o 0 para salir: \n");
			Scanner entrada = new Scanner(System.in);
			int opt = Integer.parseInt(entrada.nextLine());
			//opt es 0 para salir, sino, el índice del arreglo (opt-1) al cual tengo que ir a buscar la data
			if (opt!=0) {
				
				System.out.println(" \n Nombre: " + listaActividades.get(opt-1).getNombre() + "\n");
				System.out.println(" Descripcion: " + listaActividades.get(opt-1).getDescripcion() + "\n");
				System.out.println(" Duracion en minutos: " + Integer.toString(listaActividades.get(opt-1).getDuracionMinutos()) + "\n");
				System.out.println(" Costo: " + Double.toString(listaActividades.get(opt-1).getCosto()) + "\n");
				System.out.println(" Fecha de Registro: " + listaActividades.get(opt-1).getFechaRegistro().toString() + "\n");
				System.out.println(" Institucion a la que pertenece: " + listaActividades.get(opt-1).getInstitucion() + "\n");
				ArrayList<Clase> listaClases = listaActividades.get(opt-1).getArrayClase();
				//mismo que con indes para ActividadDeportiva
				int index = 1;
				for (Clase c: listaClases) {
					System.out.println( index + " - " + "Nombre Clase: " + c.getNombreClase() + "\n");
				}
				if (!listaClases.isEmpty()) {
					System.out.println("Seleccione número de Clase para más detalles de la misma o 0 para salir: \n");
					int opt2 = Integer.parseInt(entrada.nextLine());
					if (opt2!=0) {
						System.out.println("Usted ha seleccionado la Clase: " + listaClases.get(opt2-1).getNombreClase() + ".\n");
						System.out.println("Fecha de Clase: " + listaClases.get(opt2-1).getFechaClase().toString() + "\n");
						System.out.println("Profesor: " + listaClases.get(opt2-1).getProfesor().getNombre() + " " + listaClases.get(opt2-1).getProfesor().getApellido() + ".\n");
						System.out.println("Hora de Inicio: " + listaClases.get(opt2-1).getHoraInicio() + ".\n");
						System.out.println("URL de la clase: " + listaClases.get(opt2-1).getUrlClase() + "\n");
						System.out.println("Fecha de registro: " + listaClases.get(opt2-1).getFechaRegistro().toString() + ".\n");
					}
				} else {
					System.out.println(" \n No hay clases asociadas a esta actividad en esta institución");

				}
			}
		}
	}
}
