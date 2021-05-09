package es.upm.dit.isst.edoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.edoc.model.Respuesta;
import es.upm.dit.isst.edoc.dao.RespuestaDAO;

public class RespuestaDAOImplementation implements RespuestaDAO{

	public static RespuestaDAOImplementation instance;
	private RespuestaDAOImplementation() { }
	public static RespuestaDAOImplementation getInstance() {
		if ( null == instance )
			instance = new RespuestaDAOImplementation();
		return instance;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Respuesta respuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.save(respuesta);
			session.getTransaction().commit();
			session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Respuesta read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Respuesta respuesta = session.get(Respuesta.class, email);
	        session.getTransaction().commit();
			session.close();
		return respuesta;
	}
	
	@Override
	public void update(Respuesta respuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.saveOrUpdate(respuesta);
	        session.getTransaction().commit();
			session.close();
	}
	@Override
	public void delete(Respuesta respuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.delete(respuesta);
	        session.getTransaction().commit();
			session.close();
			}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Respuesta> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Respuesta> respuesta = new ArrayList<Respuesta>();
		respuesta.addAll( session.createQuery("from Respuesta").list() );
		session.getTransaction().commit();
		session.close();
		return respuesta;
	}
}
