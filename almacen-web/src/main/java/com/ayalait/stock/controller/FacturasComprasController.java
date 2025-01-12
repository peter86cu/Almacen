package com.ayalait.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.stock.service.*;

@RestController
public class FacturasComprasController {

	@Autowired
	FacturasCompraService service;

	@GetMapping(value = "factura/compra/id", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerFacturaCompraPorID(@RequestParam("id") int id) {
		return service.obtenerFacturaCompraPorId(id);

	}

	@PostMapping(value = "factura/detalle", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarDetalleFC(@RequestBody String datos) {
		return service.guardarDetalleFactura(datos);
	}

	@PostMapping(value = "factura/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> crearFacturaCompra(@RequestBody String datos) {
		return service.crearFacturaCompra(datos);

	}

	@GetMapping(value = "factura/numero-factura", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> numeroDeFactura(@RequestParam("fecha") String fecha,
			@RequestParam("idusuario") String idusuario) {
		return service.obtenerNumeroFactura(fecha, idusuario);

	}

}
