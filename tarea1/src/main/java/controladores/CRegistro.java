package controladores;
import interfaces.*;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import excepciones.RegistroClaseRepetidoException;
import interfaces.*;
import logica.*;
	
public class CRegistro implements IRegistro {
	Conexion conexion = Conexion.getInstancia();
	EntityManager em = conexion.getEntityManager();
	private static CRegistro instancia = null;

	
	public static CRegistro getInstancia() {
		if (instancia == null)
			instancia = new CRegistro();
		return instancia;
	}
	
	@Override
	public void RegistroDictadoClases(Date FechaRegistro, String unSocio, String unaClase )throws RegistroClaseRepetidoException {
		Fabrica f = Fabrica.getInstancia();
		IUsuario cuser = f.getIUsuario();
		Socio socio = (Socio) cuser.buscarSocio(unSocio);
		IClase cclase = f.getIClase();
		Clase clase = cclase.buscarClase(unaClase);
		boolean existeRegistro = existeRegistro(unSocio, unaClase);
		if(existeRegistro)
			throw new RegistroClaseRepetidoException("Ya existe un registro de esa clase asociado a ese socio");
		else {
			Registro unRegistro = new Registro(FechaRegistro,unSocio,unaClase);
			socio.agregarRegistro(unRegistro);
			clase.agregarRegistro(unRegistro);
			em.getTransaction().begin();
			em.persist(unRegistro);
			em.persist(socio);
			em.persist(clase);
			em.getTransaction().commit();
		}
	}
	@Override
	public boolean existeRegistro(String unSocio, String unaClase) {
		Socio socio = em.find(Socio.class, unSocio);
		Clase clase = em.find(Clase.class, unaClase);
		String consultaRegistros = "SELECT r FROM Registro r WHERE r.socio = :nicknameId AND r.clase = :nombreClase";
		TypedQuery<Registro> queryRegistros = em.createQuery(consultaRegistros, Registro.class);
		queryRegistros.setParameter("nicknameId", socio);
		queryRegistros.setParameter("nombreClase", clase);
		List <Registro> registros = queryRegistros.getResultList();	
		if(registros.size() == 0)
			return false;
		else
			return true;
	}
}
