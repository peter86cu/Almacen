package com.ayalait.stock.vo;


import java.util.List;

import com.ayalait.stock.modelo.*;


public class RequestAddCart {
	
	private ShoppingCart cart;
	private List<ShoppingCartDetail> detalle;
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public List<ShoppingCartDetail> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<ShoppingCartDetail> detalle) {
		this.detalle = detalle;
	}
	 
	
	
	

}
