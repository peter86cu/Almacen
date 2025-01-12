package com.ayalait.stock.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ventas_detalle database table.
 * 
 */
@Entity
@Table(name="ventas_detalle")
@NamedQuery(name="VentasDetalle.findAll", query="SELECT v FROM VentasDetalle v")
public class VentasDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_venta_detalle")
	private int idVentaDetalle;

	private BigDecimal cantidad;

	@Column(name="id_moneda_compra")
	private int idMonedaCompra;

	@Column(name="id_moneda_venta")
	private int idMonedaVenta;

	@Column(name="id_producto")
	private String idProducto;

	@Column(name="id_venta")
	private int idVenta;

	@Column(name="precio_compra")
	private BigDecimal precioCompra;

	@Column(name="precio_venta")
	private BigDecimal precioVenta;

	public VentasDetalle() {
	}

	public int getIdVentaDetalle() {
		return this.idVentaDetalle;
	}

	public void setIdVentaDetalle(int idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdMonedaCompra() {
		return this.idMonedaCompra;
	}

	public void setIdMonedaCompra(int idMonedaCompra) {
		this.idMonedaCompra = idMonedaCompra;
	}

	public int getIdMonedaVenta() {
		return this.idMonedaVenta;
	}

	public void setIdMonedaVenta(int idMonedaVenta) {
		this.idMonedaVenta = idMonedaVenta;
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public BigDecimal getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

}