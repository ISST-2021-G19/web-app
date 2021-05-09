package es.upm.dit.isst.edoc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Encuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Timestamp fecha;
	private String subjectId;
	private String profesorId;
	private String alumnoId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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
