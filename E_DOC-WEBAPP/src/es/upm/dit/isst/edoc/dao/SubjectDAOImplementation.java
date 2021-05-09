package es.upm.dit.isst.edoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.edoc.model.Subject;

public class SubjectDAOImplementation implements SubjectDAO {
	
	public static SubjectDAOImplementation instance;
	private SubjectDAOImplementation() { }
	public static SubjectDAOImplementation getInstance() {
		if ( null == instance )
			instance = new SubjectDAOImplementation();
		return instance;
	}
	
	@Override
	public Subject read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Subject subject = session.get(Subject.class, email);
	        session.getTransaction().commit();
			session.close();
		return subject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.addAll( session.createQuery("from Professor").list() );	
		session.getTransaction().commit();
		session.close();
		return subjects;
	}
}
