package com.ayalait.stock.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "producto_tipo_producto")
public class TipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_tipo_producto;
	private String descripcion;
	private int estado;
	
	
	public int getId_tipo_producto() {
		return id_tipo_producto;
	}
	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoProducto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}
