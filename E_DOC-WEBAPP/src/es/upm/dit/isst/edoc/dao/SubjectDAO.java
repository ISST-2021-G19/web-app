package es.upm.dit.isst.edoc.dao;
import java.util.List;

import es.upm.dit.isst.edoc.model.Subject;

public interface SubjectDAO {
	public List<Subject> readAll( );
	public Subject read( String email );
	public List<Subject> readAll(String id);
}


