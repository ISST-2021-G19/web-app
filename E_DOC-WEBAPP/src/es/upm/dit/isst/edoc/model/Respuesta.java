package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Respuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "ENCUESTA_ID", referencedColumnName = "ID")
	private Encuesta encuesta;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Encuesta getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	
}
