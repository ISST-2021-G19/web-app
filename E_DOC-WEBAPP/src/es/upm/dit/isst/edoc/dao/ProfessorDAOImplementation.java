package es.upm.dit.isst.edoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.edoc.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.edoc.dao.SessionFactoryService;
import es.upm.dit.isst.edoc.model.Profesor;

public class ProfessorDAOImplementation implements ProfessorDAO {
	public static ProfessorDAOImplementation instance;
	private ProfessorDAOImplementation() { }
	public static ProfessorDAOImplementation getInstance() {
		if ( null == instance )
			instance = new ProfessorDAOImplementation();
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Profesor login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Profesor professor = null;
			session.beginTransaction();
			Query q = session.createQuery("select p from Professor p where p.email = :email and p.password = :password");
			q.setParameter("email", email);
			q.setParameter("password", password);
			List<Profesor> profs = q.getResultList();
			if (profs.size() > 0)
				professor = (Profesor) (q.getResultList().get(0));
	        session.getTransaction().commit();
			session.close();
		return professor;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Profesor professor) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.save(professor);
			session.getTransaction().commit();
			session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Profesor read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Profesor professor = session.get(Profesor.class, email);
	        session.getTransaction().commit();
			session.close();
		return professor;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Profesor> professors = new ArrayList<Profesor>();
		professors.addAll( session.createQuery("from Professor").list() );	
		session.getTransaction().commit();
		session.close();
		return professors;
	}
	@Override
	public void update(Profesor professor) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.saveOrUpdate(professor);
	        session.getTransaction().commit();
			session.close();
	}
	@Override
	public void delete(Profesor professor) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.delete(professor);
	        session.getTransaction().commit();
			session.close();
			}
}
