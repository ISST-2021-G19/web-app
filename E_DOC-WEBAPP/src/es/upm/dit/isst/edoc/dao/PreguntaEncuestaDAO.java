package es.upm.dit.isst.edoc.dao;

import java.util.List;

import es.upm.dit.isst.edoc.model.PreguntaEncuesta;

public interface PreguntaEncuestaDAO {
	public List<PreguntaEncuesta> readAll( );

	public void create( PreguntaEncuesta preguntaEncuesta );
	public PreguntaEncuesta read( String email );
	public void update( PreguntaEncuesta preguntaEncuesta );
	public void delete( PreguntaEncuesta preguntaEncuesta );
}
