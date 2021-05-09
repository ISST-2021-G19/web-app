package es.upm.dit.isst.edoc.dao;

import org.hibernate.Session;

import es.upm.dit.isst.edoc.model.Subject;

public class SubjectDAOImplementation implements SubjectDAO {
	
	public Subject read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Subject subject = session.get(Subject.class, email);
	        session.getTransaction().commit();
			session.close();
		return subject;
	}
}
