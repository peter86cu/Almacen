package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String idproducto;
	private String descripcion;
	private String map;
	private int estado;

	public ProductoDetalles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	

}
