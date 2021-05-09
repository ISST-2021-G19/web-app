package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Professor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nombre;
	private String email;
	private String departamentoId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(String departamentoId) {
		this.departamentoId = departamentoId;
	}

}
