package es.upm.dit.isst.edoc.dao;

import org.hibernate.Session;

import es.upm.dit.isst.edoc.model.Escuela;
//Comment
public class EscuelaDAOImplementation implements EscuelaDAO {

	@Override
	public Escuela read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Escuela escuela = session.get(Escuela.class, email);
	        session.getTransaction().commit();
			session.close();
		return escuela;
	}

}
