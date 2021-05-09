package es.upm.dit.isst.edoc.dao;

import es.upm.dit.isst.edoc.model.Encuesta;

public interface EncuestaDAO {
	public void create( Encuesta encuesta );
	public Encuesta read( String email );
	public void update( Encuesta encuesta );
	public void delete( Encuesta encuesta );
}
