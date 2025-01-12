package com.ayalait.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.stock.service.*;



@RestController
public class GestionStockController {

	@Autowired
	StockService service;
	

	
	@PostMapping(value="productos/add",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarProducto(@RequestBody String datos) {
		
		return service.addProductos(datos);
	}	
	
	
	@GetMapping(value="productos/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoProdutos() {
		
		return service.listadoProductos();
		
	}
	
	@DeleteMapping(value="productos/delete",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> eliminarProducto(@RequestParam("id") String id) {
		
		return service.eliminarProductos(id);
	}
	
	@GetMapping(value="productos/busqueda",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerProductoPorId(@RequestParam("id") String id) {
		
		 return service.recuperarProductoPorId(id);
		
	}
	
	@GetMapping(value="productos/obtener-codigo",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerProductoPorCodigo(@RequestParam("codigo") String id) {
		
		 return service.obtenerProductoPorCodigo(id);
		
	}
	
	@GetMapping(value="productos/imagenes",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> imagenesPorProducto(@RequestParam("id") String id) {
		
		return service.imagenesPorProducto(id);
		
	}
	
	@GetMapping(value="productos/detalle",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> detalleProducto(@RequestParam("id") String id) {
		
		return service.detallesPorProductos(id);
		
	}
	
}
