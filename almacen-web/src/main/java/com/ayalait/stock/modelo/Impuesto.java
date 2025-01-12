package com.ayalait.stock.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "impuestos")
public class Impuesto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_impuesto;
	private String descripcion;
	private int estado;
	private int aplicar;


	public int getId_impuesto() {
		return id_impuesto;
	}



	public void setId_impuesto(int id_impuesto) {
		this.id_impuesto = id_impuesto;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	public Impuesto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getAplicar() {
		return aplicar;
	}



	public void setAplicar(int aplicar) {
		this.aplicar = aplicar;
	}
	
	
	
	

}
