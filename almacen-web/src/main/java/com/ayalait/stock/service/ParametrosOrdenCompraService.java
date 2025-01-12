package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;


public interface ParametrosOrdenCompraService {

	ResponseEntity<String> listaFormasCobro();
	
	ResponseEntity<String> listaFormasPagos();

	ResponseEntity<String> buscarProveedorPorID(int id);

}
