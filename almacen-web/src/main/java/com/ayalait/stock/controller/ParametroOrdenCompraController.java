package com.ayalait.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.stock.service.*;

@RestController
public class ParametroOrdenCompraController {

	@Autowired
	ParametrosOrdenCompraService service;

	@GetMapping(value = "parametros/formas-pagos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoFormasPagos() throws Exception {
		return service.listaFormasPagos();

	}

	@GetMapping(value = "parametros/formas-cobros", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listaFormaCobros() throws Exception {
		return service.listaFormasCobro();

	}
	
	@GetMapping(value="parametros/proveedor",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerProveedorPorID(@RequestParam("id") int id) throws Exception {
		return service.buscarProveedorPorID(id);
		
	}

}
