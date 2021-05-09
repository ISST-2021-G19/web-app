package es.upm.dit.isst.edoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.edoc.model.Encuesta;
import es.upm.dit.isst.edoc.dao.EncuestaDAO;
import es.upm.dit.isst.edoc.dao.SessionFactoryService;

public class EncuestaDAOImplementation implements EncuestaDAO{
	public static EncuestaDAOImplementation instance;
	private EncuestaDAOImplementation() { }
	public static EncuestaDAOImplementation getInstance() {
		if ( null == instance )
			instance = new EncuestaDAOImplementation();
		return instance;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Encuesta encuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.save(encuesta);
			session.getTransaction().commit();
			session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Encuesta read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Encuesta encuesta = session.get(Encuesta.class, email);
	        session.getTransaction().commit();
			session.close();
		return encuesta;
	}
	
	@Override
	public void update(Encuesta encuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.saveOrUpdate(encuesta);
	        session.getTransaction().commit();
			session.close();
	}
	@Override
	public void delete(Encuesta encuesta) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.delete(encuesta);
	        session.getTransaction().commit();
			session.close();
			}
}
