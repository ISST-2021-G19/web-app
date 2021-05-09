package es.upm.dit.isst.edoc.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nombre;
	private String acronimo;
	private String departamentoId;
	private String profesorId;
	private String alumnoId;
	
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
	public String getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(String departamentoId) {
		this.departamentoId = departamentoId;
	}
	public String getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}
	public String getAlumnoId() {
		return alumnoId;
	}
	public void setAlumnoId(String alumnoId) {
		this.alumnoId = alumnoId;
	}

}
