package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Respuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String encuestaId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEncuestaId() {
		return encuestaId;
	}
	public void setEncuestaId(String encuestaId) {
		this.encuestaId = encuestaId;
	}

}
