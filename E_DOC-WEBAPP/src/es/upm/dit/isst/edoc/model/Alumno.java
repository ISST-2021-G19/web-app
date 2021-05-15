 package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Alumno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany
	@JoinColumn(name="ESCUELA_ID", referencedColumnName = "ID")
	private Escuela escuela;
	
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
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}


}
