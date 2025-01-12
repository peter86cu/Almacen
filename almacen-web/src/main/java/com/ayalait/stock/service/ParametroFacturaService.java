package com.ayalait.stock.service;


import org.springframework.http.ResponseEntity;


public interface ParametroFacturaService {
	
	ResponseEntity<String> obtenerMonedas();
	ResponseEntity<String> obtenerDepositos();
	ResponseEntity<String> guardarCliente(String cliente);


}
