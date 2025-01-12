package com.ayalait.stock.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.stock.service.*;


@RestController
public class ParametroFacturaController {
	
	@Autowired
	ParametroFacturaService service;
	
	
	
	@GetMapping(value="parametros/monedas",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDeMonedas() throws Exception {
		return service.obtenerMonedas();
		
	}
	
	@GetMapping(value="parametros/depositos",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDepositos() throws Exception {
		return service.obtenerDepositos();
		
	}
	
	@PostMapping(value="parametros/cliente/add",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addCliente(@RequestBody String datos) {
		return service.guardarCliente(datos);
		
	}

}
