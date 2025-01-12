package com.ayalait.stock.modelo;

import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "ordenes_de_compras_detalle")
public class DetalleOrdenCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_orden_de_compra_detalle;
	private String id_producto;
	private int cantidad;
	private int id_orden_compra;
	private double importe;
	private int id_moneda;

	public String getId_producto() {
		return this.id_producto;
	}

	public void setId_producto(final String id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(final int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_orden_de_compra_detalle() {
		return id_orden_de_compra_detalle;
	}

	public void setId_orden_de_compra_detalle(int id_orden_de_compra_detalle) {
		this.id_orden_de_compra_detalle = id_orden_de_compra_detalle;
	}

	public int getId_orden_compra() {
		return id_orden_compra;
	}

	public void setId_orden_compra(int id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(final double importe) {
		this.importe = importe;
	}

	public int getId_moneda() {
		return this.id_moneda;
	}

	public void setId_moneda(final int id_moneda) {
		this.id_moneda = id_moneda;
	}

}
