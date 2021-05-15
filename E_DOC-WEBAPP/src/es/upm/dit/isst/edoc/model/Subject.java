package es.upm.dit.isst.edoc.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "ACRONIMO")
	private String acronimo;
	
	@ManyToOne
	@JoinColumn(name ="DEPARTAMENTO_ID", referencedColumnName = "ID")
	private Departamento departamento ;
	
	@ManyToOne
	@JoinColumn(name ="PROFESOR_ID", referencedColumnName = "ID")
	private Profesor profesor ;
	
	@ManyToOne
	@JoinColumn(name ="ALUMNO_ID", referencedColumnName = "ID")
	private Alumno alumno ;
	
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
