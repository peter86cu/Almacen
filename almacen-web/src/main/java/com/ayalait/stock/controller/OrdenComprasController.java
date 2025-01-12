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
public class OrdenComprasController {

	@Autowired
	OrdenCompraService service;
	
	@PostMapping(value="orden/compras/add",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> crearOrdenCompra(@RequestBody String datos) {
		return service.crearOrdenCompra(datos);
		
	}
	
	@PostMapping(value="orden/compras/modificaciones",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarModificOC(@RequestBody String datos) {
		
		return service.salvarModificacionesOC(datos);
	}
	
	@GetMapping(value="orden/compras/id",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerOrdenCompraPorID(@RequestParam("id") int id) {
		
		return service.obtenerOrdenCompraPorId(id);
		
	}
	
	@GetMapping(value="orden/compras/numero-orden",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> numeroDeOrden(@RequestParam("fecha") String fecha, @RequestParam("idusuario") String idusuario) {
		
		return service.obtenerNumeroOrden(fecha, idusuario);
		
	}
	
	
	@PostMapping(value="orden/compras/detalle",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarDetalleOC(@RequestBody String datos) {		
		return service.guardarDetalleOC(datos);
	}
	
	@PostMapping(value="orden/compras/delete",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> eliminarDetalleOrdenCompra(@RequestParam("id") int id) {		
		return service.eliminarDetalleOrdenCompra(id);
	}
	
	

	
	
}
