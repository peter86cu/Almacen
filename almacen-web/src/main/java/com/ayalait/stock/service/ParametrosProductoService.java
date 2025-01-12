package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;


public interface ParametrosProductoService {

	ResponseEntity<String> obtenerTiposProductos();

	ResponseEntity<String> obtenerCategorias();

	ResponseEntity<String> obtenerUM();

	ResponseEntity<String> obtenerImpuesto();

	ResponseEntity<String> obtenerMoneda();

	ResponseEntity<String> obtenerPlazos();

	ResponseEntity<String> obtenerDepositos();

	ResponseEntity<String> obtenerClientePorCI(String ci);
	
	ResponseEntity<String> obtenerClientePorId(String id);
	
	ResponseEntity<String> buscarProveedorPorID(int id);
	
	ResponseEntity<String> valorDefectoMoneda();
	
	ResponseEntity<String> marcasProducto();
	
	ResponseEntity<String> modelosProducto();


}
