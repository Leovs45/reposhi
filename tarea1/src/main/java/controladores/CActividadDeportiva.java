package controladores;
import java.util.Date;
import interfaces.IActividadDeportiva;
import logica.ActividadDeportiva;


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
