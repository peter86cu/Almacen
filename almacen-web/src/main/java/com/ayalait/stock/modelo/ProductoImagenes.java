package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "producto_imagenes")
public class ProductoImagenes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String idproducto;
	private String imagen;
	private String nombre;
	private int estado;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public ProductoImagenes() {
		super();
		// TODO Auto-generated constructor stub
	}


}
