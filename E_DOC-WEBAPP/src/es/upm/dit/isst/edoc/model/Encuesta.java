package es.upm.dit.isst.edoc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Encuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "Fecha")
	private Timestamp fecha;
	
	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name = "PROFESSOR_ID", referencedColumnName = "ID")
	private Profesor profesor;
	
	@ManyToOne
	@JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ID")
	private Alumno alumno;
	
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
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
		
}
