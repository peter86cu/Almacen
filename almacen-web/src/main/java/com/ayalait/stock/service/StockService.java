package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;


public interface StockService {

ResponseEntity<String> addProductos(String producto);
	
ResponseEntity<String> eliminarProductos(String idProducto);
	
ResponseEntity<String> listadoProductos();	

ResponseEntity<String> recuperarProductoPorId(String id);

ResponseEntity<String> imagenesPorProducto(String id);

ResponseEntity<String> detallesPorProductos(String id);

ResponseEntity<String> obtenerProductoPorCodigo(String codigo);

	
	
}
