package com.ayalait.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.stock.service.*;

@RestController
public class ShoppingController {

	@Autowired
	ShoppingService service;

	@GetMapping(value = "shopping/obtener-cart", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> ObtenerCarrito(@RequestParam("idcart") String id, @RequestParam("idusuario") String idUsuario) {
		return service.recuperarCarrito(id, idUsuario);

	}
	
	@GetMapping(value = "shopping/obtener-cart-usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerCarritoPorUsuarioID( @RequestParam("idusuario") String idUsuario) {
		return service.obtenerCarritoPorUsuario(idUsuario);

	}

	@PostMapping(value = "shopping/guardar-cart", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarDetalleFC(@RequestBody String datos) {
		return service.guardarCarrito(datos);
	}
	
	@GetMapping(value = "shopping/obtener-estado-cart", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerEstadoCarritoPorID( @RequestParam("id") int id) {
		return service.obtenerEstadoCarritoPor(id);

	}
	
	
	@GetMapping(value = "shopping/orden-number", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> numerodeOrden() {
		return service.obtenerNumeroOrdenAGenerar();

	}
	
	@PostMapping(value = "shopping/orden/crear", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarOrdenPago(@RequestBody String datos) {
		return service.crearOrdenPago(datos);
	}

	@PostMapping(value = "shopping/orden/obtener", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerOrdenPagoId(@RequestBody String datos) {
		System.out.println("Llego "+datos);
		return service.obtenerOrdePagoId(datos);
	}
	
	@GetMapping(value = "shopping/orden/list-user", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoOrdenesPorUsuario(@RequestParam("id") String id) {
		return service.listadoOrdenesPorUsuario(id);

	}
	

}
