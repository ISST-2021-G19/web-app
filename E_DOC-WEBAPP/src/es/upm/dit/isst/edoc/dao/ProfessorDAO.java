package es.upm.dit.isst.edoc.dao;

import java.util.List;

import es.upm.dit.isst.edoc.model.Professor;

public interface ProfessorDAO {
	public Professor login( String email, String password );

	public List<Professor> readAll( );

	public void create( Professor professor );
	public Professor read( String email );
	public void update( Professor professor );
	public void delete( Professor professor );
}
