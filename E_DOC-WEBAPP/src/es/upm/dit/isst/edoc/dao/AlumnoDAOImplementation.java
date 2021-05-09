package es.upm.dit.isst.edoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.edoc.dao.AlumnoDAO;
import es.upm.dit.isst.edoc.model.Alumno;
import es.upm.dit.isst.edoc.dao.SessionFactoryService;

public class AlumnoDAOImplementation implements AlumnoDAO{
	public static AlumnoDAOImplementation instance;
	private AlumnoDAOImplementation() { }
	public static AlumnoDAOImplementation getInstance() {
		if ( null == instance )
			instance = new AlumnoDAOImplementation();
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Alumno login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Alumno alumno = null;
			session.beginTransaction();
			Query q = session.createQuery("select a from Alumno a where a.email = :email and a.password = :password");
			q.setParameter("email", email);
			q.setParameter("password", password);
			List<Alumno> alum = q.getResultList();
			if (alum.size() > 0)
				alumno = (Alumno) (q.getResultList().get(0));
	        session.getTransaction().commit();
			session.close();
		return alumno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Alumno alumno) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.save(alumno);
			session.getTransaction().commit();
			session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Alumno read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Alumno alumno = session.get(Alumno.class, email);
	        session.getTransaction().commit();
			session.close();
		return alumno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.addAll( session.createQuery("from Alumno").list() );	
		session.getTransaction().commit();
		session.close();
		return alumnos;
	}
	@Override
	public void update(Alumno alumno) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.saveOrUpdate(alumno);
	        session.getTransaction().commit();
			session.close();
	}
	@Override
	public void delete(Alumno alumno) {
		Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			session.delete(alumno);
	        session.getTransaction().commit();
			session.close();
			}
}
