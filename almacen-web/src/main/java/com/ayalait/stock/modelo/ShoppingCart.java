package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idcart;
	private String idusuario;
	private String fechacompra;
	private String fechaentrega;
	private double totalapagar;
	private int idhistestado;
	
	public String getIdcart() {
		return idcart;
	}
	public void setIdcart(String idcart) {
		this.idcart = idcart;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	public String getFechacompra() {
		return fechacompra;
	}
	public void setFechacompra(String fechacompra) {
		this.fechacompra = fechacompra;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public double getTotalapagar() {
		return totalapagar;
	}
	public void setTotalapagar(double totalapagar) {
		this.totalapagar = totalapagar;
	}
	public int getIdhistestado() {
		return idhistestado;
	}
	public void setIdhistestado(int idhistestado) {
		this.idhistestado = idhistestado;
	}
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
