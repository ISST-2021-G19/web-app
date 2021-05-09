package es.upm.dit.isst.edoc.dao;

import org.hibernate.Session;

import es.upm.dit.isst.edoc.model.Departamento;

public class DepartamentoDAOImplementation implements DepartamentoDAO{
	@Override
	public Departamento read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			Departamento departamento = session.get(Departamento.class, email);
	        session.getTransaction().commit();
			session.close();
		return departamento;
	}
}
