package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Profesor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name ="EMAIL")
	private String email;

	@ManyToOne
	@JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")
	private Departamento departamentoId;
	
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
	public Departamento getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(Departamento departamentoId) {
		this.departamentoId = departamentoId;
	}

}
