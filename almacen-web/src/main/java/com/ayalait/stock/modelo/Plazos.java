package com.ayalait.stock.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="plazos")
public class Plazos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id_plazo;
	
	private String descripcion;
	
	
	
	
	public Plazos() {
		super();
	}

	

	public String getId_plazo() {
		return id_plazo;
	}

	public void setId_plazo(String id_plazo) {
		this.id_plazo = id_plazo;
	}



	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	

	
}