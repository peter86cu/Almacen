package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;



@Entity
@Table(name = "stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_stock")
	private int idStock;
	
	@Column(name="id_producto")
	private String idProducto;
	
	
	private double cantidad;
	
	private double precio;
	
	@Column(name="costo_contable")
	private double costoContable;
	
	@Column(name="metodo_evaluacion")
	private String metodoEvaluacion;
	
	@Column(name="id_sucursal")
	private int idSucursal;
	
	@Column(name="id_moneda")
	private int idMoneda;
	
	
	@Column(name="id_unidad_medida")
	private int idUnidadMedida;
	
	
	public int getIdStock() {
		return idStock;
	}


	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}


	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getCostoContable() {
		return costoContable;
	}


	public void setCostoContable(double costoContable) {
		this.costoContable = costoContable;
	}


	public String getMetodoEvaluacion() {
		return metodoEvaluacion;
	}


	public void setMetodoEvaluacion(String metodoEvaluacion) {
		this.metodoEvaluacion = metodoEvaluacion;
	}


	public int getIdSucursal() {
		return idSucursal;
	}


	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}


	public int getIdMoneda() {
		return idMoneda;
	}


	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}


	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}


	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}


	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
