package controladores;

import java.util.ArrayList;
import java.util.Date;
import interfaces.IActividadDeportiva;

import interfaces.IInstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;

public class CActividadDeportiva implements IActividadDeportiva {
	

	private static CActividadDeportiva instancia = null;
	
	public static CActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new CActividadDeportiva();
		return instancia;
	}
	
	public void altaActividadDeportiva(String institucion, String nombreActividad, String descripcion, int duracionMinutos,
			double costo, Date fechaAlta) {
		ActividadDeportiva ActividadDp = new ActividadDeportiva(institucion,nombreActividad,descripcion,duracionMinutos,costo,fechaAlta);
		Actividades.add(ActividadDp);
		System.out.println("OK  -  La institucion fue creada correctamente");
		// TODO Auto-generated method stub
		
	}

	public ActividadDeportiva buscarActividadDeportiva(String nombre){
		ActividadDeportiva Actividad = null;
		if (Actividades.size() == 0) {
			return Actividad;
		} else {
			for(ActividadDeportiva ad: Actividades) {
				if (ad.getNombre().equals(nombre)) {
					Actividad = ad;
				}
			}
		}

		return Actividad;
	}
	@Override
	public void consultaActividadDeportiva(String institucion) {
		// TODO Auto-generated method stub
		/*
		El caso de uso comienza cuando el administrador desea consultar una
		actividad deportiva. En primer lugar, el administrador indica la
		institución que ofrece la actividad deportiva y el sistema lista las
		actividades deportivas asociadas a la misma. El administrador elige una
		de ellas y el sistema devuelve todos los datos de la actividad,
		incluyendo la lista de clases asociadas. Si el administrador selecciona
		una clase asociada a esa actividad deportiva, se muestra la información
		detallada, tal como se indica en el caso de uso Consulta de Dictado de
		Clase.
		*/
				/*
			InstitucionDeportiva instDep = 
			if (instDep.size() == 0) {
				System.out.println("La institución indicada no existe");
			}
			else {
				
			}
					
			public InstitucionDeportiva buscarInstitucionDeportiva(String nombre);
			public void listarInstituciones();
			
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
			*/

	}
	
	public String DevolverNombre(ActividadDeportiva Nombre) {
		return Nombre.getNombre();
	}
	
	/**********************************/
	// OPCIONALES
	/**********************************/

	@Override
	public void modificarInstitucion(String nombreActividad, String nuevaInstitucion) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setInstitucion(nuevaInstitucion);
		
	}

	@Override
	public void modificarDescripcion(String nombreActividad, String nuevaDescripcion) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setDescripcion(nuevaDescripcion);
	}

	@Override
	public void modificarDuracion(String nombreActividad, int nuevaDuracion) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setCosto(nuevaDuracion);
	}

	@Override
	public void modificarCosto(String nombreActividad, double nuevoCosto) {
		// TODO Auto-generated method stub
		ActividadDeportiva ad = buscarActividadDeportiva(nombreActividad);
		ad.setCosto(nuevoCosto);
	}

	@Override
	public void rankingActividades() {
		// TODO Auto-generated method stub
		
	}

}
