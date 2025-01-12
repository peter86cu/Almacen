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
public class PrefacturaController {

	@Autowired
	PrefacturaService service;
	
	@PostMapping(value="prefactura/add",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> crearPrefactura(@RequestBody String datos) {
		return service.crearPrefactura(datos);
		
	}
	
	@GetMapping(value="prefactura/id",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerPrefacturaPorID(@RequestParam("id") String id) {
		
		return service.obtenerPrefacturaPorId(id);
		
	}
	
	@GetMapping(value="prefactura/numero-orden",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> numeroDePrefactura(@RequestParam("fecha") String fecha, @RequestParam("idusuario") String idusuario) {
		
		return service.obtenerNumeroPrefactura(fecha, idusuario);
		
	}
	
	
	@PostMapping(value="prefactura/detalle",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarDetalle(@RequestBody String datos) {		
		return service.guardarDetallePrefactura(datos);
	}
	
	@PostMapping(value="prefactura/delete",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> eliminarDetallePrefactura(@RequestParam("id") int id) {		
		return service.eliminarDetallePrefactura(id);
	}
	
	
	@PostMapping(value="prefactura/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoPrefactura() {		
		return service.listadoPrefacturas();
	}
	
	@PostMapping(value="prefactura/aprobadas",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoPrefacturaModif() {		
		return service.listadoPrefacturasAprobadas();
	}
	
	
	@PostMapping(value="prefactura/modificaciones",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addPrefacturaModif(@RequestBody String datos) {		
		return service.salvarModificaciones(datos);
	}

	@PostMapping(value="prefactura/modificaciones/obtener",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerModificacionesPorIdPrefactura(@RequestParam("id") int id) {		
		return service.obtenerModificacionPrefacturaId(id);
	}
	
	@PostMapping(value="prefactura/cliente",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerCliente(@RequestParam("id") String id) {		
		return service.obtenerClientePorID(id);
	}
	
	@GetMapping(value="prefactura/confirmar-pedido")
	//@ResponseStatus(HttpStatus.CREATED)
	public String confirmarPedido(@RequestParam("id") String id) {		
		return service.confirmarPedido(id);
	}
}
