package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;


public interface ShoppingService {

ResponseEntity<String> guardarCarrito(String datos);
	
ResponseEntity<String> recuperarCarrito(String idCart, String idUsuario);

ResponseEntity<String> obtenerCarritoPorUsuario(String idUsuario);

ResponseEntity<String> obtenerEstadoCarritoPor(int id);

ResponseEntity<String> obtenerNumeroOrdenAGenerar();

ResponseEntity<String> crearOrdenPago(String datos);

ResponseEntity<String> obtenerOrdePagoId(String idpago);

ResponseEntity<String> listadoOrdenesPorUsuario(String id);

	


	
	
}
