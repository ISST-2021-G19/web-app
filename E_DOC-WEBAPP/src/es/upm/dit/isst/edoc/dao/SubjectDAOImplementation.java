package es.upm.dit.isst.edoc.dao;

import org.hibernate.Session;

import es.upm.dit.isst.tfg.dao.SessionFactoryService;
import es.upm.dit.isst.tfg.model.Professor;

public class SubjectDAOImplementation implements SubjectDAO {
	

	public SubjectList read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Subject professor = session.get(Professor.class, email);
	        session.getTransaction().commit();
			session.close();
		return professor;
	}
}
