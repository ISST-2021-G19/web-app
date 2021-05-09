package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PreguntaEncuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String texto;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRespuestaId() {
		return respuestaId;
	}
	public void setRespuestaId(String respuestaId) {
		this.respuestaId = respuestaId;
	}
	private String tipo;
	private String respuestaId;
}
