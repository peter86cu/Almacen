package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;


public interface PrefacturaService {

    ResponseEntity<String> crearPrefactura(String orden);
	
    ResponseEntity<String> obtenerNumeroPrefactura(String fecha, String idUsuario);	
	
    ResponseEntity<String> obtenerPrefacturaPorId(String id);
	
	ResponseEntity<String> guardarDetallePrefactura(String detalle);
	
	ResponseEntity<String> eliminarDetallePrefactura(int id);
	
	ResponseEntity<String> listadoPrefacturas();

	ResponseEntity<String> salvarModificaciones(String datos);
	
	ResponseEntity<String> listadoPrefacturasAprobadas();
	
	ResponseEntity<String> obtenerModificacionPrefacturaId(int idPrefactura);
	
	ResponseEntity<String> obtenerClientePorID(String idCliente);
	
	String confirmarPedido(String idPedido);

	
}
