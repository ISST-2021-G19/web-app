package es.upm.dit.isst.edoc.dao;

import java.util.List;

import es.upm.dit.isst.edoc.model.Respuesta;

public interface RespuestaDAO {
	public List<Respuesta> readAll( );

	public void create( Respuesta respuesta );
	public Respuesta read( String email );
	public void update( Respuesta respuesta );
	public void delete( Respuesta respuesta );
}
