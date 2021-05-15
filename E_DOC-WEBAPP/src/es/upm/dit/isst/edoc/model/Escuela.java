package es.upm.dit.isst.edoc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Escuela implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "ACRONIMO")
	private String acronimo;
	
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
	
}
