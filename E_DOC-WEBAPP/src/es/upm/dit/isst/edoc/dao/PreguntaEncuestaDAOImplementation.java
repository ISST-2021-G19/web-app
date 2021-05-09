package es.upm.dit.isst.edoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.edoc.model.PreguntaEncuesta;
import es.upm.dit.isst.edoc.dao.PreguntaEncuestaDAO;

public class PreguntaEncuestaDAOImplementation implements PreguntaEncuestaDAO {
	public static PreguntaEncuestaDAOImplementation instance;
	private PreguntaEncuestaDAOImplementation() { }
	public static PreguntaEncuestaDAOImplementation getInstance() {
		if ( null == instance )
			instance = new PreguntaEncuestaDAOImplementation();
		return instance;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void create(PreguntaEncuesta preguntaEncuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.save(preguntaEncuesta);
			session.getTransaction().commit();
			session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PreguntaEncuesta read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		PreguntaEncuesta preguntaEncuesta = session.get(PreguntaEncuesta.class, email);
	        session.getTransaction().commit();
			session.close();
		return preguntaEncuesta;
	}
	
	@Override
	public void update(PreguntaEncuesta preguntaEncuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.saveOrUpdate(preguntaEncuesta);
	        session.getTransaction().commit();
			session.close();
	}
	@Override
	public void delete(PreguntaEncuesta preguntaEncuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.delete(preguntaEncuesta);
	        session.getTransaction().commit();
			session.close();
			}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PreguntaEncuesta> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<PreguntaEncuesta> preguntaEncuesta = new ArrayList<PreguntaEncuesta>();
		preguntaEncuesta.addAll( session.createQuery("from PreguntaEncuesta").list() );
		session.getTransaction().commit();
		session.close();
		return preguntaEncuesta;
	}
}
