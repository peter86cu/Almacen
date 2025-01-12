package com.ayalait.stock.vo;

import java.util.List;

import com.ayalait.stock.modelo.*;


public class RequestAddProducto {
	
	private Producto producto;
	private String accion;
	private List<ProductoImagenes> imagenes;
	private ProductoDetalles detalle;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public List<ProductoImagenes> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<ProductoImagenes> imagenes) {
		this.imagenes = imagenes;
	}
	public ProductoDetalles getDetalle() {
		return detalle;
	}
	public void setDetalle(ProductoDetalles detalle) {
		this.detalle = detalle;
	}
	
	

}
