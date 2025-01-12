package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;



public interface OrdenCompraService {

    ResponseEntity<String> crearOrdenCompra(String orden);
	
    ResponseEntity<String> obtenerNumeroOrden(String fecha, String idUsuario);	
	
    ResponseEntity<String> obtenerOrdenCompraPorId(int id);
	
	ResponseEntity<String> guardarDetalleOC(String detalle);
	
	ResponseEntity<String> eliminarDetalleOrdenCompra(int id);

	ResponseEntity<String> salvarModificacionesOC(String datos);
	
}
