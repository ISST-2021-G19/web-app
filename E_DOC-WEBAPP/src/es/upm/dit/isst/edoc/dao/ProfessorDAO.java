package es.upm.dit.isst.edoc.dao;

import java.util.List;

import es.upm.dit.isst.edoc.model.Profesor;

public interface ProfessorDAO {
	public Profesor login( String email, String password );

	public List<Profesor> readAll( );

	public void create( Profesor professor );
	public Profesor read( String email );
	public void update( Profesor professor );
	public void delete( Profesor professor );
}
