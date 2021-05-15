package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PreguntaEncuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "TEXTO")
	private String texto;
	@Column(name = "TIPO")
	private String tipo;
	@OneToOne
	@JoinColumn(name = "RESPUESTA_ID", referencedColumnName = "ID")
	private Respuesta respuesta;
	
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
	public Respuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
}
