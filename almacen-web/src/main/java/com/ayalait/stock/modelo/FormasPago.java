package com.ayalait.stock.modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="formas_pagos")
public class FormasPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id_forma_pago;
	
	private String descripcion;
	
	
	
	
	public FormasPago() {
		super();
	}

	

	public String getId_forma_pago() {
		return id_forma_pago;
	}



	public void setId_forma_pago(String id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}



	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	

	
}