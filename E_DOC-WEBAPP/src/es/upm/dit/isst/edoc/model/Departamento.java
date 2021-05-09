package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nombre;
	private String acronimo;
	private String escuelaID;
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
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	public String getEscuelaID() {
		return escuelaID;
	}
	public void setEscuelaID(String escuelaID) {
		this.escuelaID = escuelaID;
	}
	
}
