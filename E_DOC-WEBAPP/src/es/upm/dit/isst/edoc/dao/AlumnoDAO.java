package es.upm.dit.isst.edoc.dao;

import java.util.List;

import es.upm.dit.isst.edoc.model.Alumno;

	public interface AlumnoDAO {
	public Alumno login( String email, String password );

	public List<Alumno> readAll( );

	public void create( Alumno alumno );
	public Alumno read( String email );
	public void update( Alumno alumno );
	public void delete( Alumno alumno );
}
