package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "producto_marca")
public class MarcaProducto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_marca;
	private int id_categoria;
	private String marca;
	private int estado;
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public MarcaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
