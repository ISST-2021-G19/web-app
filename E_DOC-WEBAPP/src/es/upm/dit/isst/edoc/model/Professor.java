package es.upm.dit.isst.edoc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Professor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nombre;
	private String email;
	private String departamentoId;

}
