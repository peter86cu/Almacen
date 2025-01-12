package com.ayalait.stock.vo;

import java.util.List;

import com.ayalait.stock.modelo.*;



public class ResponseCart {
	
	private ShoppingCart cart;
	private List<ShoppingCartDetailResponse> detalle;
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public List<ShoppingCartDetailResponse> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<ShoppingCartDetailResponse> detalle) {
		this.detalle = detalle;
	}
	

}
